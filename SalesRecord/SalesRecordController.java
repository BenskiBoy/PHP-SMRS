import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class SalesRecordController {
	
	//Connection settings
	private static String HOST = "jdbc:mysql://192.168.1.103:3306/phpsales_and_stock?autoReconnect=true&useSSL=false";
	private static String USERNAME = "TestUser";
	private static String PASSWORD = "PhpTestPass";
	
	//Regular expressions for user input validation
	private String dateRegex = "^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d$";
	private String qtyRegex = "^[1-9][0-9]*$";
	
	//*Temporary* - to interact with SQL string generation methods
	private SalesRecordModel srm = new SalesRecordModel ();
	
	
	
	//Method to validate user input
	private Boolean recordCheckRegex (java.sql.Date date, int qty)
	{
		Boolean result = true;
		
		if (!(date.toString()).matches(dateRegex))
		{
			result = false;
		}
		else if (!(qty.toString()).matches(qtyRegex))
		{
			result = false;
		}
		
		return result;
	}
	
	private Boolean addSaleRecord (java.sql.Date date, List<int> itemId, List<double> price, List<int> qty)
	{
		Boolean result = false;
		int incKey = 0;
		int count = price.size();
		
		if (!recordCheckRegex(date, qty))
		{
			throw new IllegalArgumentException("Invalid Input");
		}
		
		try
		{
			Connection con = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
			Statement stmt = con.createStatement();
			stmt.execute(srm.addSaleItem(date));

			ResultSet rs = stmt.GetGeneratedKeys();

			if (rs.next())
			{
				incKey = rs.getInt(1);
			}
			else
			{
				throw new IllegalArgumentException("No Sales Record Found");
			}

			for (int i = 0; i < count; i++)
			{
				result = stmt.execute(srm.addOrderlineItem(incKey, itemId[i], price[i], qty[i]));
			}

			con.close();
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
			e.printStackTrace();
		}
		
		return result;
	}

	private List<SalesRecord> displayAllSaleRecords ()
	{
		ResultSet rs;
		List<SalesRecord> records = new ArrayList<SalesRecord>();
		int saleId;
		java.sql.Date date;

		try
		{
			Connection con = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
			Statement stmt = con.createStatement();

			rs = stmt.executeQuery(srm.displayAllSaleItems());
			
			while(rs.next())
			{
				saleId = rs.getInt("idSalesRecord");
				date = rs.getDate("SaleDate");

				SalesRecord record = new SalesRecord(saleId, date);
				records.Add(record);
			}

			return records;
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
			e.printStackTrace();
		}
	}

	private SalesOrderlineRecord displaySaleRecord (int id)
	{
		int saleId = id;
		java.sql.Date date;
		List<int> itemId = new ArrayList<int>();
		List<double> price = new ArrayList<double>();
		List<int> qty = new ArrayList<int>();
	
		ResultSet rs;
		
		try
		{
			Connection con = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
			Statement stmt = con.createStatement();

			rs = stmt.executeQuery(srm.displaySaleItem(id));
			
			while(rs.next())
			{
				date = rs.getDate("SaleDate");
			}

			rs = stmt.executeQuery(srm.displayOrderlineItem(id));

			while (rs.next())
			{
				itemId.Add(rs.getInt("itemId"));
				price.Add(rs.getDouble("salePrice"));
				qty.Add(rs.getInt("qtySold"));
			}

			SalesOrderlineRecord record = new SalesOrderlineRecord(id, date, itemId, price, qty);
			return record;
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
			e.printStackTrace();
		}
	}
}

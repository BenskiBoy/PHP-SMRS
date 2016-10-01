import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class SalesRecordController {
	
	//Connection settings
	private static String HOST = "jdbc:mysql://10.1.51.129:3306/phpsales_and_stock?autoReconnect=true&useSSL=false";
	//private static String HOST = "jdbc:mysql://192.168.0.15:3306/PhPSales_and_Stock?autoReconnect=true&useSSL=false";
	private static String USERNAME = "root";
	private static String PASSWORD = "password";
	
	//Regular expressions for user input validation
	private String qtyRegex = "^[1-9][0-9]*$";
	
	//*Temporary* - to interact with SQL string generation methods
	private SalesRecordModel srm = new SalesRecordModel ();
	
	//Method to validate user input
	/*
	private Boolean recordCheckRegex (int qty)
	{
		Boolean result = true;
		
		if (!(qty.toString()).matches(qtyRegex))
		{
			result = false;
		}
		
		return result;
	}*/
	
	Boolean addSaleRecord (String date, List<Integer> itemId, List<Double> price, List<Integer> qty)
	{
		Boolean result = false;
		int incKey = 0;
		int count = price.size();
		
		//if (!recordCheckRegex(qty))
		//{
		//	throw new IllegalArgumentException("Invalid Input");
		//}
		
		try
		{
			Connection con = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
			Statement stmt = con.createStatement();
			stmt.executeUpdate(srm.addSaleItem(date), Statement.RETURN_GENERATED_KEYS);

			ResultSet rs = stmt.getGeneratedKeys();

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
				result = stmt.execute(srm.addOrderlineItem(incKey, itemId.get(i), price.get(i), qty.get(i)));
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
		String date;

		try
		{
			Connection con = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
			Statement stmt = con.createStatement();

			rs = stmt.executeQuery(srm.displayAllSaleItems());
			
			while(rs.next())
			{
				saleId = rs.getInt("idSalesRecord");
				date = (rs.getDate("SaleDate")).toString();

				SalesRecord record = new SalesRecord(saleId, date);
				records.add(record);
			}
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
			e.printStackTrace();
		}
		
		return records;
	}

	//Function no longer used. Main functionality removed to avoid error
	private SalesOrderlineRecord displaySaleRecord (int id)
	{
		SalesOrderlineRecord record = null;
		int saleId = id;
		String date = "";
		List<Integer> itemId = new ArrayList<Integer>();
		List<Double> price = new ArrayList<Double>();
		List<Integer> qty = new ArrayList<Integer>();
	
		ResultSet rs;
		
		try
		{
			Connection con = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
			Statement stmt = con.createStatement();

			rs = stmt.executeQuery(srm.displaySaleItem(id));
			
			while(rs.next())
			{
				date = (rs.getDate("SaleDate")).toString();
			}

			rs = stmt.executeQuery(srm.displayOrderlineItem(id));

			while (rs.next())
			{
				itemId.add(rs.getInt("itemId"));
				price.add(rs.getDouble("salePrice"));
				qty.add(rs.getInt("qtySold"));
			}

			//record = new SalesOrderlineRecord(id, date, itemId, price, qty);
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
			e.printStackTrace();
		}
		
		return record;
	}
}

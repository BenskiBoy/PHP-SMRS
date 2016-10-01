import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class Controller {
	private Model mod = new Model ();
	private SalesValue repSaleValue = new SalesValue ();
	private ItemQtyPrediction repIdvItemSalePrediction;
	
	private ConnectionInfo CI;
	//private static String IP = "10.1.51.129";
	private static String IP = "192.168.1.100";
	//private static String HOST = "jdbc:mysql://" + IP + ":3306/phpsales_and_stock?autoReconnect=true&useSSL=false";
	private static String HOST = "jdbc:mysql://" + IP + ":3306/PhPSales_and_Stock?autoReconnect=true&useSSL=false";
	//private static String USERNAME = "TestUser";
	//private static String PASSWORD = "PhpTestPass";
	private static String USERNAME = "root";
	private static String PASSWORD = "password";
	public Controller ()
	{
		CI = new ConnectionInfo (HOST, USERNAME, PASSWORD);
	}
	
	public ConnectionInfo getConnectionInfo(){
		return CI;
	}
	
	//
	//Sales Record Methods
	//
	
	Boolean addSaleRecord (String date, List<Integer> itemId, List<Double> price, List<Integer> qty)
	{
		Boolean result = false;
		int incKey = 0;
		int count = price.size();
		
		try
		{
			Connection con = DriverManager.getConnection(CI.getHost(), CI.getUsername(), CI.getPassword());
			Statement stmt = con.createStatement();
			stmt.executeUpdate(mod.addSaleItem(date), Statement.RETURN_GENERATED_KEYS);

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
				result = stmt.execute(mod.addOrderlineItem(incKey, itemId.get(i), price.get(i), qty.get(i)));
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

	public List<SalesRecord> displayAllSaleRecords ()
	{
		ResultSet rs;
		List<SalesRecord> records = new ArrayList<SalesRecord>();
		int saleId;
		String date;

		try
		{
			Connection con = DriverManager.getConnection(CI.getHost(), CI.getUsername(), CI.getPassword());
			Statement stmt = con.createStatement();

			rs = stmt.executeQuery(mod.displayAllSaleItems());
			
			while(rs.next())
			{
				saleId = rs.getInt("idSalesRecord");
				date = (rs.getDate("SaleDate")).toString();

				SalesRecord record = new SalesRecord(saleId, date);
				records.add(record);
			}

			con.close();
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
			e.printStackTrace();
		}
		
		return records;
	}

	public List<SalesOrderlineRecord> displaySaleRecords ()
	{
		List<SalesOrderlineRecord> records = new ArrayList<SalesOrderlineRecord>();
		int orderlineId = 0;
		int saleId = 0;
		int itemId = 0;
		double price = 0;
		int qty = 0;
	
		ResultSet rs;
		
		try
		{
			Connection con = DriverManager.getConnection(CI.getHost(), CI.getUsername(), CI.getPassword());
			Statement stmt = con.createStatement();

			rs = stmt.executeQuery(mod.displayOrderLines());
			
			while(rs.next())
			{
				orderlineId = rs.getInt("idOrderLine");
				itemId = (rs.getInt("itemId"));
				price = (rs.getDouble("salePrice"));
				saleId = (rs.getInt("saleId"));
				qty = (rs.getInt("qtySold"));
				SalesOrderlineRecord rec = new SalesOrderlineRecord(orderlineId, saleId, itemId, price, qty);
				records.add(rec);
				
			}
			con.close();
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
			e.printStackTrace();
		}
		
		return records;
	}
	
	public SalesRecord GetSaleRecord (int saleId)
	{
		String date = "";
	
		SalesRecord rc = null;
		ResultSet rs;
		
		try
		{
			Connection con = DriverManager.getConnection(CI.getHost(), CI.getUsername(), CI.getPassword());
			Statement stmt = con.createStatement();

			rs = stmt.executeQuery(mod.displaySaleRecord(saleId));
			
			while(rs.next())
			{
				date = (rs.getDate("SaleDate")).toString();	
			}
			rc = new SalesRecord(saleId, date);
			
			con.close();
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
			e.printStackTrace();
		}
		
		return rc;
	}


	//
	//Stock Item Methods
	//

	public Boolean insertStockItem(StockItem stock){
		Boolean result = false;
		try
		{
			Connection con = DriverManager.getConnection(CI.getHost(), CI.getUsername(), CI.getPassword());
			Statement stmt = con.createStatement();
			result = stmt.execute(mod.insertSaleItem(stock));
			con.close();
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	public List<StockItem> selectStockItem()
	{
		List<StockItem> result = new ArrayList<StockItem>();
		try
		{
			Connection con = DriverManager.getConnection(CI.getHost(), CI.getUsername(), CI.getPassword());
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(mod.selectStockItem());
			while(rs.next())
			{
				StockItem temp = new StockItem(rs.getInt("idStockItems"), rs.getString("Name"), rs.getString("Manufacturer"), rs.getString("Description"), rs.getDouble("ListPrice"), rs.getInt("StockQuantity"));
				result.add(temp);
			}
			con.close();
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
			e.printStackTrace();
			return result;
		}
		return result;
	}

	public StockItem selectStockItem(int id)
	{
		StockItem result = null;
		try
		{
			Connection con = DriverManager.getConnection(CI.getHost(), CI.getUsername(), CI.getPassword());
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(mod.selectStockItem(id));
			while(rs.next())
			{
				result = new StockItem(rs.getInt("idStockItems"), rs.getString("Name"), rs.getString("Manufacturer"), rs.getString("Description"), rs.getDouble("ListPrice"), rs.getInt("StockQuantity"));
			}
			con.close();
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
			e.printStackTrace();
			return result;
		}
		return result;
	}

	public StockItem selectStockItemByName(String name)
	{
		StockItem result = null;
		try
		{
			Connection con = DriverManager.getConnection(CI.getHost(), CI.getUsername(), CI.getPassword());
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(mod.selectStockItemByName(name));
			while(rs.next())
			{
				result = new StockItem(rs.getInt("idStockItems"), rs.getString("Name"), rs.getString("Manufacturer"), rs.getString("Description"), rs.getDouble("ListPrice"), rs.getInt("StockQuantity"));
			}
			con.close();
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
			e.printStackTrace();
			return result;
		}
		return result;
	}

	public Boolean updateStockItem(int id,StockItem s)
	{
		Boolean result = false;
		try
		{
			Connection con = DriverManager.getConnection(CI.getHost(), CI.getUsername(), CI.getPassword());
			Statement stmt = con.createStatement();
			result = stmt.execute(mod.updateStockItem(id, s));
			con.close();
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
			e.printStackTrace();
			return false;
		}
		return true;
	}

	//
	//Report Generation
	//

	public void generateSaleValueReport (int dataRange)
	{
		repSaleValue.generateReport (dataRange, CI, mod);
	}
}
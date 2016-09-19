//package stockitem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class StockItemController {
	//Connection settings
	//private static String HOST = "jdbc:mysql://10.1.51.129:3306/phpsales_and_stock?autoReconnect=true&useSSL=false";
	private static String HOST = "jdbc:mysql://192.168.0.15:3306/PhPSales_and_Stock?autoReconnect=true&useSSL=false";
	private static String USERNAME = "root";
	private static String PASSWORD = "password";
	
	private StockItemSQLModel SISM = new StockItemSQLModel();
	
	public Boolean insertStockItem(StockItem stock){
		Boolean result = false;
		try
		{
			Connection con = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
			Statement stmt = con.createStatement();
			result = stmt.execute(SISM.insertSaleItem(stock));
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
			Connection con = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(SISM.selectStockItem());
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
			Connection con = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(SISM.selectStockItem(id));
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
			Connection con = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(SISM.selectStockItemByName(name));
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
			Connection con = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
			Statement stmt = con.createStatement();
			result = stmt.execute(SISM.updateStockItem(id, s));
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
	
}

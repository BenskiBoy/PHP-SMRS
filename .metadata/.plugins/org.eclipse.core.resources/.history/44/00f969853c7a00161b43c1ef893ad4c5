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
	private Boolean recordCheckRegex (String date, String qty)
	{
		Boolean result = true;
		
		if (!date.matches(dateRegex))
		{
			result = false;
		}
		else if (!qty.matches(qtyRegex))
		{
			result = false;
		}
		
		return result;
	}
	
	private Boolean addSaleRecord (String name, String date, String qty)
	{
		Boolean result = false;
		
		if (!recordCheckRegex(date, qty))
		{
			throw new IllegalArgumentException("Invalid Input");
		}
		
		try
		{
			Connection con = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
			Statement stmt = con.createStatement();
			result = stmt.execute(srm.addSaleItem(name, date, qty));
			con.close();
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
			e.printStackTrace();
		}
		
		return result;
	}

	private Boolean editSaleRecord (String id, String name, String date, String qty)
	{
		Boolean result = false;
		
		if (!recordCheckRegex(date, qty))
		{
			throw new IllegalArgumentException("Invalid Input");
		}
		
		try
		{
			Connection con = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
			Statement stmt = con.createStatement();
			result = stmt.execute(srm.editSaleItem(id, name, date, qty));
			con.close();
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
			e.printStackTrace();
		}
		
		return result;
	}
	
	private void displaySaleRecord (String id)
	{
		ResultSet rs;
		
		try
		{
			Connection con = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery(srm.displaySaleItem(id));
			con.close();
			
			while(rs.next())
			{
				String output = rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4);
				System.out.println(output);
			}
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
			e.printStackTrace();
		}
	}
	
	private Boolean deleteSaleRecord (String id)
	{
		Boolean result = false;
		
		try
		{
			Connection con = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
			Statement stmt = con.createStatement();
			result = stmt.execute(srm.deleteSaleItem(id));
			con.close();
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
			e.printStackTrace();
		}
		
		return result;
	}

}

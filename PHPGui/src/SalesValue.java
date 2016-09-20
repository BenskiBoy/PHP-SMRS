import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SalesValue {
	private static String salesValueReportHeader = "Start Date, End Date, Total Items Sold, Total Sales Value";
	private static String HOST = "jdbc:mysql://192.168.1.103:3306/phpsales_and_stock?autoReconnect=true&useSSL=false";
	private static String USERNAME = "TestUser";
	private static String PASSWORD = "PhpTestPass";
	private DateFormat df = new SimpleDateFormat("yyyy-mm-dd");

	private SalesRecordModel srm = new SalesRecordModel();

	//Generates total sales value report for a given amount of days as a string in csv format
	//dataRange - positive integer pertaining to amount of days in the past to generate report for
	public String generateSalesValueReport (int dataRange)
	{
		String result = "";
		String startDate = "";
		String endDate = "";
		int itemCount = 0;
		Double priceTotal = 0;
		ResultSet rs;

		startDate = getStartDate(dataRange);
		endDate = getEndDate();

		try
		{
			Connection con = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
			Statement stmt = con.createStatement();

			rs = stmt.executeQuery(srm.fetchSalesValue(startDate));

			//Calculation of itemCount and priceTotal
			while(rs.next())
			{
				itemCount += rs.getInt(1);
				priceTotal += rs.getDouble(2);
			}
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
			e.printStackTrace();
		}

		//generate csv string
		result = startDate + ", " + endDate + ", " + itemCount + ", $" + priceTotal;
		
		return result;
	}

	private String getStartDate (int dataRange)
	{
		String result;
		Date startDate;

		Calender cal = Calender.getInstance();
		cal.add(Calender.DAY_OF_YEAR, -dataRange);
		startDate = cal.getTime();
		df.format(startDate);
		result = startDate.toString();
		return result;
	}

	private String getEndDate ()
	{
		String result;
		Date endDate;

		Calender cal = Calender.getInstance();
		cal.add(Calender.DAY_OF_YEAR);
		endDate = cal.getTime();
		df.format(endDate);
		result = endDate.toString();
		return result;
	}

	public String getSalesValueReportHeader ()
	{
		return salesValueReportHeader;
	}

}

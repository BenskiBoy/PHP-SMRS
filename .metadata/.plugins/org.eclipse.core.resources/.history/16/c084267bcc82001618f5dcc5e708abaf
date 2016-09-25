import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SalesValue {
	private static String fileName = "Sale_Value.csv";
	private static String header = "Start Date, End Date, Total Items Sold, Total Sales Value";
	private DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	private ReportCsvFileWriter writer = new ReportCsvFileWriter ();

	public boolean generateReport (int dataRange, Controller CI, Model mod)
	{
		boolean result = false;
		result = writer.writeCsvReportToFile (fileName, header, generateSalesValueReport(dataRange, CI, mod));
		return result;
	}

	//Generates total sales value report for a given amount of days as a string in csv format
	//dataRange - positive integer pertaining to amount of days in the past to generate report for
	public String[] generateSalesValueReport (int dataRange, ConnectionInfo CI, Model mod)
	{
		String[] result;
		String startDate = "";
		String endDate = "";
		int itemCount = 0;
		Double priceTotal = 0.0;
		ResultSet rs;

		startDate = getStartDate(dataRange);
		endDate = getEndDate();

		try
		{
			Connection con = DriverManager.getConnection(CI.getHost, CI.getUsername, CI.getPassword);
			Statement stmt = con.createStatement();

			rs = stmt.executeQuery(mod.fetchSalesValue(startDate));

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
		result[0] = startDate + ", " + endDate + ", " + itemCount + ", $" + priceTotal;
		
		return result;
	}

	private String getStartDate (int dataRange)
	{
		String result;
		Date startDate;

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, -dataRange);
		startDate = cal.getTime();
		result = df.format(startDate);
		return result;
	}

	private String getEndDate ()
	{
		String result;
		Date endDate;

		Calendar cal = Calendar.getInstance();
		endDate = cal.getTime();
		result = df.format(endDate);
		return result;
	}

	public String getSalesValueReportHeader ()
	{
		return salesValueReportHeader;
	}

}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Determines and predicts the sale quantity of a database item and creates a CSV report
 * @author Owen
 *
 */
public class ItemQtyPrediction {
	//Knows
	private static String outputFile = "";
	private static String itemQuantityReportHeader = "ItemID, ItemName, Qty Sold, Sale Period, Fortnightly Rate, Remaining Qty, Required Qty";
	private static String HOST = "jdbc:mysql://192.168.1.103:3306/phpsales_and_stock?autoReconnect=true&useSSL=false";
	private static String USERNAME = "TestUser";
	private static String PASSWORD = "PhpTestPass";
	private static double rateMetric = 14; //number of days over which the rate applies
	
	
	
	private DateFormat df;
	public ItemQtyPrediction(){
		df = new SimpleDateFormat("yyyy-MM-dd");
		
	}
	
	//Can do
	/**
	 * Generates a CSV report for a single item predicting its future sale quantity
	 * @param itemId Database Id value of the requested item
	 * @param dateRange Range for report history in whole days
	 * @param forwardPrediction Range for forward sales prediction in whole days
	 * @return CSV format single report line for one item
	 */
	public String generateSingleItemReport(int itemId, int dataRange, int forwardPrediction){
		//get oldest date
		Calendar cal = Calendar.getInstance();
		//Date initDate = cal.getTime();
		//System.out.println("Current date: " + df.format(initDate));
		cal.add(Calendar.DAY_OF_YEAR, -dataRange);
		Date rangeStart = cal.getTime();
		System.out.println("Range start date: " + df.format(rangeStart));
		
		//determine list of orders within date range
		String order = 
				"SELECT orderline.qtySold, salesrecord.SaleDate "
				+ "FROM orderline "
				+ "INNER JOIN salesrecord "
				+ "ON orderline.saleId = salesrecord.idSalesRecord "
				+ "WHERE orderline.itemId = " + itemId 
				+ " AND salesrecord.SaleDate >= '" + df.format(rangeStart) + "';";
		int index = 0;
		int qtyCount = 0;
		try{
			Connection con = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(order);
			while(rs.next()){
				System.out.println("Index: " + index + " Qty: " + rs.getInt(1) + " date: " + df.format(rs.getDate(2)));
				index++;
				qtyCount += rs.getInt(1);
			}
			System.out.println("Total Qty: " + qtyCount);
		}catch(Exception e){
			e.printStackTrace();
		}		
		
		//determine sales rate per item
		double salesRate = rateMetric * qtyCount/dataRange;
		System.out.println("Qty Sale Rate: " + salesRate);
		
		//generate csv line
		return "";
	}
	
	/**
	 * The CSV header for the report file
	 * @return
	 */
	public String getItemQuantityReportHeader(){		
		return itemQuantityReportHeader;
	}
}

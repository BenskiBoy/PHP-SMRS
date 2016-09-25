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
	
	//Properties
	private static String outputFile = "";
	private static String itemQuantityReportHeader = "ItemID, ItemName, Qty Sold, Sale Period, Fortnightly Rate, Remaining Qty, Required Qty";
	private static ConnectionInfo conInfo = null;
	private static double rateMetric = 14; //number of days over which the rate applies
	private DateFormat df;
	private ReportCsvFileWriter writer = new ReportCsvFileWriter ();
	
	//Methods	
	public ItemQtyPrediction(ConnectionInfo ci){
		conInfo = ci;
		df = new SimpleDateFormat("yyyy-MM-dd");		
	}
	
	/**
	 * Generates a CSV report for a single item predicting its future sale quantity over a requested period of time.
	 * @param itemId Database Id value of the requested item. Must be confirmed before submitting to this method.
	 * @param dateRange Range for report history in whole days. Must be a positive integer, indicating number of days in the past.
	 * @param forwardPrediction Range for forward sales prediction in whole days
	 * @return CSV format single report line for one item without newline character
	 */
	public String generateSingleItemReport(int itemId, int dataRange, int forwardPrediction){
		String itemName = "";
		int index = 0;
		int qtyCount = 0;
		int currentQty = 0;
		
		//get oldest date that we want to look at
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, -dataRange);
		Date rangeStart = cal.getTime();
	
		try{
			//Establish connection to database
			Connection con = DriverManager.getConnection(conInfo.getHost(), conInfo.getUsername(), conInfo.getPassword());
			Statement stmt = con.createStatement();	
			
			//check that item id corresponds to an actual item and also retrieve its name for the report
			String query = "SELECT name FROM stockitems WHERE idStockItems = '" + itemId + "';";
			ResultSet rsName = stmt.executeQuery(query);
			if(rsName.next()){
				itemName = rsName.getString(1);
				//System.out.println("Item name: " + itemName);
			}
			else
				return "null";
		
			//determine list of orders within date range that contain the given itemId and retrieve quantity sold for each orderline
			String order = 
				"SELECT orderline.qtySold, salesrecord.SaleDate "
				+ "FROM orderline "
				+ "INNER JOIN salesrecord "
				+ "ON orderline.saleId = salesrecord.idSalesRecord "
				+ "WHERE orderline.itemId = " + itemId 
				+ " AND salesrecord.SaleDate >= '" + df.format(rangeStart) + "';";
			ResultSet rs = stmt.executeQuery(order);
			
			//Determine total quantity count
			while(rs.next()){
				//System.out.println("Index: " + index + " Qty: " + rs.getInt(1) + " date: " + df.format(rs.getDate(2)));
				index++;
				qtyCount += rs.getInt(1);
			}
			//System.out.println("Total Qty: " + qtyCount);
			
			//Retrieve current stock quantity
			String qtyQuery = "SELECT stockquantity FROM stockItems WHERE idStockItems ='" + itemId + "';";
			ResultSet rsQty = stmt.executeQuery(qtyQuery);
			if(rsQty.next()){
				currentQty = rsQty.getInt(1);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}		
		
		//determine sales rate per item
		double salesRate = rateMetric * qtyCount/dataRange;
		//System.out.println("Qty Sale Rate: " + salesRate);
		
		//predict sales over forward estimate period
		double futureSales = salesRate * forwardPrediction / rateMetric;
		//System.out.println("Forward prediction: " + futureSales);
		
		//generate csv line
		String output = itemId + ", " + itemName + ", " + qtyCount + ", " + dataRange + ", " + salesRate + ", " + currentQty + ", " + futureSales;
		//System.out.println(itemQuantityReportHeader);
		//System.out.print(output);
		return output;
		
	}
	
	/**
	 * The CSV header for the report file
	 * @return
	 */
	public String getItemQuantityReportHeader(){		
		return itemQuantityReportHeader;
	}
}

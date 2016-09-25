
public class testMain {
	static ItemQtyPrediction predict;
	
	private static String IP = "192.168.1.103";
	private static String HOST = "jdbc:mysql://" + IP + ":3306/phpsales_and_stock?autoReconnect=true&useSSL=false";
	private static String USERNAME = "TestUser";
	private static String PASSWORD = "PhpTestPass";
	
	public static void main(String[] args) {
		ConnectionInfo ci = new ConnectionInfo(HOST, USERNAME, PASSWORD);
		predict = new ItemQtyPrediction(ci);
		String[] rows = new String[1];
		System.out.println("Predicting");
		rows[0] = predict.generateSingleItemReport(11,120, 28);
		ReportCsvFileWriter rcfw = new ReportCsvFileWriter();		
		if(rcfw.writeCsvReportToFile("itemPrediction.csv", predict.getItemQuantityReportHeader(), rows)){
			System.out.println("File write successful");
		}else{
			System.out.println("File write unsuccessful");
		}
		
	}
}


public class testMain {
	static ItemQtyPrediction predict;
	
	//private static String IP = "192.168.1.103";
	private static String IP = "10.1.51.129";
	private static String HOST = "jdbc:mysql://" + IP + ":3306/phpsales_and_stock?autoReconnect=true&useSSL=false";
	private static String USERNAME = "TestUser";
	private static String PASSWORD = "PhpTestPass";
	
	public static void main(String[] args) {
		
		ConnectionInfo ci = new ConnectionInfo(HOST, USERNAME, PASSWORD);
		predict = new ItemQtyPrediction(ci);
		String[] rows = new String[3];
		System.out.println("Predicting");
		rows[1] = predict.generateSingleItemReport(100,350, 60);
		rows[2] = predict.generateSingleItemReport(50,350, 14);
		rows[0] = predict.generateSingleItemReport(11,350, 28);
		ReportCsvFileWriter rcfw = new ReportCsvFileWriter();		
		if(rcfw.writeCsvReportToFile("itemPrediction.csv", predict.getItemQuantityReportHeader(), rows)){
			System.out.println("File write successful");
		}else{
			System.out.println("File write unsuccessful");
		}
		
	}
}

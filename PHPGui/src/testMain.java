
public class testMain {
	static ItemQtyPrediction predict;
	public static void main(String[] args) {
		predict = new ItemQtyPrediction();
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

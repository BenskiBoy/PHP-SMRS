import java.awt.List;
import java.io.FileWriter;
import java.util.ArrayList;

public class ReportCsvFileWriter {
	private static final String NEW_LINE = "\n";

	public boolean writeCsvReportToFile(String fileName, String header, ArrayList<String> rows){
		boolean result = false;
		FileWriter fw = null;
		try{
			fw = new FileWriter(fileName);
			
			fw.append(header.toString());
			fw.append(NEW_LINE);
			
			for(int i = 0; i < rows.size(); i++){
				fw.append(String.valueOf(rows.get(i)));
				fw.append(NEW_LINE);
			}
			result = true;
		}catch(Exception e){
			e.toString();
			result = false;
		}finally{
			try{
				fw.flush();
				fw.close();
			}catch(Exception e){
				e.toString();
			}
		}
		return result;
	}
}

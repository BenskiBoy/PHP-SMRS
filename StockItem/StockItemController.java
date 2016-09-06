package stockitem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class StockItemController {
	//Connection settings
	private static String HOST = "jdbc:mysql://192.168.1.103:3306/phpsales_and_stock?autoReconnect=true&useSSL=false";
	private static String USERNAME = "TestUser";
	private static String PASSWORD = "PhpTestPass";
}


public class ConnectionDetails {
	private static String HOST = "";
	private static String USERNAME = "";
	private static String PASSWORD = "";
	
	public ConnectionDetails(String host, String username, String password){
		HOST = host;
		USERNAME = username;
		PASSWORD = password;
	}

	public static String getHOST() {
		return HOST;
	}

	public static String getUSERNAME() {
		return USERNAME;
	}

	public static String getPASSWORD() {
		return PASSWORD;
	}
	
}

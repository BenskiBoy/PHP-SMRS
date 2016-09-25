
public class ConnectionInfo {
	
	private static String HOST = "";
	private static String USERNAME = "";
	private static String PASSWORD = "";
	
	public ConnectionInfo(String host, String username, String password){
		HOST = host;
		USERNAME = username;
		PASSWORD = password;
	}
	
	public String getHost(){return HOST;}
	public String getUsername(){return USERNAME;}
	public String getPassword(){return PASSWORD;}
}

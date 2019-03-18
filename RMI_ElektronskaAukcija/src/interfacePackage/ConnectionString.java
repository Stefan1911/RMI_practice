package interfacePackage;

public class ConnectionString {
	public static ConnectionString instance;
	private String host = "rmi://localhost:";
	private int port = 1844;
	private String service = "/Aukcija";
	
	
	public String getConStr() {
		return this.host+this.port+this.service;
	}
	public int getPort() {
		return this.port;
	}
	public static ConnectionString instance() {
		if(instance == null)
			return new ConnectionString();
		return instance;
	}
}

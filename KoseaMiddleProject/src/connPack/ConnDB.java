package connPack;

import java.sql.*;

public class ConnDB {
	String driver = "oracle.jdbc.driver.OracleDriver";
//	String url = "jdbc:oracle:thin:@localhost:1521:orcl";   // School URL
	String url = "jdbc:oracle:thin:@localhost:1521:ChinHR"; // Home URL
	String user = "hrchin";
	String password = "kosea";
	
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	
	public ConnDB() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Statement getST() {
		return stmt;
	}
	
	public ResultSet getRS() {
		return rs;
	}
	
	public Connection getCon() {
		return con;
	}
	
	public void setRS(ResultSet rs) {
		this.rs = rs;
	}
	
}

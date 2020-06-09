package connPack;

import java.sql.*;

public class ConnDB {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	String user = "hrchin";
	String password = "kosea";
	
	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	
	public ConnDB() {
		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("oracle connetion success");
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			System.out.println("statement create success." +"\n\n");
			
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
	
	public void setRS(ResultSet rs) {
		this.rs = rs;
	}
	
}

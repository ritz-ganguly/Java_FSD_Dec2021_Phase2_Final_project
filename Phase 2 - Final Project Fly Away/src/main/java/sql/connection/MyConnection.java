package sql.connection;

import java.sql.Connection;

import java.sql.DriverManager;

public class MyConnection {

	public static Connection establishConnection() {
		 
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "flyaway","flyaway");
			return con;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}

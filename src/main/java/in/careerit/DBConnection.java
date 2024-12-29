package in.careerit;

import java.sql.*;

public class DBConnection {

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
			if (con != null) {
			System.out.println("Connected Sucessfully");
			//con.close();
			} else {
				System.out.println("Failed to connect DB");
			}
		} catch (Exception e) {
			System.out.println("Exception occured: " + e);
		}
		return con;

	}

}

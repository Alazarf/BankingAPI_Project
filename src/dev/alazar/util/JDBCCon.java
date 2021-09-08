package dev.alazar.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBCCon {

	private static Connection conn = null;

	public static Connection getConnection() {

		/*
		 * To establish a connection we need 3 credentials url(endpoint), username, and
		 * password
		 */

		if (conn == null) {

		//	@SuppressWarnings("resource")


			try {
				conn = DriverManager.getConnection("jdbc:mariadb://alazar-1.cte6n7x9kggk.us-east-2.rds.amazonaws.com:3306/Alazar?user=admin&password=passw0rd" );
				//conn = DriverManager.getConnection("jdbc:mariadb://habmaria.cpzt0t3vsqvn.us-east-1.rds.amazonaws.com:3306/Banking?user=habtem&password=Passw0rd");
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return conn;
	}
	public static void main(String[] args) {
		
		Connection conn1 = getConnection();
		System.out.println(conn1);
	}
}

package com.iu.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {
	// 메서드명 getConnect
	public Connection getConnect() throws Exception {

		String username = "scott";
		String password = "tiger";
		String url = "jdbc:oracle:thin:@192.168.56.101:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		Connection conn = null;
		Class.forName(driver);
		conn = DriverManager.getConnection(url, username, password);
		return conn;

	}
}

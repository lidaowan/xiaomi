package com.zrcx.mellit.base;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {

	public Connection getcon() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/xiaomi", "root", "456456");
return connection;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}

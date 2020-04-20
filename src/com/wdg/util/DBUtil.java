package com.wdg.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
	public Connection getConnection() {
		Properties pro=new Properties();
		InputStream in=DBUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
        try {
			pro.load(in);
			String driver = pro.getProperty("driver");
			String url = pro.getProperty("url");
			String username = pro.getProperty("username");
			String password = pro.getProperty("password");
			Class.forName(driver);
			return DriverManager.getConnection(url, username, password);			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void closeConn(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

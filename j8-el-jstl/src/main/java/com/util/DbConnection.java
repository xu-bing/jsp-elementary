package com.util;

import java.sql.*;

public class DbConnection {
	/*private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private static final String USER = "scott";
	private static final String PASSWORD = "tiger";*/
	
	private static final String DRIVER;
	private static final String URL;
	private static final String USER; 
	private static final String PASSWORD;
	
	static {
		DbConfig dbConfig = new DbConfig();
		DRIVER = dbConfig.getValue("driver");
		URL = dbConfig.getValue("url");
		USER = dbConfig.getValue("user");
		PASSWORD = dbConfig.getValue("password");
	}
	
	
	public static Connection getConnection(){
		Connection conn = null;
		
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return conn;
	}	// getConnection
	
	public static void close(ResultSet rs, Statement st, Connection conn){
		
		try {
			if (rs != null){
				rs.close();
			}
			
			if (st != null){
				st.close();
			}
			
			if (conn != null){
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	// close()
	
	public static void main(String[] args) {
		System.out.println(DbConnection.getConnection());
	}
}

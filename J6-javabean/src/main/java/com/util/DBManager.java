package com.util;

import java.sql.*;

public class DBManager {
	// 数据库连接的参数
	private static final String DRIVER;
	private static final String URL;
	private static final String USER;
	private static final String PWD;
	
	// 方式1
	/*
	static{
		DRIVER = "oracle.jdbc.driver.OracleDriver";
		URL = "jdb:oracle:thin:@127.0.0.1:1521:orcl";
		USER = "scott";
		PWD = "tiger";
	}
	*/
	
	// 方式2: 外部文件
	static {
		DBConfig dbConfig = new DBConfig();
		DRIVER = dbConfig.getValue("driver");
		URL = dbConfig.getValue("url");
		USER = dbConfig.getValue("user");
		PWD = dbConfig.getValue("pwd");
	}
	
	// -----------------------------------------------------
	
	public DBManager() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// 建立数据库连接
	public static Connection getConnection(){
		Connection conn = null;
		
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USER, PWD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}	// getConnection();
	
	// 关闭数据库连接、释放资源
	public static void close(ResultSet rs, PreparedStatement psmt, Connection conn){
		try {
			if (rs != null){
				rs.close();
			}
			
			if (psmt != null){
				psmt.close();
			}
			
			if (conn != null){
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} 	// close();
	
	public static void main(String[] args) {
		System.out.println(getConnection());
	}
}	// DBManager

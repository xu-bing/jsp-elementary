package com.util;

import java.sql.*;

import com.util.*;

/**
 * 用来进行数据库连接与关闭
 * @author xab
 *
 */

public class DBManager {
	
	
	// 数据库连接用参数
	private static final String DBDRIVER;
	private static final String DBURL;
	private static final String USER;
	private static final String PASSWORD;
	
	static {
		DBConfig dbConfig = new DBConfig();
		
		DBDRIVER = dbConfig.getValue("dbDriver");
		DBURL = dbConfig.getValue("dbURL");
		USER = dbConfig.getValue("user");
		PASSWORD = dbConfig.getValue("pwd");
	}
	
	public DBManager(){
		super();
	}
	
	public static Connection getConnection(){
		Connection conn = null;
		
		try {
			Class.forName(DBDRIVER);
			
			conn = DriverManager.getConnection(DBURL, USER, PASSWORD);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		return conn;
	}	// getConnection
	
	public static void close(ResultSet rs, PreparedStatement psmt, Connection conn){
		try {
			if(rs != null){
				rs.close();
			}
			
			if(psmt != null){
				psmt.close();
			}
			
			if(conn != null){
				conn.close();
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
	}	// close
	
	public static void main(String[] args){
		System.out.println(getConnection());
	}
}	// DBManager

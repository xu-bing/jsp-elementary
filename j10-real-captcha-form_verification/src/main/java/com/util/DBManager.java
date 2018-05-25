package com.util;

import java.sql.*;

/**
 * 用于数据库连接与关闭
 * @author xab
 *
 */

public class DBManager {
	// --------------------------------------------------------------------------------
	//  数据库连接参数
	// params for connecting db
	private static final String DRIVER;
	private static final String URL;
	private static final String USER;
	private static final String PWD;
	
	//  1. 直接写在代码中
	static{
		DRIVER = "oracle.jdbc.driver.OracleDriver";
		URL = "jdbc:oracle:thin:@127.0.0.1:1521/orcl";
		// ....................:@...............:orcl
		USER = "scott";
		PWD = "tiger";
	}
	
	// 2. 写在外部配置文件中，通过方法访问获得
	
	// 取得配置值
//	static{
//		DBConfig dbConfig = new DBConfig();
//		
//		DRIVER = dbConfig.getValue("driver");
//		URL = dbConfig.getValue("url");
//		USER = dbConfig.getValue("user");
//		PWD = dbConfig.getValue("pwd");
//		
//	}
	
	// ----------------------------------------------------------------------------------

	public DBManager(){
		super();	// 调用父类Object的无参构造方法
	}
	
	
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
		
	
	}	// getConnection
	
	
	/**
	 * close connection, release resources
	 * @param rs
	 * @param ps
	 * @param conn
	 */
	public static void close(ResultSet rs, PreparedStatement psmt, Connection conn){
		
			try {
				if(rs != null){
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
		}	// close
		
	public static void main(String[] args){
		
		System.out.println(getConnection());
		
	}	// main

}	// DBManager

/*
 * 完整的数据库操作：
 * 包括：
 * 连接数据库
 * 数据操作：DML
 * 关闭数据库连接，释放资源
 * 
 * */


/*
 * 静态方法，实例方法的选用
 * 
 * 如果要用属性来存取数据，一般就要用对象
 * 如果只是一些工具方法，那就用静态方法。
 * 
 * */

/*
 * 将数据库参数写在外部文件中的利与弊
 * 
 * 增加前期编码负担，但会减轻后期维护。
 * 硬编码修改：
 * 修改源码 ---> 编译 ---> 重启服务器
 * 
 * 配置文件个性：
 * 修改配置文件 ---> 重新运行程序（需要重启服务器吗？）
 * 
 * 
 */

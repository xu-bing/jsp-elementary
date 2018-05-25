package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
* 可滚动、可更新的结果集
		* 概念：默认的 ResultSet 对象不可更新，仅有一个向前移动的光标。
		* 因此，只能迭代它一次，并且只能按从第一行到最后一行的顺序进行。
		* how创建：
		* 作用：假分页，查询的结果集
*/

public class TestResultSet {

	/**
	 * 结果集的定位、更新
	 *
	 */
	public void updateResultSet(){
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			// 1. 注册数据库驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. 连接数据库
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "tiger");
			
			// 3. 创建可滚动可更新的结果集
			st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			// 4. 取得结果集
			rs = st.executeQuery("SELECT empno, ename FROM emp");
			
			//---------------------------------------- 
			//可滚动 ---> 定位 ----> 取值 
			//可更新			        更新
			
			//-----------------------------------------
			// (1)记录的定位
			// a. 能够定位的条件：scrollable。
			// b. 取值之前一定要先定位，否则：ERR:结果集已耗尽
			rs.absolute(2);	// 表示定位到第2条记录	
			
			System.out.println(rs.getInt("empno"));
			System.out.println(rs.getString(2));
			
			// (2)数据更新
			// 条件：a. 先定位 b.updatable
			rs.updateString("ename", "allen2");
			rs.updateRow();		// 执行更新，更新emp表
			
			// check
			System.out.println(rs.getInt(1) + ":" + rs.getString("ename"));

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {		// 释放资源
			// 5. 关闭连接
			try {
				if(rs != null){
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(st != null){
					st.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(conn != null){
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}	// finally	
		
	}	// updateResultSet
	
	/**
	 * 假分页查询
	 * 
	 * 假设查询第2页，每页10条记录
	 */
	public void pagingQuery(int currentPage, int pageSize){
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			// 1. 注册数据库驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. 连接数据库
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "tiger");
			
			// 3. 创建可滚动可更新的结果集
			st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			// 4. 取得结果集
			rs = st.executeQuery("SELECT empno, ename FROM emp");
			
			// (1)定位到当前页的第1条记录
			rs.absolute((currentPage - 1) * pageSize + 1);	
			
			// (2)往后取10条记录
			for (int i = 0; i < pageSize; i++){
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				
				System.out.println(empno + ":" + ename);
				
				if(!rs.next()){
					break;	// 解决: 结果集已耗尽的问题
				}
			}	
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {		// 释放资源
			// 5. 关闭连接
			try {
				if(rs != null){
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(st != null){
					st.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(conn != null){
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}	// finally	
		
	}	// pagingQuery
	public static void main(String[] args) {
		TestResultSet testResultSet = new TestResultSet();
		// testResultSet.updateResultSet();
		testResultSet.pagingQuery(4, 3);
		
	}	// main
}	// TestResultSet

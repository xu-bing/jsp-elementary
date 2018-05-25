package com.jdbc;

import java.sql.*;

public class TestStatement {
	
	/**
	 * 查询所有员工
	 *
	 */
	/**
	 * 
	 */
	public void queryEmps(){
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			// 1. 注册数据库驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("注册数据库驱动成功");
			
			// 2. 连接数据库
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "tiger");
			//Connection conn = DriverManager.getConnection("jdbc:oracle:thin://", "scott", "tiger");
			System.out.println("连接数据库成功");
			
			// 3. 创建sql语句执行类
			st = conn.createStatement();
			
			//String sql = "SELECT * FROM emp WHERE ename = '" + name + "'" ;
			String sql = "SELECT * FROM emp2 ";
			
			System.out.println(sql);
			// 4. 取得结果集
			//rs = st.executeQuery("SELECT * FROM emp");
			rs = st.executeQuery(sql);
			
			while(rs.next()){	// next():判断有无记录，有的话就指向下一条记录	
			  Integer empno = rs.getInt(1);				// 通过列序号取值
			  String ename = rs.getString("ename");		// 通过列名来取值
			  
			  // 打印输出
			  System.out.println(empno + ":" + ename);			
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
		
	}	// queryEmps
	
	/**
	 * 新增员工
	 * @param args
	 */
	
	public void createEmp(){
		//-------------------------
		Connection conn = null;
		Statement st = null;
		//-------------------------
		
		try {
			// 1. load driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. set up connection
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "tiger");
			
			// 3. create sql executor
			st = conn.createStatement();
			
			// 4. execute sql
			// result表示影响的记录数
			int result = st.executeUpdate("INSERT INTO emp(empno, ename) VALUES(1001, 'TOM')");
			
			if(result > 0) {
				System.out.println("inserting succeeds");
			} else {
				System.out.println("inserting fails");
			}
	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 5. close resources
			try {
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
		}	// finally
		
	}	// createEmp
	
	/**
	 * 更新员工
	 *
	 */
	public void updateEmp(){
		//------------------------
		Connection conn = null;
		Statement st = null;
		//------------------------
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin://127.0.0.1:1521/orcl", "scott", "tiger");
			
			st = conn.createStatement();
			
			// (1)executeUpdate()
			int result = st.executeUpdate("UPDATE emp SET sal = 500 WHERE deptno = 10");
			System.out.println("update: " + result + "rows");
			
			// (2)execute
//			boolean res = st.execute("UPDATE emp SET sal = 500 WHERE deptno = 10");
//			System.out.println(res);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
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
		}	// finally
	}	// updateEmp
	
	/**
	 * 删除员工
	 *
	 */
	public void deleteEmp(){
		//-----------------------
		Connection conn = null;
		Statement st = null;
		//-----------------------
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin://127.0.0.1:1521/orcl", "scott", "tiger");
			
			st = conn.createStatement();
			
			int result = st.executeUpdate("DELETE FROM emp WHERE deptno = 10");
			
			System.out.println("delete" + ":" + result + " rows");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(st != null){
					st.close();
				}
				
				if(conn != null){
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}	// finally
		
	}	// deleteEmp
	
	public static void main(String[] args) {
		TestStatement testStatement = new TestStatement();
		testStatement.queryEmps();
		//testStatement.createEmp();
		//testStatement.updateEmp();
		//testStatement.deleteEmp();
		
	}	// main
}	// TestStatement


package com.jdbc;

import java.sql.*;

public class TestStatement {
	
	/**
	 * ��ѯ����Ա��
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
			// 1. ע�����ݿ�����
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("ע�����ݿ������ɹ�");
			
			// 2. �������ݿ�
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "tiger");
			//Connection conn = DriverManager.getConnection("jdbc:oracle:thin://", "scott", "tiger");
			System.out.println("�������ݿ�ɹ�");
			
			// 3. ����sql���ִ����
			st = conn.createStatement();
			
			//String sql = "SELECT * FROM emp WHERE ename = '" + name + "'" ;
			String sql = "SELECT * FROM emp2 ";
			
			System.out.println(sql);
			// 4. ȡ�ý����
			//rs = st.executeQuery("SELECT * FROM emp");
			rs = st.executeQuery(sql);
			
			while(rs.next()){	// next():�ж����޼�¼���еĻ���ָ����һ����¼	
			  Integer empno = rs.getInt(1);				// ͨ�������ȡֵ
			  String ename = rs.getString("ename");		// ͨ��������ȡֵ
			  
			  // ��ӡ���
			  System.out.println(empno + ":" + ename);			
			}
			
					

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {		// �ͷ���Դ
			// 5. �ر�����
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
	 * ����Ա��
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
			// result��ʾӰ��ļ�¼��
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
	 * ����Ա��
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
	 * ɾ��Ա��
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


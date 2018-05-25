package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
* �ɹ������ɸ��µĽ����
		* ���Ĭ�ϵ� ResultSet ���󲻿ɸ��£�����һ����ǰ�ƶ��Ĺ�ꡣ
		* ��ˣ�ֻ�ܵ�����һ�Σ�����ֻ�ܰ��ӵ�һ�е����һ�е�˳����С�
		* how������
		* ���ã��ٷ�ҳ����ѯ�Ľ����
*/

public class TestResultSet {

	/**
	 * ������Ķ�λ������
	 *
	 */
	public void updateResultSet(){
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			// 1. ע�����ݿ�����
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. �������ݿ�
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "tiger");
			
			// 3. �����ɹ����ɸ��µĽ����
			st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			// 4. ȡ�ý����
			rs = st.executeQuery("SELECT empno, ename FROM emp");
			
			//---------------------------------------- 
			//�ɹ��� ---> ��λ ----> ȡֵ 
			//�ɸ���			        ����
			
			//-----------------------------------------
			// (1)��¼�Ķ�λ
			// a. �ܹ���λ��������scrollable��
			// b. ȡֵ֮ǰһ��Ҫ�ȶ�λ������ERR:������Ѻľ�
			rs.absolute(2);	// ��ʾ��λ����2����¼	
			
			System.out.println(rs.getInt("empno"));
			System.out.println(rs.getString(2));
			
			// (2)���ݸ���
			// ������a. �ȶ�λ b.updatable
			rs.updateString("ename", "allen2");
			rs.updateRow();		// ִ�и��£�����emp��
			
			// check
			System.out.println(rs.getInt(1) + ":" + rs.getString("ename"));

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
		
	}	// updateResultSet
	
	/**
	 * �ٷ�ҳ��ѯ
	 * 
	 * �����ѯ��2ҳ��ÿҳ10����¼
	 */
	public void pagingQuery(int currentPage, int pageSize){
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			// 1. ע�����ݿ�����
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. �������ݿ�
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "tiger");
			
			// 3. �����ɹ����ɸ��µĽ����
			st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			// 4. ȡ�ý����
			rs = st.executeQuery("SELECT empno, ename FROM emp");
			
			// (1)��λ����ǰҳ�ĵ�1����¼
			rs.absolute((currentPage - 1) * pageSize + 1);	
			
			// (2)����ȡ10����¼
			for (int i = 0; i < pageSize; i++){
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				
				System.out.println(empno + ":" + ename);
				
				if(!rs.next()){
					break;	// ���: ������Ѻľ�������
				}
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
		
	}	// pagingQuery
	public static void main(String[] args) {
		TestResultSet testResultSet = new TestResultSet();
		// testResultSet.updateResultSet();
		testResultSet.pagingQuery(4, 3);
		
	}	// main
}	// TestResultSet

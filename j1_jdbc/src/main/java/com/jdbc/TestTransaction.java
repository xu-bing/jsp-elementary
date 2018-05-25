package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestTransaction {
	/**
	 * �������
	 */
	// �عˣ�what������n��dml������Ϊ1��������Ԫ������Ҫôȫ���ɹ���Ҫ��ȫ��ʧ�ܡ�
	// * ��������1��ʧ�ܣ���������Ԫ�ڵ�n����ʧ�ܡ�
	// * �����������������ɹ�����ɹ���������


	public void manageTransaction(){
		// -----------------------------------------------------
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		String URL = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		String userName = "scott";
		String pwd = "tiger";

		// ------------------------------------------------------
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection(URL, userName, pwd);

			stmt = conn.createStatement();

			String sql1 = "INSERT INTO emp (empno, ename) " +
					"VALUES (1000, 'TOM')";
			String sql2 = "INSERT INTO emp (empno, ename) " +
					"VALUES (1001, 'TOM')";
			String sql3 = "INSERT INTO emp (empno, ename) " +
					"VALUES (1000, 'TOM')";
			String sql4 = "INSERT INTO emp (empno, ename) " +
					"VALUES (1002, 'TOM')";

			// 1. �Զ��ύ
			// ÿִ��1��sql��䣬�ͻῪ�������Զ��ύ��
			// �����˳��ִ�У��ɹ��������ͻ������ݿ����Ӽ�����¼��
//			stmt.executeUpdate(sql1);
//			stmt.executeUpdate(sql2);
//			stmt.executeUpdate(sql3);	// �����쳣������ִ��sql4��Υ��Ψһ�ԡ�
//			stmt.executeUpdate(sql4);

			// 2. �ֶ��ύ
			// ȫ���ɹ����Ż��ύ��1��ʧ�ܣ�ȫ��ʧ�ܣ�����ع���
			conn.setAutoCommit(false);

			stmt.executeUpdate(sql1);
			stmt.executeUpdate(sql2);
			stmt.executeUpdate(sql3);	// �����쳣������ִ��sql4��
			stmt.executeUpdate(sql4);
			conn.commit();				// �ύ����
			conn.setAutoCommit(true);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if (conn != null){
				try {
					conn.rollback();	// �ع�����
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		} finally {
			// �ͷ���Դ
			try {
				if (stmt != null){
					stmt.close();
					System.out.println("stmt closing");
				}

				if (conn != null){
					conn.close();
					System.out.println("conn closing");
				}


			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}	// finally

		System.out.println("after finally...");


	}	// manageTransaction


	public static void main(String[] args) {
		TestTransaction testTransaction = new TestTransaction();
		testTransaction.manageTransaction();

		System.out.println("manageTransaction...");
	}	// main

}

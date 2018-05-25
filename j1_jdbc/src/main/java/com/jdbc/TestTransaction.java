package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestTransaction {
	/**
	 * 事务管理
	 */
	// 回顾：what是事务：n条dml操作作为1个工作单元，操作要么全部成功，要不全部失败。
	// * 采用事务：1条失败，则整个单元内的n条都失败。
	// * 不采用事务：若干条成功，则成功若干条。


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

			// 1. 自动提交
			// 每执行1条sql语句，就会开启事务、自动提交。
			// 结果：顺序执行，成功几条，就会在数据库增加几条记录。
//			stmt.executeUpdate(sql1);
//			stmt.executeUpdate(sql2);
//			stmt.executeUpdate(sql3);	// 发生异常，不会执行sql4。违反唯一性。
//			stmt.executeUpdate(sql4);

			// 2. 手动提交
			// 全部成功，才会提交；1条失败，全部失败，事务回滚。
			conn.setAutoCommit(false);

			stmt.executeUpdate(sql1);
			stmt.executeUpdate(sql2);
			stmt.executeUpdate(sql3);	// 发生异常，不会执行sql4。
			stmt.executeUpdate(sql4);
			conn.commit();				// 提交事务
			conn.setAutoCommit(true);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if (conn != null){
				try {
					conn.rollback();	// 回滚事务
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		} finally {
			// 释放资源
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

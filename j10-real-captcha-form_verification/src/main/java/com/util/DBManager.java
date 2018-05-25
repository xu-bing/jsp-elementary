package com.util;

import java.sql.*;

/**
 * �������ݿ�������ر�
 * @author xab
 *
 */

public class DBManager {
	// --------------------------------------------------------------------------------
	//  ���ݿ����Ӳ���
	// params for connecting db
	private static final String DRIVER;
	private static final String URL;
	private static final String USER;
	private static final String PWD;
	
	//  1. ֱ��д�ڴ�����
	static{
		DRIVER = "oracle.jdbc.driver.OracleDriver";
		URL = "jdbc:oracle:thin:@127.0.0.1:1521/orcl";
		// ....................:@...............:orcl
		USER = "scott";
		PWD = "tiger";
	}
	
	// 2. д���ⲿ�����ļ��У�ͨ���������ʻ��
	
	// ȡ������ֵ
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
		super();	// ���ø���Object���޲ι��췽��
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
 * ���������ݿ������
 * ������
 * �������ݿ�
 * ���ݲ�����DML
 * �ر����ݿ����ӣ��ͷ���Դ
 * 
 * */


/*
 * ��̬������ʵ��������ѡ��
 * 
 * ���Ҫ����������ȡ���ݣ�һ���Ҫ�ö���
 * ���ֻ��һЩ���߷������Ǿ��þ�̬������
 * 
 * */

/*
 * �����ݿ����д���ⲿ�ļ��е������
 * 
 * ����ǰ�ڱ��븺��������������ά����
 * Ӳ�����޸ģ�
 * �޸�Դ�� ---> ���� ---> ����������
 * 
 * �����ļ����ԣ�
 * �޸������ļ� ---> �������г�����Ҫ�����������𣿣�
 * 
 * 
 */

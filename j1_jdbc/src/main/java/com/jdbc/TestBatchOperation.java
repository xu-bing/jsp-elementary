package com.jdbc;

import java.sql.*;

/**
 * 效率比较
 * 新增员工3000条记录
 * @author Administrator
 *
 */

public class TestBatchOperation {
	/**
	 * 使用statement新增员工
	 *
	 */
	public void createEmpsByStatement(){
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
			int result = 0;
			
			long begin = System.currentTimeMillis();		// 新增操作开始的时间
			
			conn.setAutoCommit(false);
			
			for(int i = 0; i < 3000; i++){
				String createEmpSQL = 
					"INSERT INTO emp (empno, ename)" +
					" VALUES (" + i + ", 'TOM')";
				
				result += st.executeUpdate(createEmpSQL);		
			}
			
			conn.commit();
			conn.setAutoCommit(true);
			
			long end = System.currentTimeMillis();
			
			if(result > 0){
				System.out.println("inserted records" + ":" + result);
				System.out.println(end-begin);
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
		
		
	}	// createEmpsByStatement
	
	/**
	 * 使用preparedStatement新增员工
	 *
	 */
	public void createEmpsByPreparedStatement(){
		//-------------------------
		Connection conn = null;
		PreparedStatement ps = null;
		//-------------------------
		
		try {
			// 1. load driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. set up connection
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "tiger");
			
			// 3. create sql executor
			String createEmpSQL = 
				"INSERT INTO emp (empno, ename)" +
				" VALUES(?, ?)";
			
			ps = conn.prepareStatement(createEmpSQL);
			
			// 4. execute sql
			// result表示影响的记录数
			int result = 0;
			
			long begin = System.currentTimeMillis();
			
			conn.setAutoCommit(false);
			
			for (int i = 0; i < 3000; i++){
				ps.setInt(1, i);
				ps.setString(2, "TOM");
				result += ps.executeUpdate();
			}
			
			conn.commit();
			conn.setAutoCommit(true);
			
			long end = System.currentTimeMillis();
			
			if(result > 0){
				System.out.println("inserted records" + ":" + result);
				System.out.println(end-begin);
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
				if (ps != null){
					ps.close();
				}
				
				if (conn != null){
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	// finally
		
	}	// createEmpsByPreparedStatement
	
	/**
	 * 使用PreparedStatement batch新增员工
	 *
	 */
	public void createEmpsByPreparedStatementBatch(){
		//-------------------------
		Connection conn = null;
		PreparedStatement ps = null;
		//-------------------------
		
		try {
			// 1. load driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. set up connection
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "tiger");
			
			// 3. create sql executor
			String createEmpSQL = 
				"INSERT INTO emp (empno, ename)" +
				" VALUES(?, ?)";
			
			ps = conn.prepareStatement(createEmpSQL);
			
			// 4. execute sql
			// result表示影响的记录数
			int result = 0;
			
			long begin = System.currentTimeMillis();
			
			conn.setAutoCommit(false);
			
			for (int i = 0; i < 3000; i++){
				ps.setInt(1, i);
				ps.setString(2, "TOM");
				ps.addBatch();  // 将一组参数添加到ps对象的批处理命令中。
			}
			
			int[] aCount= ps.executeBatch();
			// ps.execute(); // ERR: batch must be either executed or cleared
			
			result = aCount.length;		
			
			conn.commit();
			conn.setAutoCommit(true);
			
			long end = System.currentTimeMillis();
			
			if(result > 0){
				System.out.println("inserted records" + ":" + result);
				System.out.println(end-begin);
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
				if (ps != null){
					ps.close();
				}
				
				if (conn != null){
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	// finally
		
	}	// createEmpsByPreparedStatementBatch
	
	/**
	 * 通过statement batch新增员工
	 *
	 */
	public void createEmpsByStatementBatch(){
//		-------------------------
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
			int result = 0;
			
			long begin = System.currentTimeMillis();		// 新增操作开始的时间
			
			conn.setAutoCommit(false);
			
			for(int i = 0; i < 3000; i++){
				st.addBatch("INSERT INTO emp(empno, ename) VALUES (" + i + ", 'TOM')");		
			}
						
			int[] aCount = st.executeBatch();
			
			result = aCount.length;
			
			conn.commit();
			conn.setAutoCommit(true);
			
			long end = System.currentTimeMillis();
			
			if(result > 0){
				System.out.println("inserted records" + ":" + result);
				System.out.println(end-begin);
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
		
	}	// createEmpsByStatementBatch
	public static void main(String[] args) {
		TestBatchOperation testBatchOperation = new TestBatchOperation();
	    //testBatchOperation.createEmpsByStatement();  				//elapsed: 3938 2078 1438 344(手动)
		//testBatchOperation.createEmpsByPreparedStatement();		//elapsed: 984  1297 984  282(手动)
		//testBatchOperation.createEmpsByPreparedStatementBatch();	//elapsed: 16 	31 	 31	  31(手动)
		testBatchOperation.createEmpsByStatementBatch();			//elapsed: 1125 1282 1140 360(手动)
	}	// main
	
}	// TestBatchOperation

package com.jdbc;


import java.math.BigDecimal;
import java.sql.*;

import oracle.jdbc.driver.OracleTypes;

public class TestCallableStatement {

	/**
	 * 测试：调用存储过程，返回字符串
	 *
	 */
	public void callProcedure2String(){
		//------------------------
		Connection conn = null;
		CallableStatement cs = null;
		//------------------------

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection("jdbc:oracle:thin://127.0.0.1:1521/orcl", "scott", "tiger");

			// 1. 创建callableStatement对象
			cs = conn.prepareCall("{call sp_query_dept(?,?)}");	// 通配符数量要与存储过程一致；存储过程的名字不区分大小写

			// 2. 给输入参数赋值
			cs.setInt(1, 20);	// 30: salesman

			// 3. 给输出参数注册类型
			cs.registerOutParameter(2, Types.VARCHAR);	//标识sql类型

			// 4. 执行存储过程
			cs.execute();

			// 5. 输出结果
			String dname = cs.getString(2);
			System.out.println(dname);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (cs != null){
					cs.close();
				}

				if (conn != null){
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	// finally

	}	// callProcedure

	/**
	 * 测试调用函数
	 *
	 */
	public void callFunction(){
//		------------------------
		Connection conn = null;
		CallableStatement cs = null;
		//------------------------

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection("jdbc:oracle:thin://127.0.0.1:1521/orcl", "scott", "tiger");

			// 1. 创建callableStatement对象
			cs = conn.prepareCall("{?=call fn_emp_sal_statistics(?,?,?)}");	// 部门人数，部门号，薪水总和，平均薪水

			// 2. 给输入参数赋值
			cs.setInt(2, 30);	// 20: research

			// 3. 给输出参数注册类型
			cs.registerOutParameter(1, Types.NUMERIC);
			cs.registerOutParameter(3, Types.NUMERIC);
			//cs.registerOutParameter(4, Types.DOUBLE);
			cs.registerOutParameter(4, Types.DECIMAL);

			// 4. 执行存储过程
			cs.execute();

			// 5. 输出结果
			int count = cs.getInt(1);
			int sum = cs.getInt(3);
			//double avg = cs.getDouble(4);   // // 改进：用bigdecimal   1566.6666666666667 (双精度浮点型变量double可以处理16位有效数，超过16位用BigDecimal.)
			BigDecimal avg = new BigDecimal(cs.getDouble(4));  // 1566.666666666666742457891814410686492919921875

			System.out.println(count);
			System.out.println(sum);
			System.out.println(avg);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (cs != null){
					cs.close();
				}

				if (conn != null){
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	// finally


	}	// callFunction

	/**
	 * 测试：调用存储过程，返回游标
	 */
	public void callProcedure2Cursor(){
//		------------------------
		Connection conn = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		//------------------------

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection("jdbc:oracle:thin://127.0.0.1:1521/orcl", "scott", "tiger");

			// 1. 创建callableStatement对象
			cs = conn.prepareCall("{call pack_del_emp.sp_del_emp(?,?,?)}");	// 通配符数量要与存储过程一致；存储过程的名字不区分大小写

			// 2. 给输入参数赋值
			cs.setInt(1, 8801);

			// 3. 给输出参数注册类型
			cs.registerOutParameter(2, OracleTypes.CURSOR);			// (1/2)注册游标类型
			cs.registerOutParameter(3, Types.NUMERIC);

			// 4. 执行存储过程
			cs.execute();

			// 5. 输出结果
			int result = cs.getInt(3);
			System.out.println(result);

			if (result != 1){	// 结果为1时才去取游标，否则，ERROR: cursor is closed.
				return;
			}

			// 取游标
			rs = (ResultSet)cs.getObject(2);						// (2/2)取游标， 将游标强制转换为ResultSet
			while(rs.next()){
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				System.out.println(empno + ":" + ename);
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null){
					rs.close();
				}

				if (cs != null){
					cs.close();
				}

				if (conn != null){
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	// finally


	}	// callPackage

	public static void main(String[] args) {
		TestCallableStatement testCallableStatement = new TestCallableStatement();
		//testCallableStatement.callProcedure2String();
		//testCallableStatement.callFunction();
		testCallableStatement.callProcedure2Cursor();
	}
}	// TestCallableStatement

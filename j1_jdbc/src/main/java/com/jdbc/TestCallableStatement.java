package com.jdbc;


import java.math.BigDecimal;
import java.sql.*;

import oracle.jdbc.driver.OracleTypes;

public class TestCallableStatement {

	/**
	 * ���ԣ����ô洢���̣������ַ���
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

			// 1. ����callableStatement����
			cs = conn.prepareCall("{call sp_query_dept(?,?)}");	// ͨ�������Ҫ��洢����һ�£��洢���̵����ֲ����ִ�Сд

			// 2. �����������ֵ
			cs.setInt(1, 20);	// 30: salesman

			// 3. ���������ע������
			cs.registerOutParameter(2, Types.VARCHAR);	//��ʶsql����

			// 4. ִ�д洢����
			cs.execute();

			// 5. ������
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
	 * ���Ե��ú���
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

			// 1. ����callableStatement����
			cs = conn.prepareCall("{?=call fn_emp_sal_statistics(?,?,?)}");	// �������������źţ�нˮ�ܺͣ�ƽ��нˮ

			// 2. �����������ֵ
			cs.setInt(2, 30);	// 20: research

			// 3. ���������ע������
			cs.registerOutParameter(1, Types.NUMERIC);
			cs.registerOutParameter(3, Types.NUMERIC);
			//cs.registerOutParameter(4, Types.DOUBLE);
			cs.registerOutParameter(4, Types.DECIMAL);

			// 4. ִ�д洢����
			cs.execute();

			// 5. ������
			int count = cs.getInt(1);
			int sum = cs.getInt(3);
			//double avg = cs.getDouble(4);   // // �Ľ�����bigdecimal   1566.6666666666667 (˫���ȸ����ͱ���double���Դ���16λ��Ч��������16λ��BigDecimal.)
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
	 * ���ԣ����ô洢���̣������α�
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

			// 1. ����callableStatement����
			cs = conn.prepareCall("{call pack_del_emp.sp_del_emp(?,?,?)}");	// ͨ�������Ҫ��洢����һ�£��洢���̵����ֲ����ִ�Сд

			// 2. �����������ֵ
			cs.setInt(1, 8801);

			// 3. ���������ע������
			cs.registerOutParameter(2, OracleTypes.CURSOR);			// (1/2)ע���α�����
			cs.registerOutParameter(3, Types.NUMERIC);

			// 4. ִ�д洢����
			cs.execute();

			// 5. ������
			int result = cs.getInt(3);
			System.out.println(result);

			if (result != 1){	// ���Ϊ1ʱ��ȥȡ�α꣬����ERROR: cursor is closed.
				return;
			}

			// ȡ�α�
			rs = (ResultSet)cs.getObject(2);						// (2/2)ȡ�α꣬ ���α�ǿ��ת��ΪResultSet
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

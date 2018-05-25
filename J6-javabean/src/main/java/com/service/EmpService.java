package com.service;

// sys's classes
import java.sql.*;
import java.util.*;

// self-defined's classes
import com.domain.*;
import com.util.*;

public class EmpService {

	/**
	 * 查询所有员工
	 * @return
	 */
	public List<Emp> queryEmps(){
		List<Emp> empList = new ArrayList<Emp>();
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		String sql = 
			"SELECT empno, ename, job, sal" +
			" FROM emp";
		// -------------------------
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while (rs.next()){
				Emp emp = new Emp(
					rs.getString("ename"),
					rs.getInt("empno"),
					rs.getString("job"),
					rs.getDouble("sal")
					);
				empList.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(rs, psmt, conn);
		}
		
		// ---------------------------
		return empList;
	}	// queryEmps()
	
	
	/**
	 * 删除员工
	 * @param empno
	 * @return
	 */
	public boolean deleteEmp(int empno){
		boolean result = false;
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		String sql = 
			"DELETE FROM emp " +
			" WHERE empno = ?";
		
		//---------------------------
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, empno);
			
			int i = psmt.executeUpdate();
			
			if (i > 0){
				result = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(null, psmt, conn);
		}
		
		// -------------------------
		return result;
	}	// deleteEmp
	
	/**
	 * 测试模糊查询
	 * @param job
	 * @param ename
	 * @return
	 */
	public List<Emp> queryCertainEmps(String job, String ename){
		List<Emp> empList = new ArrayList<Emp>();
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		String sql1 = 
			"SELECT empno, ename, job, sal" +
			" FROM emp" +
			" WHERE job LIKE ?" +
			" AND ename LIKE ?";
		
		String sql2 = 
			"SELECT empno, ename, job, sal" +
			" FROM emp" +
			" WHERE job LIKE '%"+job+"%'" +
			" AND ename LIKE '%"+ename+"%'";
		
		String sql3 = 
			"SELECT empno, ename, job, sal" +
			" FROM emp" +
			" WHERE job LIKE '%?%'" +	
			" AND ename LIKE '%"+ename+"%'";
		
		// -------------------------
		
		try {
			conn = DBManager.getConnection();
			//psmt = conn.prepareStatement(sql1);
			psmt = conn.prepareStatement(sql2);
			psmt = conn.prepareStatement(sql3);
			
			// 1: sql1
//			psmt.setString(1, "%"+job+"%");
//			psmt.setString(2, "%"+ename+"%");
			
			// 2: sql2
			// no need to assign
			
			// 3: sql3
			//psmt.setString(1, job);	// error: ？作为普通字符
			
			
			rs = psmt.executeQuery();
			
			while (rs.next()){
				Emp emp = new Emp(
					rs.getString("ename"),
					rs.getInt("empno"),
					rs.getString("job"),
					rs.getDouble("sal")
					);
				empList.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(rs, psmt, conn);
		}
		
		// ---------------------------
		return empList;
	}	// queryCertainEmps()
	
	/**
	 * 测试sql注入 
	 * @param empno
	 * @param ename
	 */
	public void queryEmpsByStatement(int empno, String ename){
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		String sql =
			"SELECT * " +
			" FROM emp" +
			" WHERE empno = " + empno + "and ename =" + ename;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "tiger");
			
			st = conn.createStatement();
			
			rs = st.executeQuery(sql);
		
			while (rs.next()){
				System.out.println(rs.getInt("empno") + "::" + rs.getString("ename"));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}	// queryEmpsByStatement
	
	public void queryEmpsByPS(int empno, String ename){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql =
			"SELECT * " +
			" FROM emp" +
			" WHERE empno = ? AND ename = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "tiger");
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, empno);
			ps.setString(2, ename);
			
			rs = ps.executeQuery();
		
			while (rs.next()){
				System.out.println(rs.getInt("empno") + "::" + rs.getString("ename"));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}	// queryEmpsByPS
	
	public static void main(String[] args) {
		EmpService empService = new EmpService();
		
	//	empService.deleteEmp(7369);
		
		List<Emp> empList = new ArrayList<Emp>();
		empList = empService.queryEmps();
		for(Emp emp : empList){
			System.out.println(emp.getEmpno() + ":" + emp.getEname());
		}
		
		// 测试模糊查询
//		empList = empService.queryCertainEmps("", "");
//		for(Emp emp : empList){
//			System.out.println(emp.getEmpno() + ":" + emp.getEname());
//		}
		
		// 测试 sql注入
//		empService.queryEmpsByStatement(7934, "'MILLER' OR 1 = 1");
//		empService.queryEmpsByPS(7934, "'MILLER' OR 1 = 1");
		
	}	// main
	
}	// EmpService

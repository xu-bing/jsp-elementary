package com.service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.domain.Emp;
import com.util.DbConnection;

public class EmpService {
	public List<Emp> queryAllEmps(){
		List<Emp> empList = new ArrayList<Emp>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "scott", "tiger");
			
			conn = DbConnection.getConnection();
			
			String sql = "SELECT * FROM°°emp";
			
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while (rs.next()){
  				Integer empno = rs.getInt("empno");
  				String ename = rs.getString("ename");
  				String job = rs.getString("job");
  				Double sal = rs.getDouble("sal");
  				Date hiredate = rs.getDate("hiredate");
  				
  				Emp emp = new Emp(empno, ename, job, sal, hiredate);
  				
  				empList.add(emp); 
  			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbConnection.close(rs, ps, conn);
			
		}	// finally
		
		
		return empList;
	}	// queryAllEmps
	
	
	public boolean saveEmp(Emp emp){
		
		return false;
	}
	
	public boolean updateEmp(Emp emp){
		
		return false;
	}  
	
	public boolean deleteEmp(int empno){
		boolean result = false;
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			DbConnection.getConnection();
			
			String sql = "DELETE FROM°°emp WHERE empno = ?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, empno);
			
			int res = ps.executeUpdate();
			
			if (res > 0){
				result = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			DbConnection.close(null, ps, conn);
			
		}	// finally
		
		
		return result;
	}	// deleteEmp
	
	/**
	 *  ≤‚ ‘!!!
	 */
	public static void main(String[] args) {
		EmpService e = new EmpService();
		List<Emp> empList = e.queryAllEmps();
		
		for (Emp emp : empList){
			System.out.println(emp.getEmpno() + "::" + emp.getEname());
		}
		
		//System.out.println(e.deleteEmp(1001));
		
	}	// main
	
}

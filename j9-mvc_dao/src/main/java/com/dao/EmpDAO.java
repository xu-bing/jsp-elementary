package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.iface.*;
import com.domain.Emp;
import com.util.DBManager;

public class EmpDAO implements EmpDAOIface{

	public boolean delEmpById(String sql, int empNo) {
		return false;
	}

	public List<Emp> queryAllEmps(String sql) {
		List empList = new ArrayList();
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		// 建立数据库连接
		conn = DBManager.getConnection();
		
		// 查询数据
		try{
			psmt = conn.prepareStatement(sql);
			rs  = psmt.executeQuery();
			
			while(rs.next()){
				Emp emp = new Emp(
					rs.getInt("empno"),
					rs.getString("ename"),
					rs.getString("job"),
					rs.getDouble("sal")
				);
				
				empList.add(emp);
			}
		} catch (SQLException e){
			e.printStackTrace();
			
		} finally {
			DBManager.close(rs, psmt, conn);
			
		}
		
		
		return empList;
	}

	public Emp queryEmpById(String sql, int empNo) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateEmp(String sql, Emp emp) {
		boolean result = false;
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DBManager.getConnection();
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, emp.getName());
			ps.setString(2, emp.getJob());
			ps.setDouble(3, emp.getSal());
			ps.setInt(4, emp.getEmpNo());
			
			int i = ps.executeUpdate();
		
			if (i > 0){
				result = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(null, ps, conn);
		}
		
		return result;
	}
	
	

}

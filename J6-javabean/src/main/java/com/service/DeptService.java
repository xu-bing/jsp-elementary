package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.domain.Dept;
import com.util.DBManager;

public class DeptService {
	public List<Dept> queryAllDepts(){
		List<Dept> deptList = new ArrayList<Dept>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT d.deptno,d.dname,e.empno,e.ename,e.job " +
			"FROM dept d LEFT OUTER JOIN emp e " +
			"ON d.deptno = e.deptno ORDER BY d.deptno";
		
		
		try {
			conn = DBManager.getConnection();
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()){
				
				// 创建部门对象
				// 一行数据代表1个部门对象
				// hr：部门号重复就代表是一个部门
				Dept d = new Dept();
				
				int deptno = rs.getInt("deptno");
				d.setDeptno(deptno);
				
				// 将部门加入到部门列表中
				if (!deptList.contains(d)){		// 如果列表中不没有该部门
					
					//d.setDeptno(deptno);
					d.setDname(rs.getString("dname"));
					d.setEnameList(new ArrayList<String>());
					
					deptList.add(d);
					
				} else {	
					
					d = deptList.get(deptList.indexOf(d));
				}
				
				// 将员工将加入部门中
				if (rs.getString("ename") != null){		// 排除没有员工的部门
				//	System.out.println(rs.getString("ename"));
					d.getEnameList().add(rs.getString("ename"));
				}
					
			}	// while
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(rs, ps, conn);
		}	
		
		return deptList;
	} 	// queryAllDepts
	
	public static void main(String[] args) {
		DeptService deptService = new DeptService();
		List<Dept> deptList =  deptService.queryAllDepts();
		
		for (Dept dept : deptList){
			System.out.println(dept.getDeptno());
			
//			List<String> enameList = new ArrayList<String>();
			for (String str : dept.getEnameList()){
				System.out.println(str);
			}	// for：inner
			
		}	// for：outer
	}
	
	
}	// DeptService

/*
 * 推论：
 * 重复值，如何排除重复值
 * 
 * 
 */
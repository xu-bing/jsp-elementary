package com.service;

import java.sql.*;
import java.util.*;

import com.domain.*;
import com.util.*;

public class EmpService {
	
	/**
	 * 统计员工总数（总记录数）
	 * @return 员工总数
	 */
	public int countEmps(){
		int count = 0;
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {	
			//定义一个数据库连接的类，提供得到Connection的方法
			conn = DBManager.getConnection();
			ps = conn.prepareStatement("select count(*) from emp");
			rs = ps.executeQuery();
			if(rs.next()){
				count = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{	
			//JDBCtools类中提供关闭连接数据库资源的方法
			DBManager.close(rs, ps, conn);
		}
		return count;		
	}

	/**
	 * 真分页查询
	 * @param begin 每页的起始位置
	 * @param end 每页的结束位置
	 * @return
	 */
	public List<Emp> queryEmps(int currentPage,int pageSize){
		List<Emp> empList = new ArrayList<Emp>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
//		计算当前页对应的起始与结束的记录序号
		int begin = (currentPage-1)*pageSize+1;
		int end = currentPage*pageSize;
		
		String sql = 
			"select s.* " +
			"from (select t.* ,rownum r " +
					"from (select empno,ename,job, sal from emp order by empno) t) s " +
			"where s.r>=? and s.r<=?";
		
		//-------------------------------------------------------------
		try {	
			conn = DBManager.getConnection();

			ps = conn.prepareStatement(sql);
			ps.setInt(1, begin);
			ps.setInt(2, end);

			rs = ps.executeQuery();
			while(rs.next()){
				Emp emp = new Emp(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getDouble(4));
				empList.add(emp);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{	
			//JDBCtools类中提供关闭连接数据库资源的方法
			DBManager.close(rs, ps, conn);
		}
		
		// -------------------------------------------------
		return empList;
	}
	
	public static void main(String[] args){
		EmpService e = new EmpService();
		// 1. 
		List<Emp> empList = e.queryEmps(3, 3);
		for (Emp emp:empList){
			System.out.println(emp.getEmpno() + ":" + emp.getEname());
		}
		
//		System.out.println(e.countEmps());
		
	}	// main
	
}	// EmpService

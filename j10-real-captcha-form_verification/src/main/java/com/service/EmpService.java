package com.service;

import java.sql.*;
import java.util.*;

import com.domain.*;
import com.util.*;

public class EmpService {
	
	/**
	 * ͳ��Ա���������ܼ�¼����
	 * @return Ա������
	 */
	public int countEmps(){
		int count = 0;
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {	
			//����һ�����ݿ����ӵ��࣬�ṩ�õ�Connection�ķ���
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
			//JDBCtools�����ṩ�ر��������ݿ���Դ�ķ���
			DBManager.close(rs, ps, conn);
		}
		return count;		
	}

	/**
	 * ���ҳ��ѯ
	 * @param begin ÿҳ����ʼλ��
	 * @param end ÿҳ�Ľ���λ��
	 * @return
	 */
	public List<Emp> queryEmps(int currentPage,int pageSize){
		List<Emp> empList = new ArrayList<Emp>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
//		���㵱ǰҳ��Ӧ����ʼ������ļ�¼���
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
			//JDBCtools�����ṩ�ر��������ݿ���Դ�ķ���
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

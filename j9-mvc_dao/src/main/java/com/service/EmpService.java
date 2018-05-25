package com.service;

import java.util.*;
import java.sql.*;

import com.domain.*;
import com.util.*;
import com.dao.iface.*;
import com.dao.*;

import com.service.iface.*;

public class EmpService implements EmpServiceIface{

	// ʹ�ýӿڵĺô���
	// �´����empDAO���ˣ���ֻҪ�ڹ��캯��������new1�������empDao�Ϳ����ˡ�
	// �µ�empDao�϶���ʵ����empDAOIface�ġ�  
	private EmpDAOIface empDAO;
	
	public EmpService(){
		
		//empDAO = new EmpDAO();
		empDAO = EmpDAOFactory.createEmpDAO();
	}
	
	/**
	 * ��ѯ����Ա��
	 * @return
	 */
	public List<Emp> queryAllEmps(){
		// �����ҵ���߼�
		// sql���Ҳ�ɿ�����ҵ���߼�
		String sql = 
			"SELECT empno, ename, job, sal" +
			" FROM emp";
		
		return empDAO.queryAllEmps(sql);
		
	}	// queryAllEmps
	
	// --------------------------------------------------------------------------
	
	/**
	 * ����Ա����Ų�ѯԱ��
	 * @param empNo
	 * @return
	 */
	public Emp queryEmpById(int empNo){
		Emp emp = null;
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		String sql =
			"SELECT *" +
			" FROM emp" +
			" WHERE empno = ?";
		
		conn = DBManager.getConnection();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, empNo);
			rs = psmt.executeQuery();
			
			if(rs.next()){
				emp = new Emp(
					rs.getInt("empno"),
					rs.getString("ename"),
					rs.getString("job"),
					rs.getDouble("sal")
				);
			}	
	
		} catch (SQLException e){
			e.printStackTrace();
		}
			
		return emp;
	}	// requeyEmpById
	
	
	/**
	 * ����Ա����Ÿ���Ա����Ϣ
	 * @param emp
	 * @return
	 */
	public boolean updateEmpById(Emp emp){
		boolean result = false;
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		String sql = 
			"UPDATE emp" +
			" SET ename = ?," +
			" job = ?," +
			" sal = ?" +
			" WHERE empno = ?";
		
		conn = DBManager.getConnection();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, emp.getName());
			psmt.setString(2, emp.getJob());
			psmt.setDouble(3, emp.getSal());
			psmt.setInt(4, emp.getEmpNo());
			
			int i = psmt.executeUpdate();
			
			if (i > 0){
				result = true;
			}
			
		} catch (SQLException e){
			e.printStackTrace();
		} finally {
			DBManager.close(null, psmt, conn);
		}
		
		
		
		return result;
	}	// updateEmpById
	
	
	public boolean updateEmp(Emp emp){
		
		String sql =
			"UPDATE emp" +
			" SET ename = ?, job = ?, sal = ?" +
			" WHERE empno = ?";
		
		return empDAO.updateEmp(sql, emp);
	}
	
	/**
	 * ����Ա����ɾ��Ա��
	 * @param empNo
	 * @return
	 */
	public boolean delEmpById(int empNo){
		boolean result = false;
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		String sql =
			"DELETE FROM emp" +
			" WHERE empno = ?";
		
		conn = DBManager.getConnection();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, empNo);
			
			int i = psmt.executeUpdate();
			
			if(i > 0){
				result = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(null, psmt, conn);
		}
		
		return result;
		
		
	}	// delEmp
	
	public static void main(String[] args){
		EmpService empService = new EmpService();
//		List<Emp> empList = empService.queryAllEmps();
		
//		for (Emp emp : empList){
//			System.out.println(emp.getName());
//		}
		
//		boolean result = empService.delEmpById(7844);
//		System.out.println(result);
		
//		Emp emp = empService.queryEmpById(7900);
//		System.out.println(emp.getName());
		
		Emp emp = new Emp(7900, "James1", "ANALYST", 951.5);
		System.out.println(empService.updateEmpById(emp));
	}
	
}	// Empservice

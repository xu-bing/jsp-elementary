package com.dao.iface;

import java.util.*;

import com.domain.*;

public interface EmpDAOIface {
	
	public List<Emp> queryAllEmps(String sql);
	
	public Emp queryEmpById(String sql, int empNo);
	
	public boolean updateEmp(String sql, Emp emp);
	
	public boolean delEmpById(String sql, int empNo);

}

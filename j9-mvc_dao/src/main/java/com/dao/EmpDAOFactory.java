package com.dao;

import com.dao.iface.*;

public class EmpDAOFactory {
	public static EmpDAOIface createEmpDAO(){
		return new EmpDAO();
	}
}

package com.service.iface;

import java.util.*;
import com.domain.*;

public interface EmpServiceIface {
	public List<Emp> queryAllEmps();
	
	public Emp queryEmpById(int empNo);
	
	public boolean updateEmpById(Emp emp);
	
	public boolean delEmpById(int empNo);
	
}

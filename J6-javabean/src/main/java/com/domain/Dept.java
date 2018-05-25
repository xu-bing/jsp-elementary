package com.domain;

import java.util.List;

public class Dept {
	private Integer deptno;
	private String dname;
	
	private List<String> enameList; 

	public Dept() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer getDeptno() {
		return deptno;
	}

	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}


	public List<String> getEnameList() {
		return enameList;
	}


	public void setEnameList(List<String> enameList) {
		this.enameList = enameList;
	}


	@Override
	public boolean equals(Object obj) {
		Dept d = (Dept) obj;
		
		if (d.getDeptno() == deptno){
			
			return true;
		} else {
			return false;
		}
		
		
	}


	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 17 + deptno;
	}
	
	
	
}

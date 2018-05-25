package com.domain;

public class Emp {
	
	private Integer empno;
	private String ename;
	private String job;
	private Double  sal;
	
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Emp(Integer empno, String ename, String job, Double sal) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.sal = sal;
	}

	public Integer getEmpno() {
		return empno;
	}

	public void setEmpno(Integer empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Double getSal() {
		return sal;
	}

	public void setSal(Double sal) {
		this.sal = sal;
	}

}	// Emp

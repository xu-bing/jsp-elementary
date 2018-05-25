package com.domain;

public class Emp {
	// fields
	private String ename;
	private Integer empno;
	private String job;
	private Double sal;

	private boolean isAlive;
	private boolean dead;
	private Boolean isMarried;
	
	// constructors
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Emp(String ename, Integer empno, String job, Double sal) {
		super();
		this.ename = ename;
		this.empno = empno;
		this.job = job;
		this.sal = sal;
	}

	// setters, getters
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

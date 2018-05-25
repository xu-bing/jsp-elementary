package com.domain;

public class Emp {

	private Integer empNo;
	private String name;
	private String job;
	private Double sal;
	
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Emp(Integer empNo, String name, String job, Double sal) {
		super();
		this.empNo = empNo;
		this.name = name;
		this.job = job;
		this.sal = sal;
	}

	public Integer getEmpNo() {
		return empNo;
	}

	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	
	
}

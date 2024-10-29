package com.emp.data;

public class Emp {
	private String name;
	private int age;
	private String des;
	private String dept;
	private String mgr;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getMgr() {
		return mgr;
	}
	public void setMgr(String mgr) {
		this.mgr = mgr;
	}
	
	public Emp(String name, int age, String des, String dept, String mgr) {
		this.name = name;
		this.age = age;
		this.des = des;
		this.dept = dept;
		this.mgr = mgr;
	}
	

}

package com.arc.cloud.vo;

public class OrganizationVO {

	public OrganizationVO() {
		// TODO Auto-generated constructor stub
	}

	public OrganizationVO(int studentId, String name, String department, String emailId) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.department = department;
		this.emailId = emailId;
	}

	private int studentId;
	private String name;
	private String department;
	private String emailId;

	public int getStudentId() {
		return studentId;
	}

	public String getName() {
		return name;
	}

	public String getDepartment() {
		return department;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}

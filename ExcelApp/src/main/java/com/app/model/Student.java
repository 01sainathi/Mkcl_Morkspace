package com.app.model;

public class Student {
	private int studentId;
	private int rollNo;
	private String name;
	private int std;
	private int fkSchoolId;
	private int fkMarkId;
	public Student() {
		super();
	}
	public Student(int studentId, int rollNo, String name, int std, int fkSchoolId, int fkMarkId) {
		super();
		this.studentId = studentId;
		this.rollNo = rollNo;
		this.name = name;
		this.std = std;
		this.fkSchoolId = fkSchoolId;
		this.fkMarkId = fkMarkId;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStd() {
		return std;
	}
	public void setStd(int std) {
		this.std = std;
	}
	public int getFkSchoolId() {
		return fkSchoolId;
	}
	public void setFkSchoolId(int fkSchoolId) {
		this.fkSchoolId = fkSchoolId;
	}
	public int getFkMarkId() {
		return fkMarkId;
	}
	public void setFkMarkId(int fkMarkId) {
		this.fkMarkId = fkMarkId;
	}
	@Override
	public String toString() {
		return "{\"studentId\":\"" + studentId + "\","
				+ "\"rollNo\":\"" + rollNo + "\","
				+ "\"name\":\"" + name + "\","
				+ "\"std\":\"" + std+ "\","
				+ "\"fkSchoolId\":\"" + fkSchoolId + "\","
				+ "\"fkMarkId\":\"" + fkMarkId + "\"}";
	}
	
}

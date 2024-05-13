package com.app.model;

public class StudentInfo {
	
	private Student student;
	private Mark marks;
	private School school;
	public StudentInfo() {
		super();
	}
	public StudentInfo(Student student, Mark marks, School school) {
		super();
		this.student = student;
		this.marks = marks;
		this.school = school;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Mark getMarks() {
		return marks;
	}
	public void setMarks(Mark marks) {
		this.marks = marks;
	}
	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}
	@Override
	public String toString() {
		return "{\"student\":" + student + ","
				+ "\"marks\":" + marks + ","
				+ "\"school\":" + school + "}";
	}
}

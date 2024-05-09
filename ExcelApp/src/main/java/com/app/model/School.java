package com.app.model;

public class School {
	private int schoolId;
	private String name;
	private String address;
	private String phone;
	private String email;
	public School() {
		super();
	}
	public School(int schoolId, String name, String address, String phone, String email) {
		super();
		this.schoolId = schoolId;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}
	public int getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "School [schoolId=" + schoolId + ", name=" + name + ", address=" + address + ", phone=" + phone
				+ ", email=" + email + "]";
	}
}

package com.app.model;

public class ExamEvent {
	
	Long examEventID;
	String name;
	String examEventCode;
	String defaultLanguageID;
	
	public ExamEvent() {
		super();
	}
	public ExamEvent(String name, String examEventCode, String defaultLanguageID) {
		super();
		this.name = name;
		this.examEventCode = examEventCode;
		this.defaultLanguageID = defaultLanguageID;
	}
	public ExamEvent(Long examEventID, String name, String examEventCode, String defaultLanguageID) {
		super();
		this.examEventID = examEventID;
		this.name = name;
		this.examEventCode = examEventCode;
		this.defaultLanguageID = defaultLanguageID;
	}
	public Long getExamEventID() {
		return examEventID;
	}
	public void setExamEventID(Long examEventID) {
		this.examEventID = examEventID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getExamEventCode() {
		return examEventCode;
	}
	public void setExamEventCode(String examEventCode) {
		this.examEventCode = examEventCode;
	}
	public String getDefaultLanguageID() {
		return defaultLanguageID;
	}
	public void setDefaultLanguageID(String defaultLanguageID) {
		this.defaultLanguageID = defaultLanguageID;
	}
	@Override
	public String toString() {
		return "ExamEvent [examEventID=" + examEventID + ", name=" + name + ", examEventCode=" + examEventCode
				+ ", defaultLanguageID=" + defaultLanguageID + "]";
	}
}

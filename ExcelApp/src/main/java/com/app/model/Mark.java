package com.app.model;

public class Mark {
	private int markId;
	private int english;
	private int mathematics;
	private int science;
	private int socialScience;
	private int hindi;
	private int physicalEducation;
	private int drawing;
	private int sanskrit;
	private int moralScience;
	public Mark() {
		super();
	}
	public Mark(int markId, int english, int mathematics, int science, int socialScience, int hindi,
			int physicalEducation, int drawing, int sanskrit, int moralScience) {
		super();
		this.markId = markId;
		this.english = english;
		this.mathematics = mathematics;
		this.science = science;
		this.socialScience = socialScience;
		this.hindi = hindi;
		this.physicalEducation = physicalEducation;
		this.drawing = drawing;
		this.sanskrit = sanskrit;
		this.moralScience = moralScience;
	}
	public int getMarkId() {
		return markId;
	}
	public void setMarkId(int markId) {
		this.markId = markId;
	}
	public int getEnglish() {
		return english;
	}
	public void setEnglish(int english) {
		this.english = english;
	}
	public int getMathematics() {
		return mathematics;
	}
	public void setMathematics(int mathematics) {
		this.mathematics = mathematics;
	}
	public int getScience() {
		return science;
	}
	public void setScience(int science) {
		this.science = science;
	}
	public int getSocialScience() {
		return socialScience;
	}
	public void setSocialScience(int socialScience) {
		this.socialScience = socialScience;
	}
	public int getHindi() {
		return hindi;
	}
	public void setHindi(int hindi) {
		this.hindi = hindi;
	}
	public int getPhysicalEducation() {
		return physicalEducation;
	}
	public void setPhysicalEducation(int physicalEducation) {
		this.physicalEducation = physicalEducation;
	}
	public int getDrawing() {
		return drawing;
	}
	public void setDrawing(int drawing) {
		this.drawing = drawing;
	}
	public int getSanskrit() {
		return sanskrit;
	}
	public void setSanskrit(int sanskrit) {
		this.sanskrit = sanskrit;
	}
	public int getMoralScience() {
		return moralScience;
	}
	public void setMoralScience(int moralScience) {
		this.moralScience = moralScience;
	}
	@Override
	public String toString() {
		return "{\"markId\":\"" + markId + "\", "
				+ "\"english\":\"" + english + "\", "
				+ "\"mathematics\":\"" + mathematics + "\","
				+ "\"science\":\""+ science + "\", "
				+ "\"socialScience\":\"" + socialScience + "\","
				+ "\"hindi\":\"" + hindi + "\","
				+ "\"physicalEducation\":\""+ physicalEducation + "\", "
				+ "\"drawing\":\"" + drawing + "\","
				+ "\"sanskrit\":\"" + sanskrit + "\","
				+ "\"moralScience\":\""+ moralScience + "\"}";
	}
	
}

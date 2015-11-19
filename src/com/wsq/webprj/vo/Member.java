package com.wsq.webprj.vo;

import java.sql.Date;

public class Member {


	private String mid;
	private String name;
	private String pwd;
	private Date regDate;
	private String speakingLanguage;
	private String learningLanguage;
	private String country;
	
	
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getSpeakingLanguage() {
		return speakingLanguage;
	}
	public void setSpeakingLanguage(String speakingLanguage) {
		this.speakingLanguage = speakingLanguage;
	}
	public String getLearningLanguage() {
		return learningLanguage;
	}
	public void setLearningLanguage(String learningLanguage) {
		this.learningLanguage = learningLanguage;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
	
	

	

	
	
	
	
	
}

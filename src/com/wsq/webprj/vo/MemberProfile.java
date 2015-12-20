package com.wsq.webprj.vo;

import java.util.Date;

public class MemberProfile {
	private String member_mid;
	private String name;
	private String age;
	private String gender;
	private String nationality_country_code;
	private String habitat_country_code;
/*	private String levelMentor;
	private String levelMentee;*/
	private String comment;
	private String email;
	private String country;
	private Date regDate;

	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getMember_mid() {
		return member_mid;
	}
	public void setMember_mid(String member_mid) {
		this.member_mid = member_mid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getNationality_country_code() {
		return nationality_country_code;
	}
	public void setNationality_country_code(String nationality_country_code) {
		this.nationality_country_code = nationality_country_code;
	}
	public String getHabitat_country_code() {
		return habitat_country_code;
	}
	public void setHabitat_country_code(String habitat_country_code) {
		this.habitat_country_code = habitat_country_code;
	}
/*	public String getLevelMentor() {
		return levelMentor;
	}
	public void setLevelMentor(String levelMentor) {
		this.levelMentor = levelMentor;
	}
	public String getLevelMentee() {
		return levelMentee;
	}
	public void setLevelMentee(String levelMentee) {
		this.levelMentee = levelMentee;
	}*/
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

	
	
}

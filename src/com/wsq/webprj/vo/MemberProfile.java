package com.wsq.webprj.vo;

import java.util.Date;

public class MemberProfile {
	private String member_mid;
	private String name;
	private String age;
	private String gender;
/*	private String levelMentor;
	private String levelMentee;*/
	private String comment;
	private String email;
	private String habitat_country;
	private String nationality_country;
	private Date regDate;

	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getHabitat_country() {
		return habitat_country;
	}
	public void setHabitat_country(String habitat_country) {
		this.habitat_country = habitat_country;
	}
	public String getNationality_country() {
		return nationality_country;
	}
	public void setNationality_country(String nationality_country) {
		this.nationality_country = nationality_country;
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

package com.wsq.webprj.vo;

public class MyPartnerView {
	private String members_mid;
	private String mypartners_mid;
	private String Email;
	private String native_language;
	private String learning_language;
	private String nationality_country;
	private String habitat_country;
	private String mentor_level;
	private String mentee_level;
	private String regdate;
	

	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getNative_language() {
		return native_language;
	}
	public void setNative_language(String native_language) {
		this.native_language = native_language;
	}
	public String getLearning_language() {
		return learning_language;
	}
	public void setLearning_language(String learning_language) {
		this.learning_language = learning_language;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getNationality_country() {
		return nationality_country;
	}
	public void setNationality_country(String nationality_country) {
		this.nationality_country = nationality_country;
	}
	public String getHabitat_country() {
		return habitat_country;
	}
	public void setHabitat_country(String habitat_country) {
		this.habitat_country = habitat_country;
	}
	public String getMembers_mid() {
		return members_mid;
	}
	public void setMembers_mid(String members_mid) {
		this.members_mid = members_mid;
	}
	public String getMypartners_mid() {
		return mypartners_mid;
	}
	public void setMypartners_mid(String mypartners_mid) {
		this.mypartners_mid = mypartners_mid;
	}
	public String getMentee_level() {
		return mentee_level;
	}
	public void setMentee_level(String mentee_level) {
		this.mentee_level = mentee_level;
	}
	public String getMentor_level() {
		return mentor_level;
	}
	public void setMentor_level(String mentor_level) {
		this.mentor_level = mentor_level;
	}
	
}

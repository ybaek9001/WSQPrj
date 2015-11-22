package com.wsq.webprj.vo;

public class MemberProfile {
	private String member_mid;
	private String name;
	private int age;
	private String gender;
	private int nationality_country_code;
	private int habitat_country_code;
	private String levelMentor;
	private String levelMentee;
	private String text;
	
	
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getNationality_country_code() {
		return nationality_country_code;
	}
	public void setNationality_country_code(int nationality_country_code) {
		this.nationality_country_code = nationality_country_code;
	}
	public int getHabitat_country_code() {
		return habitat_country_code;
	}
	public void setHabitat_country_code(int habitat_country_code) {
		this.habitat_country_code = habitat_country_code;
	}
	public String getLevelMentor() {
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
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	
}

package com.wsq.webprj.vo;

public class LearningLanguage {
	private String member_mid;
	private String learning_num;
	private String l_language_code;
	private String mentee_level;
	private String learning_language;
	
	public String getLanguage_num() {
		return learning_num;
	}
	public void setLanguage_num(String learning_num) {
		this.learning_num = learning_num;
	}

	public String getLearning_num() {
		return learning_num;
	}
	public void setLearning_num(String learning_num) {
		this.learning_num = learning_num;
	}
	public String getL_language_code() {
		return l_language_code;
	}
	public void setL_language_code(String l_language_code) {
		this.l_language_code = l_language_code;
	}
	
	public String getMentee_level() {
		return mentee_level;
	}
	public void setMentee_level(String mentee_level) {
		this.mentee_level = mentee_level;
	}

	public String getMember_mid() {
		return member_mid;
	}
	public void setMember_mid(String member_mid) {
		this.member_mid = member_mid;
	}
	public String getLearning_language() {
		return learning_language;
	}
	public void setLearning_language(String learning_language) {
		this.learning_language = learning_language;
	}
	public void setLearning_num(int i) {	
		String ln = Integer.toString(i);
		this.learning_num = ln;
	}
	
	
}

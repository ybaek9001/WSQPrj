package com.wsq.webprj.vo;

public class NativeLanguage {
	private String mid;
	private String native_num;
	private String n_language_code;
	private String mentor_level;
	private String native_language;
	
	
	public String getNative_num() {
		return native_num;
	}
	public void setNative_num(String native_num) {
		this.native_num = native_num;
	}
	
	public String getN_language_code() {
		return n_language_code;
	}
	public void setN_language_code(String n_language_code) {
		this.n_language_code = n_language_code;
	}
	public String getMentor_level() {
		return mentor_level;
	}
	public void setMentor_level(String mentor_level) {
		this.mentor_level = mentor_level;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getNative_language() {
		return native_language;
	}
	public void setNative_language(String native_language) {
		this.native_language = native_language;
	}
	public void setNative_num(int i) {
		String nn = Integer.toString(i);
		this.native_num = nn;
		
	}
	
	
	
}

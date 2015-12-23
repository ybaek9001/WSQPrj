package com.wsq.webprj.vo;


public class LanguageCode {
	
	private String n_language_code1;
	private String n_language_code2;
	private String n_language_code3;
	
	private String mentor_level1;
	private String mentor_level2;
	private String mentor_level3;
	
	private String l_language_code1;
	private String l_language_code2;
	private String l_language_code3;
	
	private String mentee_level1;
	private String mentee_level2;
	private String mentee_level3;
	
	String[] nl_code_list = new String[3];
	String[] mentor_lv_list = new String[3];
	String[] ll_code_list = new String[3];
	String[] mentee_lv_list = new String[3];
	
	
	public String[] getNL_Code_List(){
		nl_code_list[0] = n_language_code1;
		nl_code_list[1] = n_language_code2;
		nl_code_list[2] = n_language_code3;
		return nl_code_list;
	}
	
	public String getL_language_code2() {
		return l_language_code2;
	}

	public String getL_language_code3() {
		return l_language_code3;
	}

	public String[] getLL_Code_List(){
		ll_code_list[0] = l_language_code1;
		ll_code_list[1] = l_language_code2;
		ll_code_list[2] = l_language_code3;
		return ll_code_list;
	}
	
	public String[] getMentor_LV_List(){
		mentor_lv_list[0] = mentor_level1;
		mentor_lv_list[1] = mentor_level2;
		mentor_lv_list[2] = mentor_level3;
		return mentor_lv_list;
	}
	
	public String[] getMentee_LV_List(){
		mentee_lv_list[0] = mentee_level1;
		mentee_lv_list[1] = mentee_level2;
		mentee_lv_list[2] = mentee_level3;
		return mentee_lv_list;
	}

	public void setN_language_code1(String n_language_code1) {
		this.n_language_code1 = n_language_code1;
	}

	public void setN_language_code2(String n_language_code2) {
		this.n_language_code2 = n_language_code2;
	}

	public void setN_language_code3(String n_language_code3) {
		this.n_language_code3 = n_language_code3;
	}

	public void setMentor_level1(String mentor_level1) {
		this.mentor_level1 = mentor_level1;
	}

	public void setMentor_level2(String mentor_level2) {
		this.mentor_level2 = mentor_level2;
	}

	public void setMentor_level3(String mentor_level3) {
		this.mentor_level3 = mentor_level3;
	}

	public void setL_language_code1(String l_language_code1) {
		this.l_language_code1 = l_language_code1;
	}

	public void setL_language_code2(String l_language_code2) {
		this.l_language_code2 = l_language_code2;
	}

	public void setL_language_code3(String l_language_code3) {
		this.l_language_code3 = l_language_code3;
	}

	public void setMentee_level1(String mentee_level1) {
		this.mentee_level1 = mentee_level1;
	}

	public void setMentee_level2(String mentee_level2) {
		this.mentee_level2 = mentee_level2;
	}

	public void setMentee_level3(String mentee_level3) {
		this.mentee_level3 = mentee_level3;
	}

	public String getL_language_code1() {
		return l_language_code1;
	}

	
	
	
	
	
	


	
}

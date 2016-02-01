package com.wsq.webprj.vo;

import java.util.Date;

public class Reply {
	private String id;
	private String context;
	private Date regDate;
	private int debateCode;
	private String code;
	private boolean opinion;
	private String comment_code;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getDebateCode() {
		return debateCode;
	}
	public void setDebateCode(int debateCode) {
		this.debateCode = debateCode;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public boolean isOpinion() {
		return opinion;
	}
	public void setOpinion(boolean opinion) {
		this.opinion = opinion;
	}
	public String getComment_code() {
		return comment_code;
	}
	public void setComment_code(String comment_code) {
		this.comment_code = comment_code;
	}
	
	
	

}

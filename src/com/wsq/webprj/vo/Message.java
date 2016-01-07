package com.wsq.webprj.vo;

import java.util.Date;

public class Message {

	private String sending_members_mid;
	private String receiving_members_mid;
	private String comment;
	private Date date;
	private String code;
	
	
	
	public String getSending_members_mid() {
		return sending_members_mid;
	}
	public void setSending_members_mid(String sending_members_mid) {
		this.sending_members_mid = sending_members_mid;
	}
	public String getReceiving_members_mid() {
		return receiving_members_mid;
	}
	public void setReceiving_members_mid(String receiving_members_mid) {
		this.receiving_members_mid = receiving_members_mid;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	
	
}

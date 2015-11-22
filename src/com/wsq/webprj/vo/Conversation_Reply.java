package com.wsq.webprj.vo;

public class Conversation_Reply {
	private String members_mid;
	private String reply_text;
	private String ip_address;
	private int time;
	
	
	public String getMembers_mid() {
		return members_mid;
	}
	public void setMembers_mid(String members_mid) {
		this.members_mid = members_mid;
	}
	public String getReply_text() {
		return reply_text;
	}
	public void setReply_text(String reply_text) {
		this.reply_text = reply_text;
	}
	public String getIp_address() {
		return ip_address;
	}
	public void setIp_address(String ip_address) {
		this.ip_address = ip_address;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	
}

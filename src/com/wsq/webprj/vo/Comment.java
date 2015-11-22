package com.wsq.webprj.vo;

public class Comment {
	private String member_mid;
	private int debateSquare_code;
	private String agree_disagree;
	private String comment;
	private int recommend;
	
	
	public String getMember_mid() {
		return member_mid;
	}
	public void setMember_mid(String member_mid) {
		this.member_mid = member_mid;
	}
	public int getDebateSquare_code() {
		return debateSquare_code;
	}
	public void setDebateSquare_code(int debateSquare_code) {
		this.debateSquare_code = debateSquare_code;
	}
	public String getAgree_disagree() {
		return agree_disagree;
	}
	public void setAgree_disagree(String agree_disagree) {
		this.agree_disagree = agree_disagree;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getRecommend() {
		return recommend;
	}
	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}
	
	
	
}

package com.wsq.webprj.vo;

import java.awt.Image;
import java.util.Date;


public class DebateSquare {
	private String master_id;
	private int code;
	private String title;
	private String contents;
	private Image image;
	private int hit;
	private Date regDate;
	private int AgreeCnt;
	private int DisagreeCnt;
	private int CommentCnt;
	
	public String getMaster_id() {
		return master_id;
	}
	public void setMaster_id(String master_id) {
		this.master_id = master_id;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getAgreeCnt() {
		return AgreeCnt;
	}
	public void setAgreeCnt(int agreeCnt) {
		AgreeCnt = agreeCnt;
	}
	public int getDisagreeCnt() {
		return DisagreeCnt;
	}
	public void setDisagreeCnt(int disagreeCnt) {
		DisagreeCnt = disagreeCnt;
	}
	public int getCommentCnt() {
		return CommentCnt;
	}
	public void setCommentCnt(int commentCnt) {
		CommentCnt = commentCnt;
	}
	
		
	
}

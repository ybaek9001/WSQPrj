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
	private int agreeCnt;
	private int disAgreeCnt;
	private int commentCnt;
	
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
		return agreeCnt;
	}
	public void setAgreeCnt(int agreeCnt) {
		this.agreeCnt = agreeCnt;
	}
	public int getDisagreeCnt() {
		return disAgreeCnt;
	}
	public void setDisagreeCnt(int disAgreeCnt) {
		this.disAgreeCnt = disAgreeCnt;
	}
	public int getCommentCnt() {
		return commentCnt;
	}
	public void setCommentCnt(int commentCnt) {
		this.commentCnt = commentCnt;
	}
	
	
		
	
}

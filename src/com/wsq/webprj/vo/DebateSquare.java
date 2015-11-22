package com.wsq.webprj.vo;

import java.sql.Date;

public class DebateSquare {
	private String master_id;
	private int code;
	private String topic;
	//private img image;
	private String article;
	private int hits;
	private Date topic_regDate;
	private Date revision_date;
	//private String µî·Ïip;
	private String comment;
	private String cmt_num;
	private int recommend;
	private int cmt_rank;
	
	
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
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getArticle() {
		return article;
	}
	public void setArticle(String article) {
		this.article = article;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public Date getTopic_regDate() {
		return topic_regDate;
	}
	public void setTopic_regDate(Date topic_regDate) {
		this.topic_regDate = topic_regDate;
	}
	public Date getRevision_date() {
		return revision_date;
	}
	public void setRevision_date(Date revision_date) {
		this.revision_date = revision_date;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getCmt_num() {
		return cmt_num;
	}
	public void setCmt_num(String cmt_num) {
		this.cmt_num = cmt_num;
	}
	public int getRecommend() {
		return recommend;
	}
	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}
	public int getCmt_rank() {
		return cmt_rank;
	}
	public void setCmt_rank(int cmt_rank) {
		this.cmt_rank = cmt_rank;
	}
	
	
	
}

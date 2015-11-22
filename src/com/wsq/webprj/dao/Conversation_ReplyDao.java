package com.wsq.webprj.dao;

import java.sql.SQLException;
import java.util.List;

import com.wsq.webprj.vo.Conversation_Reply;



public interface Conversation_ReplyDao {

	public List<Conversation_Reply> getConvReply() throws SQLException;
	public List<Conversation_Reply> getConvReply(int page) throws SQLException;
	public List<Conversation_Reply> getConvReply(int page, String filed, String query) throws SQLException;
	
	public int update(Conversation_Reply conv_reply) throws SQLException;
	public int delete(String mid) throws SQLException;
	public int insert(Conversation_Reply conv_reply) throws SQLException;
	
		
	
	
}

package com.wsq.webprj.dao;

import java.sql.SQLException;
import java.util.List;

import com.wsq.webprj.vo.Conversation;



public interface ConversationDao {

	public List<Conversation> getConv() throws SQLException;
	public List<Conversation> getConv(int page) throws SQLException;
	public List<Conversation> getConv(int page, String filed, String query) throws SQLException;
	
	public int update(Conversation c) throws SQLException;
	public int delete(String mid) throws SQLException;
	public int insert(Conversation c) throws SQLException;
	
		
	
	
}

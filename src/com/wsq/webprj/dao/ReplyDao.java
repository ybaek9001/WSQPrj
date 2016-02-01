package com.wsq.webprj.dao;

import java.sql.SQLException;
import java.util.List;

import com.wsq.webprj.vo.Reply;

public interface ReplyDao{
	public List<Reply> getReplies(int commentCode);
	
	public int insert() throws SQLException;
	public int update() throws SQLException;
	public int delete() throws SQLException;
}

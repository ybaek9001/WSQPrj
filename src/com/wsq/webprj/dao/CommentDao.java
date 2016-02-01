package com.wsq.webprj.dao;

import java.sql.SQLException;
import java.util.List;
import com.wsq.webprj.vo.Comment;


public interface CommentDao {

	public List<Comment> getComments(String code);
	public int insert(Comment comment) throws SQLException;
	
	public int update(String code, String context) throws SQLException;
	public int delete(String code) throws SQLException;
	
		
	
	
}

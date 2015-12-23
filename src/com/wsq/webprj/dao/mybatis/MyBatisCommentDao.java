package com.wsq.webprj.dao.mybatis;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.wsq.webprj.dao.CommentDao;
import com.wsq.webprj.vo.Comment;



public class MyBatisCommentDao implements CommentDao {
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<Comment> getComments() throws SQLException {
		return getComments(1, "MID", "");
	}

	@Override
	public List<Comment> getComments(int page) throws SQLException {
		
		return getComments(page, "MID", "");
	}

	@Override
	public List<Comment> getComments(int page, String field, String query) throws SQLException {
		
		CommentDao dao = sqlSession.getMapper(CommentDao.class);
		List<Comment>list = dao.getComments(page, field, query);
		
		return list;
	}

	@Override
	public int update(Comment comment) throws SQLException {
		
		CommentDao dao = sqlSession.getMapper(CommentDao.class);
		int count = dao.update(comment);
		
		return count;
	}

	@Override
	public int delete(String mid) throws SQLException {
		
		CommentDao dao = sqlSession.getMapper(CommentDao.class);
		int count = dao.delete(mid);
		
		return count;
	}

	@Override
	public int insert(Comment comment) throws SQLException  {
		
		CommentDao dao = sqlSession.getMapper(CommentDao.class);
		int count = dao.insert(comment);
		
		return count;
	}




}

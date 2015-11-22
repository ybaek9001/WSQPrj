package com.wsq.webprj.dao.mybatis;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.wsq.webprj.dao.CommentDao;
import com.wsq.webprj.vo.Comment;



public class MyBatisCommentDao implements CommentDao {
	
	SqlSessionFactory ssf = NewlecSqlSessionFactoryBuilder.getSqlSessionFactory();
	
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
		SqlSession session = ssf.openSession();
		CommentDao dao = session.getMapper(CommentDao.class);
		List<Comment>list = dao.getComments(page, field, query);
		session.close();
		return list;
	}

	@Override
	public int update(Comment comment) throws SQLException {
		SqlSession session = ssf.openSession();
		CommentDao dao = session.getMapper(CommentDao.class);
		int count = dao.update(comment);
		session.commit();
		session.close();
		return count;
	}

	@Override
	public int delete(String mid) throws SQLException {
		SqlSession session = ssf.openSession();
		CommentDao dao = session.getMapper(CommentDao.class);
		int count = dao.delete(mid);
		session.commit();
		session.close();
		return count;
	}

	@Override
	public int insert(Comment comment) throws SQLException  {
		SqlSession session = ssf.openSession();
		CommentDao dao = session.getMapper(CommentDao.class);
		int count = dao.insert(comment);
		session.commit();
		session.close();
		return count;
	}




}

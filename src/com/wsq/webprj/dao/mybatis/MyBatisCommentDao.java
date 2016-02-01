package com.wsq.webprj.dao.mybatis;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.wsq.webprj.dao.CommentDao;
import com.wsq.webprj.dao.DebateSquareDao;
import com.wsq.webprj.vo.Comment;
import com.wsq.webprj.vo.DebateSquare;



public class MyBatisCommentDao implements CommentDao {
	
	//SqlSessionFactory ssf = NewlecSqlSessionFactoryBuilder.getSqlSessionFactory();
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public int update(String code, String context) throws SQLException {
		CommentDao dao = sqlSession.getMapper(CommentDao.class);
		int count = dao.update(code, context);
		
		return count;
	}

	@Override
	public int delete(String code) throws SQLException {
		CommentDao dao = sqlSession.getMapper(CommentDao.class);
		int count = dao.delete(code);
		
		return count;
	}

	@Override
	public int insert(Comment comment) throws SQLException  {
		CommentDao dao = sqlSession.getMapper(CommentDao.class);
		int count = dao.insert(comment);
		
		return count;
	}

	@Override
	public List<Comment> getComments(String code) {
		CommentDao commentDao = sqlSession.getMapper(CommentDao.class); // mapper按眉 积己
		List<Comment> comment = commentDao.getComments(code);

		//sqlSession.close(); // 技记 辆丰.

		return comment;
	}




}

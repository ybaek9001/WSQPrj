package com.wsq.webprj.dao.mybatis;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.wsq.webprj.dao.ReplyDao;
import com.wsq.webprj.vo.Reply;

public class MyBatisReplyDao implements ReplyDao {

	@Autowired	
	SqlSession sqlSession;
	
	@Override
	public List<Reply> getReplies(int commentCode) {
		ReplyDao replyDao = sqlSession.getMapper(ReplyDao.class); // mapper°´Ã¼ »ý¼º
		List<Reply> reply = replyDao.getReplies(commentCode);
		
		return reply;
	}

	@Override
	public int insert() throws SQLException {
		ReplyDao dao = sqlSession.getMapper(ReplyDao.class);
		int count = dao.insert();
		
		return count;
	}

	@Override
	public int update() throws SQLException {
		ReplyDao dao = sqlSession.getMapper(ReplyDao.class);
		int count = dao.update();
		
		return count;
	}

	@Override
	public int delete() throws SQLException {
		ReplyDao dao = sqlSession.getMapper(ReplyDao.class);
		int count = dao.delete();
		
		return count;
	}

}

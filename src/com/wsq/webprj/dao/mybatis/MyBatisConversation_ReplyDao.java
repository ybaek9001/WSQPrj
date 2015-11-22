package com.wsq.webprj.dao.mybatis;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.wsq.webprj.dao.Conversation_ReplyDao;
import com.wsq.webprj.vo.Conversation_Reply;


public class MyBatisConversation_ReplyDao implements Conversation_ReplyDao{
	
	SqlSessionFactory ssf = NewlecSqlSessionFactoryBuilder.getSqlSessionFactory();
	
	@Override
	public List<Conversation_Reply> getConvReply()throws SQLException {
		return getConvReply(1, "MID", "");
	}

	@Override
	public List<Conversation_Reply> getConvReply(int page) throws SQLException {
		
		return getConvReply(page, "MID", "");
	}

	@Override
	public List<Conversation_Reply> getConvReply(int page, String filed, String query) throws SQLException {
		SqlSession session = ssf.openSession();
		Conversation_ReplyDao dao = session.getMapper(Conversation_ReplyDao.class);
		List<Conversation_Reply>list = dao.getConvReply(page,filed,query);
		session.close();
		return list;
	}

	@Override
	public int update(Conversation_Reply conv_reply) throws SQLException {
		SqlSession session = ssf.openSession();
		Conversation_ReplyDao dao = session.getMapper(Conversation_ReplyDao.class);
		int count = dao.update(conv_reply);
		session.commit();
		session.close();
		return count;
	}

	@Override
	public int delete(String mid) throws SQLException {
		SqlSession session = ssf.openSession();
		Conversation_ReplyDao dao = session.getMapper(Conversation_ReplyDao.class);
		int count = dao.delete(mid);
		session.commit();
		session.close();
		return count;
	}

	@Override
	public int insert(Conversation_Reply conv_reply) throws SQLException  {
		SqlSession session = ssf.openSession();
		Conversation_ReplyDao dao = session.getMapper(Conversation_ReplyDao.class);
		int count = dao.insert(conv_reply);
		session.commit();
		session.close();
		return count;
	}


	

}

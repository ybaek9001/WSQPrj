package com.wsq.webprj.dao.mybatis;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.wsq.webprj.dao.ConversationDao;
import com.wsq.webprj.vo.Conversation;

public class MyBatisConversationDao implements ConversationDao{
	
	SqlSessionFactory ssf = NewlecSqlSessionFactoryBuilder.getSqlSessionFactory();
	
	@Override
	public List<Conversation> getConv() throws SQLException {
		return getConv(1, "MID", "");
	}

	@Override
	public List<Conversation> getConv(int page) throws SQLException {
		
		return getConv(page, "MID", "");
	}

	@Override
	public List<Conversation> getConv(int page, String filed, String query) throws SQLException {
		SqlSession session = ssf.openSession();
		ConversationDao dao = session.getMapper(ConversationDao.class);
		List<Conversation>list = dao.getConv(page,filed,query);
		session.close();
		return list;
	}

	@Override
	public int update(Conversation c) throws SQLException {
		SqlSession session = ssf.openSession();
		ConversationDao dao = session.getMapper(ConversationDao.class);
		int count = dao.update(c);
		session.commit();
		session.close();
		return count;
	}

	@Override
	public int delete(String mid) throws SQLException {
		SqlSession session = ssf.openSession();
		ConversationDao dao = session.getMapper(ConversationDao.class);
		int count = dao.delete(mid);
		session.commit();
		session.close();
		return count;
	}

	@Override
	public int insert(Conversation c) throws SQLException  {
		SqlSession session = ssf.openSession();
		ConversationDao dao = session.getMapper(ConversationDao.class);
		int count = dao.insert(c);
		session.commit();
		session.close();
		return count;
	}

}

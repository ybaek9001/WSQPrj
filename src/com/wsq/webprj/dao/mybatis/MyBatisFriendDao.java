package com.wsq.webprj.dao.mybatis;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.wsq.webprj.dao.FriendDao;
import com.wsq.webprj.dao.FriendDao;
import com.wsq.webprj.vo.Friend;

public class MyBatisFriendDao implements FriendDao{
	
	SqlSessionFactory ssf = NewlecSqlSessionFactoryBuilder.getSqlSessionFactory();
	
	@Override
	public List<Friend> getFriends() throws SQLException {
		return getFriends(1, "MID", "");
	}

	@Override
	public List<Friend> getFriends(int page) throws SQLException {
		
		return getFriends(page, "MID", "");
	}

	@Override
	public List<Friend> getFriends(int page, String field, String query) throws SQLException {
		SqlSession session = ssf.openSession();
		FriendDao dao = session.getMapper(FriendDao.class);
		List<Friend>list = dao.getFriends(page,field,query);
		session.close();
		return list;
	}

	@Override
	public int update(Friend friend) throws SQLException {
		SqlSession session = ssf.openSession();
		FriendDao dao = session.getMapper(FriendDao.class);
		int count = dao.update(friend);
		session.commit();
		session.close();
		return count;
	}

	@Override
	public int delete(String mid) throws SQLException {
		SqlSession session = ssf.openSession();
		FriendDao dao = session.getMapper(FriendDao.class);
		int count = dao.delete(mid);
		session.commit();
		session.close();
		return count;
	}

	@Override
	public int insert(Friend friend) throws SQLException  {
		SqlSession session = ssf.openSession();
		FriendDao dao = session.getMapper(FriendDao.class);
		int count = dao.insert(friend);
		session.commit();
		session.close();
		return count;
	}

}

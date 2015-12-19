package com.wsq.webprj.dao.mybatis;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.wsq.webprj.dao.FriendDao;
import com.wsq.webprj.vo.Friend;

public class MyBatisFriendDao implements FriendDao{
	
	@Autowired
	private SqlSession sqlSession;
	
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
		
		FriendDao friendDao = sqlSession.getMapper(FriendDao.class);
		List<Friend>list = friendDao.getFriends(page,field,query);
	
		return list;
	}

	@Override
	public int update(Friend friend) throws SQLException {
	
		FriendDao friendDao = sqlSession.getMapper(FriendDao.class);
		int count = friendDao.update(friend);
	
		return count;
	}

	@Override
	public int delete(String mid)  {
		
		FriendDao friendDao = sqlSession.getMapper(FriendDao.class);
		int count = friendDao.delete(mid);
		return count;
	}

	@Override
	public int insert(Friend friend) throws SQLException  {
	
		FriendDao friendDao = sqlSession.getMapper(FriendDao.class);
		int count = friendDao.insert(friend);
	
		return count;
	}

	@Override
	public int insert(String key) {
		FriendDao friendDao = sqlSession.getMapper(FriendDao.class);
		int count = friendDao.insert(key);
		return count;
	}

}

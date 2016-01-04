package com.wsq.webprj.dao.mybatis;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.wsq.webprj.dao.MyPartnerDao;
import com.wsq.webprj.vo.MyPartner;

public class MyBatisMyPartnerDao implements MyPartnerDao{
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<MyPartner> getFriends() throws SQLException {
		return getFriends(1, "MID", "");
	}

	@Override
	public List<MyPartner> getFriends(int page) throws SQLException {
		
		return getFriends(page, "MID", "");
	}

	@Override
	public List<MyPartner> getFriends(int page, String field, String query) throws SQLException {
		
		MyPartnerDao friendDao = sqlSession.getMapper(MyPartnerDao.class);
		List<MyPartner>list = friendDao.getFriends(page,field,query);
	
		return list;
	}

	@Override
	public int update(MyPartner friend) throws SQLException {
	
		MyPartnerDao friendDao = sqlSession.getMapper(MyPartnerDao.class);
		int count = friendDao.update(friend);
	
		return count;
	}

	@Override
	public int delete(String mid)  {
		
		MyPartnerDao friendDao = sqlSession.getMapper(MyPartnerDao.class);
		int count = friendDao.delete(mid);
		return count;
	}

/*	@Override
	public int insert(MyPartner friend) throws SQLException  {
	
		MyPartnerDao friendDao = sqlSession.getMapper(MyPartnerDao.class);
		int count = friendDao.insert(friend);
	
		return count;
	}

	@Override
	public int insert(String key) {
		MyPartnerDao friendDao = sqlSession.getMapper(MyPartnerDao.class);
		int count = friendDao.insert(key);
		return count;
	}*/

	@Override
	public int insert(MyPartner myPartner) {
		MyPartnerDao friendDao = sqlSession.getMapper(MyPartnerDao.class);
		int count = friendDao.insert(myPartner);
		return count;
	}

	@Override
	public List<MyPartner> getWaitingList(String members_mid, String request) {
		MyPartnerDao friendDao = sqlSession.getMapper(MyPartnerDao.class);
		List<MyPartner>list = friendDao.getWaitingList(members_mid, request);
	
		return list;
	}

}

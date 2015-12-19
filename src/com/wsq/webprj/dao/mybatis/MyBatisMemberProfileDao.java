package com.wsq.webprj.dao.mybatis;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.wsq.webprj.dao.MemberProfileDao;
import com.wsq.webprj.dao.MemberProfileDao;
import com.wsq.webprj.vo.MemberProfile;

public class MyBatisMemberProfileDao implements MemberProfileDao{
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<MemberProfile> getProfiles() throws SQLException {
		return getProfiles(1, "MID", "");
	}

	@Override
	public List<MemberProfile> getProfiles(int page) throws SQLException {
		
		return getProfiles(page, "MID", "");
	}

	@Override
	public List<MemberProfile> getProfiles(int page, String field, String query) throws SQLException {
		
		MemberProfileDao dao = sqlSession.getMapper(MemberProfileDao.class);
		List<MemberProfile>list = dao.getProfiles(page,field,query);
		
		return list;
	}

	@Override
	public int update(MemberProfile mProfile) throws SQLException {
		
		MemberProfileDao dao = sqlSession.getMapper(MemberProfileDao.class);
		int count = dao.update(mProfile);
		
		return count;
	}

	@Override
	public int delete(String mid) throws SQLException {
		
		MemberProfileDao dao = sqlSession.getMapper(MemberProfileDao.class);
		int count = dao.delete(mid);
		
		return count;
	}


	@Override
	public int insert(String mid) {
		MemberProfileDao dao = sqlSession.getMapper(MemberProfileDao.class);
		int count = dao.insert(mid);
		
		return count;
	}

}

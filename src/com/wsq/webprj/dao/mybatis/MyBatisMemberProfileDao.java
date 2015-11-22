package com.wsq.webprj.dao.mybatis;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.wsq.webprj.dao.MemberProfileDao;
import com.wsq.webprj.dao.MemberProfileDao;
import com.wsq.webprj.vo.MemberProfile;

public class MyBatisMemberProfileDao implements MemberProfileDao{
	
	SqlSessionFactory ssf = NewlecSqlSessionFactoryBuilder.getSqlSessionFactory();
	
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
		SqlSession session = ssf.openSession();
		MemberProfileDao dao = session.getMapper(MemberProfileDao.class);
		List<MemberProfile>list = dao.getProfiles(page,field,query);
		session.close();
		return list;
	}

	@Override
	public int update(MemberProfile mProfile) throws SQLException {
		SqlSession session = ssf.openSession();
		MemberProfileDao dao = session.getMapper(MemberProfileDao.class);
		int count = dao.update(mProfile);
		session.commit();
		session.close();
		return count;
	}

	@Override
	public int delete(String mid) throws SQLException {
		SqlSession session = ssf.openSession();
		MemberProfileDao dao = session.getMapper(MemberProfileDao.class);
		int count = dao.delete(mid);
		session.commit();
		session.close();
		return count;
	}

	@Override
	public int insert(MemberProfile mProfile) throws SQLException  {
		SqlSession session = ssf.openSession();
		MemberProfileDao dao = session.getMapper(MemberProfileDao.class);
		int count = dao.insert(mProfile);
		session.commit();
		session.close();
		return count;
	}

}

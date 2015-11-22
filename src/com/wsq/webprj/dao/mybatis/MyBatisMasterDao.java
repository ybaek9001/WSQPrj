package com.wsq.webprj.dao.mybatis;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.wsq.webprj.dao.MasterDao;
import com.wsq.webprj.dao.MasterDao;
import com.wsq.webprj.vo.Master;

public class MyBatisMasterDao implements MasterDao{
	
	SqlSessionFactory ssf = NewlecSqlSessionFactoryBuilder.getSqlSessionFactory();
	
	@Override
	public List<Master> getMasters() throws SQLException {
		return getMasters(1, "MID", "");
	}

	@Override
	public List<Master> getMasters(int page) throws SQLException {
		
		return getMasters(page, "MID", "");
	}

	@Override
	public List<Master> getMasters(int page, String field, String query) throws SQLException {
		SqlSession session = ssf.openSession();
		MasterDao dao = session.getMapper(MasterDao.class);
		List<Master>list = dao.getMasters(page,field,query);
		session.close();
		return list;
	}

	@Override
	public int update(Master master) throws SQLException {
		SqlSession session = ssf.openSession();
		MasterDao dao = session.getMapper(MasterDao.class);
		int count = dao.update(master);
		session.commit();
		session.close();
		return count;
	}

	@Override
	public int delete(String mid) throws SQLException {
		SqlSession session = ssf.openSession();
		MasterDao dao = session.getMapper(MasterDao.class);
		int count = dao.delete(mid);
		session.commit();
		session.close();
		return count;
	}

	@Override
	public int insert(Master master) throws SQLException  {
		SqlSession session = ssf.openSession();
		MasterDao dao = session.getMapper(MasterDao.class);
		int count = dao.insert(master);
		session.commit();
		session.close();
		return count;
	}

}

package com.wsq.webprj.dao.mybatis;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.wsq.webprj.dao.CountryDao;
import com.wsq.webprj.vo.Country;

public class MyBatisCountryDao implements CountryDao{
	
	SqlSessionFactory ssf = NewlecSqlSessionFactoryBuilder.getSqlSessionFactory();
	
	@Override
	public List<Country> getCountries() throws SQLException {
		return getCountries(1, "MID", "");
	}

	@Override
	public List<Country> getCountries(int page) throws SQLException {
		
		return getCountries(page, "MID", "");
	}

	@Override
	public List<Country> getCountries(int page, String field, String query) throws SQLException {
		SqlSession session = ssf.openSession();
		CountryDao dao = session.getMapper(CountryDao.class);
		List<Country>list = dao.getCountries(page,field,query);
		session.close();
		return list;
	}

	@Override
	public int update(Country country) throws SQLException {
		SqlSession session = ssf.openSession();
		CountryDao dao = session.getMapper(CountryDao.class);
		int count = dao.update(country);
		session.commit();
		session.close();
		return count;
	}

	@Override
	public int delete(String mid) throws SQLException {
		SqlSession session = ssf.openSession();
		CountryDao dao = session.getMapper(CountryDao.class);
		int count = dao.delete(mid);
		session.commit();
		session.close();
		return count;
	}

	@Override
	public int insert(Country country) throws SQLException  {
		SqlSession session = ssf.openSession();
		CountryDao dao = session.getMapper(CountryDao.class);
		int count = dao.insert(country);
		session.commit();
		session.close();
		return count;
	}

}

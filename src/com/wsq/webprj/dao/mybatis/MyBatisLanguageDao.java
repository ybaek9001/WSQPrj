package com.wsq.webprj.dao.mybatis;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.wsq.webprj.dao.LanguageDao;
import com.wsq.webprj.vo.Language;

public class MyBatisLanguageDao implements LanguageDao{
	
	SqlSessionFactory ssf = NewlecSqlSessionFactoryBuilder.getSqlSessionFactory();
	
	@Override
	public List<Language> getLanguages() throws SQLException {
		return getLanguages(1, "MID", "");
	}

	@Override
	public List<Language> getLanguages(int page) throws SQLException {
		
		return getLanguages(page, "MID", "");
	}

	@Override
	public List<Language> getLanguages(int page, String field, String query) throws SQLException {
		SqlSession session = ssf.openSession();
		LanguageDao dao = session.getMapper(LanguageDao.class);
		List<Language>list = dao.getLanguages(page,field,query);
		session.close();
		return list;
	}

	@Override
	public int update(Language language) throws SQLException {
		SqlSession session = ssf.openSession();
		LanguageDao dao = session.getMapper(LanguageDao.class);
		int count = dao.update(language);
		session.commit();
		session.close();
		return count;
	}

	@Override
	public int delete(String mid) throws SQLException {
		SqlSession session = ssf.openSession();
		LanguageDao dao = session.getMapper(LanguageDao.class);
		int count = dao.delete(mid);
		session.commit();
		session.close();
		return count;
	}

	@Override
	public int insert(Language language, int i){
		SqlSession session = ssf.openSession();
		LanguageDao dao = session.getMapper(LanguageDao.class);
		int count = dao.insert(language, i);
		session.commit();
		session.close();
		return count;
	}

}

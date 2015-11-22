package com.wsq.webprj.dao.mybatis;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.wsq.webprj.dao.LearningLanguageDao;
import com.wsq.webprj.vo.LearningLanguage;

public class MyBatisLearningLanguageDao implements LearningLanguageDao{
	
	SqlSessionFactory ssf = NewlecSqlSessionFactoryBuilder.getSqlSessionFactory();
	
	@Override
	public List<LearningLanguage> getL_Languages() throws SQLException {
		return getL_Languages(1, "MID", "");
	}

	@Override
	public List<LearningLanguage> getL_Languages(int page) throws SQLException {
		
		return getL_Languages(page, "MID", "");
	}

	@Override
	public List<LearningLanguage> getL_Languages(int page, String field, String query) throws SQLException {
		SqlSession session = ssf.openSession();
		LearningLanguageDao dao = session.getMapper(LearningLanguageDao.class);
		List<LearningLanguage>list = dao.getL_Languages(page,field,query);
		session.close();
		return list;
	}

	@Override
	public int update(LearningLanguage l_language) throws SQLException {
		SqlSession session = ssf.openSession();
		LearningLanguageDao dao = session.getMapper(LearningLanguageDao.class);
		int count = dao.update(l_language);
		session.commit();
		session.close();
		return count;
	}

	@Override
	public int delete(String mid) throws SQLException {
		SqlSession session = ssf.openSession();
		LearningLanguageDao dao = session.getMapper(LearningLanguageDao.class);
		int count = dao.delete(mid);
		session.commit();
		session.close();
		return count;
	}

	@Override
	public int insert(LearningLanguage l_language) throws SQLException  {
		SqlSession session = ssf.openSession();
		LearningLanguageDao dao = session.getMapper(LearningLanguageDao.class);
		int count = dao.insert(l_language);
		session.commit();
		session.close();
		return count;
	}

}

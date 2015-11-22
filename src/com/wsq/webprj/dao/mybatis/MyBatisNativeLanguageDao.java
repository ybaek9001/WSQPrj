package com.wsq.webprj.dao.mybatis;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.wsq.webprj.dao.NativeLanguageDao;
import com.wsq.webprj.vo.NativeLanguage;

public class MyBatisNativeLanguageDao implements NativeLanguageDao{
	
	SqlSessionFactory ssf = NewlecSqlSessionFactoryBuilder.getSqlSessionFactory();
	
	@Override
	public List<NativeLanguage> getN_Language() throws SQLException {
		return getN_Language(1, "MID", "");
	}

	@Override
	public List<NativeLanguage> getN_Language(int page) throws SQLException {
		
		return getN_Language(page, "MID", "");
	}

	@Override
	public List<NativeLanguage> getN_Language(int page, String fieled, String query) throws SQLException {
		SqlSession session = ssf.openSession();
		NativeLanguageDao dao = session.getMapper(NativeLanguageDao.class);
		List<NativeLanguage>list = dao.getN_Language(page,fieled,query);
		session.close();
		return list;
	}

	@Override
	public int update(NativeLanguage n_language) throws SQLException {
		SqlSession session = ssf.openSession();
		NativeLanguageDao dao = session.getMapper(NativeLanguageDao.class);
		int count = dao.update(n_language);
		session.commit();
		session.close();
		return count;
	}

	@Override
	public int delete(String mid) throws SQLException {
		SqlSession session = ssf.openSession();
		NativeLanguageDao dao = session.getMapper(NativeLanguageDao.class);
		int count = dao.delete(mid);
		session.commit();
		session.close();
		return count;
	}

	@Override
	public int insert(NativeLanguage n_language) throws SQLException  {
		SqlSession session = ssf.openSession();
		NativeLanguageDao dao = session.getMapper(NativeLanguageDao.class);
		int count = dao.insert(n_language);
		session.commit();
		session.close();
		return count;
	}

}

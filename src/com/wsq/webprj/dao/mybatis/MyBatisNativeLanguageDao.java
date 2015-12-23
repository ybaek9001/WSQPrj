package com.wsq.webprj.dao.mybatis;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.wsq.webprj.dao.NativeLanguageDao;
import com.wsq.webprj.vo.NativeLanguage;

public class MyBatisNativeLanguageDao implements NativeLanguageDao{
	
	@Autowired
	SqlSession sqlSession;
	
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
		
		NativeLanguageDao dao = sqlSession.getMapper(NativeLanguageDao.class);
		List<NativeLanguage>list = dao.getN_Language(page,fieled,query);
		
		return list;
	}

	@Override
	public int update(NativeLanguage n_language) {
		
		NativeLanguageDao dao = sqlSession.getMapper(NativeLanguageDao.class);
		int count = dao.update(n_language);
		
		return count;
	}

	@Override
	public int delete(String member_mid) throws SQLException {
		
		NativeLanguageDao dao = sqlSession.getMapper(NativeLanguageDao.class);
		int count = dao.delete(member_mid);
		
		return count;
	}


	@Override
	public int insertID(String profile_mid, String learning_num) {
		NativeLanguageDao dao = sqlSession.getMapper(NativeLanguageDao.class);
		int count = dao.insertID(profile_mid, learning_num);
		
		return count;
	}

	@Override
	public List<NativeLanguage> getNlanguagelist(String id) {
		NativeLanguageDao dao = sqlSession.getMapper(NativeLanguageDao.class);
		List<NativeLanguage> nList = dao.getNlanguagelist(id);
		return nList;
	}

	@Override
	public int insert(NativeLanguage n_language) {
		NativeLanguageDao dao = sqlSession.getMapper(NativeLanguageDao.class);
		int count = dao.insert(n_language);
		return count;
	}

}

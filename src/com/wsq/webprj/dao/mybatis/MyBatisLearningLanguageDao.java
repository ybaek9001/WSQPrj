package com.wsq.webprj.dao.mybatis;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.wsq.webprj.dao.LearningLanguageDao;
import com.wsq.webprj.vo.LearningLanguage;

public class MyBatisLearningLanguageDao implements LearningLanguageDao{
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<LearningLanguage> getL_Languages() throws SQLException {
		return getL_Languages(1, "MEMBER_MID", "");
	}

	@Override
	public List<LearningLanguage> getL_Languages(int page) throws SQLException {
		
		return getL_Languages(page, "MEMBER_MID", "");
	}

	@Override
	public List<LearningLanguage> getL_Languages(int page, String field, String query) throws SQLException {
		
		LearningLanguageDao dao = sqlSession.getMapper(LearningLanguageDao.class);
		List<LearningLanguage>list = dao.getL_Languages(page,field,query);
		
		return list;
	}

	@Override
	public int update(LearningLanguage l_language){
		
		LearningLanguageDao dao = sqlSession.getMapper(LearningLanguageDao.class);
		int count = dao.update(l_language);
		
		return count;
	}

	@Override
	public int delete(String member_mid) throws SQLException {
		
		LearningLanguageDao dao = sqlSession.getMapper(LearningLanguageDao.class);
		int count = dao.delete(member_mid);
		
		return count;
	}

	@Override
	public int insertID(String profile_mid, int i) {
		LearningLanguageDao dao = sqlSession.getMapper(LearningLanguageDao.class);
		int count = dao.insertID(profile_mid, i);
		return count;
	}

	@Override
	public List<LearningLanguage> getLlanguagelist(String id) {
		LearningLanguageDao dao = sqlSession.getMapper(LearningLanguageDao.class);
		List<LearningLanguage> lList = dao.getLlanguagelist(id);
		return lList;
	}

	@Override
	public int insert(LearningLanguage l_language) {
		LearningLanguageDao dao = sqlSession.getMapper(LearningLanguageDao.class);
		int count = dao.insert(l_language);
		return count;
	}

}

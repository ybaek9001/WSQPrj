package com.wsq.webprj.dao;

import java.sql.SQLException;
import java.util.List;

import com.wsq.webprj.vo.LearningLanguage;

public interface LearningLanguageDao {
	public List<LearningLanguage> getLlanguagelist(String id);
	public List<LearningLanguage> getL_Languages() throws SQLException;
	public List<LearningLanguage> getL_Languages(int page) throws SQLException;
	public List<LearningLanguage> getL_Languages(int page, String filed, String query) throws SQLException;
	
	public int update(LearningLanguage l_language);
	public int delete(String profile_mid) throws SQLException;
	public int insertID(String profile_mid, int i);
	
	public int insert(LearningLanguage l_language);


	
	
		
	
	
}

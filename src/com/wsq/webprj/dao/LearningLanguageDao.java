package com.wsq.webprj.dao;

import java.sql.SQLException;
import java.util.List;

import com.wsq.webprj.vo.LearningLanguage;

public interface LearningLanguageDao {

	public List<LearningLanguage> getL_Languages() throws SQLException;
	public List<LearningLanguage> getL_Languages(int page) throws SQLException;
	public List<LearningLanguage> getL_Languages(int page, String filed, String query) throws SQLException;
	
	public int update(LearningLanguage l_language) throws SQLException;
	public int delete(String profile_mid) throws SQLException;
	public int insert(String profile_mid, String learning_num);
	public List<LearningLanguage> getLlanguagelist(String id);
	
		
	
	
}

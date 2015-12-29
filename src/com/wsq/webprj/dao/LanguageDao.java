package com.wsq.webprj.dao;

import java.sql.SQLException;
import java.util.List;

import com.wsq.webprj.vo.Language;

public interface LanguageDao {

	public List<Language> getLanguages() throws SQLException;
	public List<Language> getLanguages(int page) throws SQLException;
	public List<Language> getLanguages(int page, String filed, String query) throws SQLException;
	
	public int update(Language language) throws SQLException;
	public int delete(String mid) throws SQLException;
	public int insert(Language language, int i);
	
}

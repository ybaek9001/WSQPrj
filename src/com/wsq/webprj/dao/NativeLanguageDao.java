package com.wsq.webprj.dao;

import java.sql.SQLException;
import java.util.List;

import com.wsq.webprj.vo.NativeLanguage;

public interface NativeLanguageDao {
	public List<NativeLanguage> getNlanguagelist(String id);
	public List<NativeLanguage> getN_Language() throws SQLException;
	public List<NativeLanguage> getN_Language(int page) throws SQLException;
	public List<NativeLanguage> getN_Language(int page, String filed, String query) throws SQLException;
	
	public int update(NativeLanguage n_language);
	public int delete(String profile_mid) throws SQLException;
	
	public int insert(NativeLanguage n_language);
	public int insertID(String member_mid);
	
	
		
	
	
}

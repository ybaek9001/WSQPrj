package com.wsq.webprj.dao;

import java.sql.SQLException;
import java.util.List;

import com.wsq.webprj.vo.MemberProfile;

public interface MemberProfileDao {

	public List<MemberProfile> getProfiles() throws SQLException;
	public List<MemberProfile> getProfiles(int page) throws SQLException;
	public List<MemberProfile> getProfiles(int page, String filed, String query) throws SQLException;
	
	public int update(MemberProfile mProfile) throws SQLException;
	public int delete(String mid) throws SQLException;
	public int insert(String mid);
	
		
	
	
}

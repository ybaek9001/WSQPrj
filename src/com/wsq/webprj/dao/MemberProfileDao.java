package com.wsq.webprj.dao;

import java.sql.SQLException;
import java.util.List;

import com.wsq.webprj.vo.LearningLanguage;
import com.wsq.webprj.vo.MemberProfile;
import com.wsq.webprj.vo.NativeLanguage;

public interface MemberProfileDao {
	public MemberProfile getProfile(String member_mid);
	public List<MemberProfile> getProfiles() throws SQLException;
	public List<MemberProfile> getProfiles(int page) throws SQLException;
	public List<MemberProfile> getProfiles(int page, String filed, String query) throws SQLException;
	
	public int update(MemberProfile mProfile);
	public int delete(String member_mid) throws SQLException;
	public int insert(String member_mid);	
}

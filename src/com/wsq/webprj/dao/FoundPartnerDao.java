package com.wsq.webprj.dao;


import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.wsq.webprj.vo.FoundPartner;
public interface FoundPartnerDao {
	
	public List<FoundPartner> getPartners(String nationalityCountry, String habitatCountry, String nativeLanguage, String learnLanguage, String mentorLV, String menteeLV) throws SQLException;

	//public List<FoundPartner> getPartners(FoundPartner fp);
	
/*	@Select("SELECT * FROM NOTICES WHERE CODE = #{code}")
	public FoundPartner getPpage(String member_mid);
	*/
	
}

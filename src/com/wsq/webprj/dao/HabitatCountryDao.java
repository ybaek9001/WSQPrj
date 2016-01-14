package com.wsq.webprj.dao;

import java.util.List;

import com.wsq.webprj.vo.HabitatCountry;

public interface HabitatCountryDao {
	public HabitatCountry getHabitatCountry(String member_mid);
	public List<HabitatCountry> getHabitatCountries();
	public int update(HabitatCountry h_country) ;
	public int insert(String member_mid) ;	
}

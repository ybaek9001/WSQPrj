package com.wsq.webprj.dao;

import java.util.List;

import com.wsq.webprj.vo.NationalityCountry;

public interface NationalityCountryDao {
	public NationalityCountry getNationality(String member_mid);
	public List<NationalityCountry> getNationalities();
	public int update(NationalityCountry n_country) ;
	public int insert(String member_mid) ;
}

package com.wsq.webprj.dao;

import java.sql.SQLException;
import java.util.List;

import com.wsq.webprj.vo.Country;

public interface CountryDao {

	public List<Country> getCountries() throws SQLException;
	public List<Country> getCountries(int page) throws SQLException;
	public List<Country> getCountries(int page, String filed, String query) throws SQLException;
	
	public int update(Country country) throws SQLException;
	public int delete(String mid) throws SQLException;
	public int insert(Country country) throws SQLException;
	
		
	
	
}

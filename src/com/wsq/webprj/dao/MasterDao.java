package com.wsq.webprj.dao;

import java.sql.SQLException;
import java.util.List;

import com.wsq.webprj.vo.Master;

public interface MasterDao {

	public List<Master> getMasters() throws SQLException;
	public List<Master> getMasters(int page) throws SQLException;
	public List<Master> getMasters(int page, String filed, String query) throws SQLException;
	
	public int update(Master master) throws SQLException;
	public int delete(String mid) throws SQLException;
	public int insert(Master master) throws SQLException;
	
		
	
	
}

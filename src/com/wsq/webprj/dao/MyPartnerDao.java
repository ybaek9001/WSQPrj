package com.wsq.webprj.dao;

import java.sql.SQLException;
import java.util.List;

import com.wsq.webprj.vo.MyPartner;

public interface MyPartnerDao {

	public List<MyPartner> getFriends() throws SQLException;
	public List<MyPartner> getFriends(int page) throws SQLException;
	public List<MyPartner> getFriends(int page, String filed, String query) throws SQLException;
	
	public int update(MyPartner friend) throws SQLException;
	public int delete(String mid);
	/*public int insert(MyPartner friend) throws SQLException;
	public int insert(String key);*/
	
	public int insert(MyPartner myPartner);
	public List<MyPartner> getWaitingList(String members_mid, String request);
	
	
	
	
	
		
	
	
}

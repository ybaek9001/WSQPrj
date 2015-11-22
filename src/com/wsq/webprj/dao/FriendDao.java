package com.wsq.webprj.dao;

import java.sql.SQLException;
import java.util.List;

import com.wsq.webprj.vo.Friend;

public interface FriendDao {

	public List<Friend> getFriends() throws SQLException;
	public List<Friend> getFriends(int page) throws SQLException;
	public List<Friend> getFriends(int page, String filed, String query) throws SQLException;
	
	public int update(Friend friend) throws SQLException;
	public int delete(String mid) throws SQLException;
	public int insert(Friend friend) throws SQLException;
	
		
	
	
}

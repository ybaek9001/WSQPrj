package com.wsq.webprj.dao;

import java.util.List;

import com.wsq.webprj.vo.Message;

public interface MessageDao {
	public int insert(Message message);
	public List<Message> getMessages(String myID, String friendID);
	public int getMsgCount(String myID, String friendID);
	public int delete(String mid,String fid, String msg);
}

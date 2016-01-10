package com.wsq.webprj.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.wsq.webprj.dao.MemberDao;
import com.wsq.webprj.dao.MessageDao;
import com.wsq.webprj.vo.Member;
import com.wsq.webprj.vo.Message;

public class MyBatisMessageDao implements MessageDao {
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public int insert(Message message) {
		MessageDao dao = sqlSession.getMapper(MessageDao.class);
		int count = dao.insert(message);
		return count;
	}

	@Override
	public List<Message> getMessages(String myID, String friendID) {
		MessageDao dao = sqlSession.getMapper(MessageDao.class);
		List<Message>list = dao.getMessages(myID, friendID);
		
		return list;
	}

}

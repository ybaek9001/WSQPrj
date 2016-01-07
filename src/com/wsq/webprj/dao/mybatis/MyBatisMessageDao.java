package com.wsq.webprj.dao.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.wsq.webprj.dao.MessageDao;
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

}

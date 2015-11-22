package com.wsq.webprj.dao.mybatis;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.wsq.webprj.dao.DebateSquareDao;
import com.wsq.webprj.dao.DebateSquareDao;
import com.wsq.webprj.vo.DebateSquare;

public class MyBatisDebateSquareDao implements DebateSquareDao{
	
	SqlSessionFactory ssf = NewlecSqlSessionFactoryBuilder.getSqlSessionFactory();
	
	@Override
	public List<DebateSquare> getDebateSquares() throws SQLException {
		return getDebateSquares(1, "MID", "");
	}

	@Override
	public List<DebateSquare> getDebateSquares(int page) throws SQLException {
		
		return getDebateSquares(page, "MID", "");
	}

	@Override
	public List<DebateSquare> getDebateSquares(int page, String field, String query) throws SQLException {
		SqlSession session = ssf.openSession();
		DebateSquareDao dao = session.getMapper(DebateSquareDao.class);
		List<DebateSquare>list = dao.getDebateSquares(page,field,query);
		session.close();
		return list;
	}

	@Override
	public int update(DebateSquare ds) throws SQLException {
		SqlSession session = ssf.openSession();
		DebateSquareDao dao = session.getMapper(DebateSquareDao.class);
		int count = dao.update(ds);
		session.commit();
		session.close();
		return count;
	}

	@Override
	public int delete(String mid) throws SQLException {
		SqlSession session = ssf.openSession();
		DebateSquareDao dao = session.getMapper(DebateSquareDao.class);
		int count = dao.delete(mid);
		session.commit();
		session.close();
		return count;
	}

	@Override
	public int insert(DebateSquare ds) throws SQLException  {
		SqlSession session = ssf.openSession();
		DebateSquareDao dao = session.getMapper(DebateSquareDao.class);
		int count = dao.insert(ds);
		session.commit();
		session.close();
		return count;
	}

}

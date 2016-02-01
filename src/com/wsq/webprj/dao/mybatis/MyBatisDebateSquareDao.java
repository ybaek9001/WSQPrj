package com.wsq.webprj.dao.mybatis;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.wsq.webprj.dao.CommentDao;
import com.wsq.webprj.dao.DebateSquareDao;
import com.wsq.webprj.dao.DebateSquareDao;
import com.wsq.webprj.vo.DebateSquare;

public class MyBatisDebateSquareDao implements DebateSquareDao{
	
	//SqlSessionFactory ssf = NewlecSqlSessionFactoryBuilder.getSqlSessionFactory();
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<DebateSquare> getDebateSquares() throws SQLException {
		return getDebateSquares(1, "master_id", "");
	}

	@Override
	public List<DebateSquare> getDebateSquares(int page) throws SQLException {
		
		return getDebateSquares(page, "master_id", "");
	}

	@Override
	public List<DebateSquare> getDebateSquares(int page, String field, String query) throws SQLException {
		
		DebateSquareDao dao = sqlSession.getMapper(DebateSquareDao.class);
		List<DebateSquare>list = dao.getDebateSquares(page,field,query);
		
		return list;
	}

	@Override
	public int update(DebateSquare ds) throws SQLException {
		
		DebateSquareDao dao = sqlSession.getMapper(DebateSquareDao.class);
		int count = dao.update(ds);
		
		return count;
	}

	@Override
	public int delete(String mid) throws SQLException {
		
		DebateSquareDao dao = sqlSession.getMapper(DebateSquareDao.class);
		int count = dao.delete(mid);
		
		return count;
	}
	
	@Override
	public int insert(DebateSquare ds) throws SQLException  {
		
		DebateSquareDao dao = sqlSession.getMapper(DebateSquareDao.class);
		int count = dao.insert(ds);
	
		return count;
	}

	@Override
	public DebateSquare getDebate(String code) {
		
		DebateSquareDao dao = sqlSession.getMapper(DebateSquareDao.class); // mapper按眉 积己
		DebateSquare notice = dao.getDebate(code);

		//sqlSession.close(); // 技记 辆丰.

		return notice;
	}

	@Override
	public DebateSquare getDebateFirst() {
		
		DebateSquareDao dao = sqlSession.getMapper(DebateSquareDao.class); // mapper按眉 积己
		DebateSquare notice = dao.getDebateFirst();

		//sqlSession.close(); // 技记 辆丰.

		return notice;
	}

	@Override
	public int updateComment(int commentCnt, String code, int type) {
		
		DebateSquareDao dao = sqlSession.getMapper(DebateSquareDao.class);
		int count = dao.updateComment(commentCnt, code, type);
		
		return count;
	}

	@Override
	public int updateAgree(int agreeCnt, String code, int type) {
		
		DebateSquareDao dao = sqlSession.getMapper(DebateSquareDao.class);
		int count = dao.updateAgree(agreeCnt, code, type);
		
		return count;
	}

	@Override
	public int updateDisagree(int disagreeCnt, String code, int type) {
		
		DebateSquareDao dao = sqlSession.getMapper(DebateSquareDao.class);
		int count = dao.updateDisagree(disagreeCnt, code, type);
		
		return count;
	}

	@Override
	public int updateHit(int hit, String code) {
		DebateSquareDao dao = sqlSession.getMapper(DebateSquareDao.class);
		int count = dao.updateHit(hit, code);
		
		return count;
	}

}

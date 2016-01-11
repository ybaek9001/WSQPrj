package com.wsq.webprj.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.wsq.webprj.dao.MemberDao;
import com.wsq.webprj.vo.Member;

public class MyBatisMemberDao implements MemberDao{
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public List<Member> getMembers(){
		return getMembers(1, "MID", "");
	}

	@Override
	public List<Member> getMembers(int page) {
		
		return getMembers(page, "MID", "");
	}

	@Override
	public List<Member> getMembers(int page, String field, String query)  {
		
		MemberDao dao = sqlSession.getMapper(MemberDao.class);
		List<Member>list = dao.getMembers(page,field,query);
		
		return list;
	}

	@Override
	public int update(Member member)  {
		
		MemberDao dao = sqlSession.getMapper(MemberDao.class);
		int count = dao.update(member);
		
		return count;
	}

	@Override
	public int delete(String mid){
		
		MemberDao dao = sqlSession.getMapper(MemberDao.class);
		int count = dao.delete(mid);
		
		return count;
	}

	@Override
	public int insert(Member member)  {
		
		MemberDao dao = sqlSession.getMapper(MemberDao.class);
		int count = dao.insert(member);
		
		return count;
	}

	@Override
	public Member getMember(String mid) {
		
		MemberDao dao = sqlSession.getMapper(MemberDao.class);
		Member member = dao.getMember(mid);
		
		return member;
	}

	@Override
	public List<Member> getAllMembers() {
		MemberDao dao = sqlSession.getMapper(MemberDao.class);
		List<Member>list = dao.getAllMembers();
		return list;
	}

	@Override
	public int getMemberCount() {
		MemberDao dao = sqlSession.getMapper(MemberDao.class);
		int count = dao.getMemberCount();
		return count;
	}

}

package com.wsq.webprj.dao;

import java.util.List;

import com.wsq.webprj.vo.Member;

public interface MemberDao {
	public Member getMember(String mid);
	public List<Member> getAllMembers();
	public List<Member> getMembers();
	public List<Member> getMembers(int page);
	public List<Member> getMembers(int page, String field, String query);
	
	public int update(Member member) ;
	public int delete(String mid);
	public int insert(Member member) ;
	
		
	
	
}

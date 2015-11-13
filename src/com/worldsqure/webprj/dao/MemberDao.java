package com.worldsqure.webprj.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.worldsqure.webprj.vo.Member;



public class MemberDao {
	public List<Member> getMembers() throws SQLException{
		return getMembers(1, "MID", "");
	}
	public List<Member> getMembers(int page) throws SQLException{
		return getMembers(page, "MID", "");
	}
	
	public List<Member> getMembers(int page, String field, String query) throws SQLException{
		
		int start = 1+(page-1)*10; // 1, 11, 21, 31, 41, .. an = a1+(n-1)d->1+(page-1)*10
		int end = page*10; // 10,20,30,40,...
		
		/*String sql = "SELECT * FROM (" 
				+ "SELECT ROW_NUMBER() OVER (ORDER BY REGDATE DESC) NUM, MEMBERS.* FROM MEMBERS) A "
				+ "WHERE NUM BETWEEN "+start+" AND "+end;*/
	/*	String sql = "SELECT * FROM (" 
				+ "SELECT ROW_NUMBER() OVER (ORDER BY REGDATE DESC) NUM, MEMBERS.* FROM MEMBERS WHERE "+ field + " LIKE ? ) A "
				+ " WHERE NUM BETWEEN ? AND ?";*/
		
		String sql ="SELECT * FROM ("
	               + "SELECT ROW_NUMBER() OVER(ORDER BY REGDATE DESC) NUM,MEMBERS.* FROM MEMBERS WHERE "+field+" LIKE ? )A "
	               + "WHERE NUM BETWEEN ? AND ?"; 
		
		 
		 
		//String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
		String url = "jdbc:sqlserver://211.238.142.251:1433;databaseName=wsqdb;";
		Connection con = DriverManager.getConnection(url, "wsquser", "mansoo");
		
		/*Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);*/
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%" + query + "%");
		st.setInt(2, start);
		st.setInt(3, end);
		
		ResultSet rs = st.executeQuery();
		
		List<Member> list = new ArrayList<Member>();
		Member member = null;
		
		while(rs.next())	{
			member = new Member();
			
			member.setMid(rs.getString("mid"));
			member.setName(rs.getString("name"));
			member.setPwd(rs.getString("pwd"));
			member.setRegDate(rs.getDate("regDate"));
			
			list.add(member);
		}		
								
		rs.close();
		st.close();
		con.close();
		
		return list;
	}
}

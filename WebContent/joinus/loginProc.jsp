<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="java.util.List"%>
<%@page import="com.wsq.webprj.vo.Member"%>
<%@page import="com.wsq.webprj.dao.mybatis.MyBatisMemberDao"%>
<%@page import="com.wsq.webprj.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String uid = request.getParameter("uid");
	String pwd = request.getParameter("pwd");
	MemberDao memberDao = new MyBatisMemberDao();
	
	List<Member> list = memberDao.getMembers(1);
	for(Member m : list)
	{
		if(m.getMid().equals(uid))
		{
			if(m.getPwd().equals(pwd))
				response.sendRedirect("../customer/main.html");
		}
	}
	response.sendRedirect("../customer/main.html");
%>
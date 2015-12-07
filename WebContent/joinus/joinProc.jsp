<%@page import="java.sql.Date"%>


<%@page import="java.util.Calendar"%>

<%@page import="com.wsq.webprj.vo.Member"%>
<%@page import="com.wsq.webprj.dao.mybatis.MyBatisMemberDao"%>
<%@page import="com.wsq.webprj.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String uid = request.getParameter("uid");
	String pwd = request.getParameter("pwd");
	String email = request.getParameter("email");
	MemberDao memberDao = new MyBatisMemberDao();
	
	Member m = new Member();
	m.setMid(uid);
	m.setPwd(pwd);
	m.setEmail(email); 
	
	
	Date d = new Date(System.currentTimeMillis());
	String date = d.toString();
	m.setRegDate(date);
	
	int result = memberDao.insert(m);
	if(result==1){
		   response.sendRedirect("../customer/main.html");
	}
	
%>
result = <%=result%>
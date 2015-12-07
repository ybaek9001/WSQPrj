<%@page import="java.sql.Date"%>
<%@page import="com.wsq.webprj.vo.Member"%>
<%@page import="com.wsq.webprj.dao.mybatis.MyBatisMemberDao"%>
<%@page import="com.wsq.webprj.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String id = request.getParameter("id");
	String passward = request.getParameter("passward");
	String email = request.getParameter("email");
	MemberDao memberDao = new MyBatisMemberDao();
	Member m = new Member();
	m.setMid(id);
	m.setPwd(passward);
	m.setEmail(email);
	
	int result = memberDao.insert(m);
	if(result==1){
		   response.sendRedirect("main.jsp");
	}
	
%>
result = <%=result%>
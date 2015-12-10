<%@page import="com.wsq.webprj.vo.MemberProfile"%>
<%@page import="com.wsq.webprj.dao.mybatis.MyBatisMemberProfileDao"%>
<%@page import="com.wsq.webprj.dao.MemberProfileDao"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

ServletContext ctx = request.getServletContext();
String path = ctx.getRealPath("/customer/upload");

MultipartRequest req = new MultipartRequest(
		   request
		   , path
		   , 1024*1024*10
		   , "UTF-8"
		   , new DefaultFileRenamePolicy() );


String id = req.getParameter("id");
String name = req.getParameter("name");
String email = req.getParameter("email");
String gender = req.getParameter("gender");
String s_language = req.getParameter("s_language");
String sl_lv = req.getParameter("sl_LV");
String ll_lv = req.getParameter("ll_LV");
String selfintro = req.getParameter("comment");

MemberProfileDao memberProfileDao = new MyBatisMemberProfileDao();
MemberProfile mf = new MemberProfile();
mf.setMember_mid(id);
mf.setName(name);
mf.setGender(gender);






%>
  
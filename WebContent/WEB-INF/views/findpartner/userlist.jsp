<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


		<main class="main">
		<h2>User List</h2>
		<table class="mtable">
		
			<tr>
				<th>MID</th>
				<th>PWD</th>
				<th>EMAIL</th>
				<th>REGDATE</th>
			</tr>
		<c:forEach var="n" items="${list}">
			<tr>
				<td>${n.mid}</td>
				<td>${n.pwd}</td>
				<td>${n.email}</td>
				<td><fmt:formatDate pattern="yyy-MM-dd" value="${n.regDate}" /></td>
			</tr>
		</c:forEach>
			
		
		</table>
		</main>
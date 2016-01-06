<%@page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<main class="main">
<h2>User List</h2>
	<table class="mtable">
		<tr>
			<th>MID</th>
			<th>EMAIL</th>
			<th>REGDATE</th>
		</tr>
		<c:forEach var="p" items="${list}">
			<tr>
				<td class="mid">${p.member_mid}</td>
				<td class="email">${p.email}</td>
				<%-- <td>${p.regdate}</td> --%>
			</tr>
		</c:forEach>
	</table>

<h2>page List</h2>
<%-- 	<ul class="page">
		<c:if test="${pg==1 && isNext!=false}">
		<li><a href="userlist?pg=${pg+1}">다음 페이지</a></li>
		</c:if>
		<c:if test="${pg!=1 && isNext==false}">
		<li><a href="userlist?pg=${pg-1}">이전 페이지</a></li>
		</c:if>
		<c:if test="${pg!=1 && isNext!=false}">
		<li><a href="userlist?pg=${pg-1}">이전 페이지</a></li>
		<li><a href="userlist?pg=${pg+1}">다음 페이지</a></li>
		</c:if>	
	</ul> --%>
</main>
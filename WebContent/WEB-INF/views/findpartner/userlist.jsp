<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
							<td><a href="userDel?c=${n.mid}">${n.mid}</a></td>
							<td>${n.pwd}</td>
							<td>${n.email}</td>
							<td><fmt:formatDate pattern="yyy-MM-dd" value="${n.regDate}" /></td>
						</tr>
					</c:forEach>
				</table>
				<ul class="page">
					<c:if test="${pg==1}">
					<li><a href="userlist?pg=${pg+1}">다음 페이지</a></li>
					</c:if>
					<c:if test="${isNext==false}">
					<li><a href="userlist?pg=${pg-1}">이전 페이지</a></li>
					</c:if>
					<c:if test="${pg!=1 && isNext!=false}">
					<li><a href="userlist?pg=${pg-1}">이전 페이지</a></li>
					<li><a href="userlist?pg=${pg+1}">다음 페이지</a></li>
					</c:if>	
				</ul>
				</main>
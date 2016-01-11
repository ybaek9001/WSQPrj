<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>


				<main class="main">
				<h2>User List</h2>
				<table class="mtable">
					<tr>
						<th>MID</th>
						<th>PWD</th>
						<th>EMAIL</th>
						<th>REGDATE</th>
						<th></th>
					</tr>
					<c:forEach var="m" items="${list}">
						<tr>
							<td><a href="../mypage/mypage?id=${m.mid}">${m.mid}</a></td>
							<td>${m.pwd}</td>
							<td>${m.email}</td>
							<td><fmt:formatDate pattern="yyyy-MM-dd" value="${m.regDate}" /></td>
							<td><a href="userDel?id=${m.mid}">Remove</a></td>
						</tr>
					</c:forEach>
				</table>
				
				<%-- <ul class="page">
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
				
				<div id="pager-wrapper" class="margin-small">
     			 <my:pager></my:pager>
  				</div>
				</main>
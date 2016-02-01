<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

		<main class="main">
		<h2>Topic List</h2>
		<table class="mtable">
		<thead>
			<tr>
				<th>Code</th>				
				<th>Title </th>				
				<th>regDate</th>
				
				<th>Agree</th>
				<th>Disagree</th>
				<th>Reply</th>
				<th>Hit</th>				
			</tr>
		</thead>
		<c:forEach var="n" items="${list}">
			<tr>
				<td>${n.code}</td>				
				<td><a href="debate?c=${n.code}">${n.title}</a></font></td>				
				<td><fmt:formatDate pattern="yyyy-MM-dd" value="${n.regDate}" /></td>
				
				<td>
				<c:if test="${n.agreeCnt != 0 }"><font color="blue">${n.agreeCnt}</font></c:if>
				<c:if test="${n.agreeCnt == 0 }">${n.agreeCnt}</c:if>
				</td>
				<td>
				<c:if test="${n.disagreeCnt != 0 }"><font color="red">${n.disagreeCnt}</font></c:if>
				<c:if test="${n.disagreeCnt == 0 }">${n.disagreeCnt}</c:if>
				</td>				
				<td><font color="#000">${n.commentCnt}</font></td>
				<td>${n.hit}</td>
				
			</tr>
		</c:forEach>
		</table>
		
		<input type="button" value="글쓰기" id="write-debate"/>
		
		
		
			
		
		</main>
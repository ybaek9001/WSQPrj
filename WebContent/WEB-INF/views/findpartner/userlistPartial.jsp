<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

	
					<c:forEach var="m" items="${list}">
						<tr>
							<td><a href="../mypage/mypage?id=${m.mid}" style="font-weight:bold">${m.mid}</a></td>
							<td>${m.pwd}</td>
							<td>${m.email}</td>
							<td><fmt:formatDate pattern="yyyy-MM-dd" value="${m.regDate}" /></td>
							<td><a href="userDel?id=${m.mid}">Remove</a></td>
						</tr>
					</c:forEach>
			
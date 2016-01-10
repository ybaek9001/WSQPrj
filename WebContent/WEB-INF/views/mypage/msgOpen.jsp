<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<style>
p{
padding: 20px;
font-weight: bold;
}

span{
font-size:25px;
color:#f87e10;
}

table{
border: 1px solid black; 
width:600px;
}

td{
padding:10px;
}

#thead{
	border-bottom:1px dotted black;
}

#thead th{padding-left:50px;}


</style>
 <div style="font-size:20px; padding:60px;">
		<div>
			<P>Messages From <span>${msglist[0].sending_members_mid}</span></P>
		</div>
		<table>
					<tr id="thead">
						<th>Comment</th>
						<th>Date</th>
					</tr>
					<c:forEach var="msg" items="${msglist}">
						<tr>
							<td>${msg.comment}</td>
							<td><fmt:formatDate pattern="yyyy-MM-dd" value="${msg.date}"/></td>
						</tr>
					</c:forEach>
		</table>
		
		
		
		<p>
			<input class="btn-close" type="button" value="닫기" /> 
		</p>
</div>
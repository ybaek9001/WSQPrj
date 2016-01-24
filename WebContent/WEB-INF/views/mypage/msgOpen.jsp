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

#t{
margin-left: 40px; 
border: 1px solid black; 
width:660px;
}

td{
padding:10px;
overflow:auto;
word-break:break-all; 
max-width: 400px;

}

#msgbox{
overflow: auto;
display: block;
max-height: 400px;
}

#thead{
	border-bottom:1px dotted black;
}

#thead th{
padding:5px;
font-weight:bold;
padding-left:50px;
}

.btn-close{
margin-left:600px;
}
</style>

<!-- <script>
window.onload = function() {
	alert("fdasfd");
var del = document.querySelector(".del");
for(var i=0; i<del.length; i++)
	{
		del[i].onclick = function(event){
			alert("fdasfd");
		}
	}
}
</script> -->

 <div style="font-size:20px; padding:20px;">
		<c:if test="${isEmpty==0}">
					<p>No Message Received</p>
		</c:if>
		
		<c:if test="${isEmpty!=0}">	
			<div>
				<P>Messages From <span id="mid">${msglist[0].sending_members_mid}</span></P>
			</div>
			<table id="t">
			<tbody id="msgbox">
				<tr id="thead">
					<th>Comment</th>
					<th>Date</th>
					<th></th>
				</tr>
				
				<c:forEach var="msg" items="${msglist}">
					<tr>
						<td>${msg.comment}</td>
						<td><fmt:formatDate pattern="yyyy-MM-dd" value="${msg.date}" /></td>
						<td><input class="del" type="button" value="x" /></td>
					</tr>
				</c:forEach>
				</tbody>
		</table>
		</c:if>
		
		<p>
			<a href=""><input class="btn-close" type="button" value="확인" /></a>
		</p>
</div>
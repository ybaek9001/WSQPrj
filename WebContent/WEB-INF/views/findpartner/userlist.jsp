<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<!-- <script src="../content/findpartner/js/refactoring.js"></script> -->
<script>
window.onload=function(){
	//슬라이드 애니매이션 예제를 위한 초기화 코드
	var table = document.querySelector("#userlist");
	table.style.height = table.clientHeight+"px";
	
	var tbody = table.querySelector("tbody");
	tbody.style.height = tbody.clientHeight+"px";

	

	//--------------AJAX GET METHOD-----------------------//
	var numClick = function(event) {
		
		/*---------------번호 선택 스타일 변경------------- */
		var ul = event.target.parentNode.parentNode;
		var as = ul.querySelectorAll("a");
		for (var i = 0; i < as.length; i++)
			as[i].className = "";
		
		event.target.className = "strong";
		/*---------------선택된 번호의 게시글 변경------------- */
		var page = event.target.innerText;
		var request;

		if (window.ActiveXObject)
			request = new ActiveXObject("Microsoft.XMLHTTP");
		else if (window.XMLHttpRequest)
			request = new XMLHttpRequest();

		//비동기식으로 데이터 요청할 경우, 빈데이터가 오는걸 방지하기 위한 로직;데이터가 온 다음에 로직이 처리되도록 하기 위함
		request.onreadystatechange = function() {
			if (request.readyState == 4) // operation is complete
			{
				var tbody = document.querySelector("#userlist tbody");
				tbody.innerHTML = request.responseText;
			}
		};
		
		request.open("GET", "userlistPartial?pg=" + page, true); 
		page++;
		request.send(null);

		return false; 
	}
	
	var nums = document.querySelectorAll("#pager-wrapper ul a");
	for (var i = 0; i < nums.length; i++) {
		nums[i].onclick = numClick;
	} 
}
</script>

				<main class="main">
				<h2>User List</h2>
				<table id="userlist" class="mtable">
				<thead>
					<tr>
						<th>MID</th>
						<th>PWD</th>
						<th>EMAIL</th>
						<th>REGDATE</th>
						<th>Remove</th>
					</tr>
				<thead>
				<tbody>
					<c:forEach var="m" items="${list}">
						<tr>
							<td><a href="../mypage/mypage?id=${m.mid}" style="font-weight:bold">${m.mid}</a></td>
							<td>${m.pwd}</td>
							<td>${m.email}</td>
							<td><fmt:formatDate pattern="yyyy-MM-dd" value="${m.regDate}" /></td>
							<td><a href="userDel?id=${m.mid}">Remove</a></td>
						</tr>
					</c:forEach>
				</tbody>
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
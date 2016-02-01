<%@page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script type="text/javascript" src="../jquery-latest.js"></script>
<script type="text/javascript" src="../jquery-tablesorter/jquery.tablesorter.min.js"></script>
<link rel="stylesheet" href="../jquery-tablesorter/themes/blue/style.css" type="text/css">
<link rel="stylesheet" href="../jquery-tablesorter/themes/green/style.css" type="text/css">

<script type="text/javascript" src="/path/to/jquery-latest.js"></script> 
<script type="text/javascript" src="/path/to/jquery.tablesorter.js"></script> 
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.3.15/angular.min.js"></script>



<script>
	
</script>

<main class="main" ng-app="myApp">
<h2>U s e r L i s t</h2>
	<table class="mtable">
		<thead>
			<tr>
				<th>Name</th>
				<th>E-Mail</th>
				<th>Country</th>
				<th>Habitation</th>
				<th>Native Language</th>
				<th>Learning Language</th>
				<!-- <th>거주국 시간</th> -->
				<!-- <th>라스트 로긴</th> -->
			</tr>
		</thead>
		<tbody ng-controller="myCtrl">
			<c:forEach var="p" items="${list}">
				<tr>
					<td id="name"><a href="../mypage/mypage?id="${p.member_mid}">${p.member_mid}</a></td>
					<td class="email">${p.email}</td>
					<td class="NC">
						<img src="../content/images/${p.nationality_country}.jpg" style="width:20px; height:20px;"/>
					</td>
					
					<td class="HC">
						<img src="../content/images/${p.habitat_country}.jpg" style="width:20px; height:20px;"/>
					</td>
					
					<td>
						${p.native_language}
					     <img src="../content/images/${p.mentee_level}.jpg" style="width:50px; height:10px;"/>
					</td>
					
					<td>
						${p.learning_language}
						<img src="../content/images/${p.mentor_level}.jpg" style="width:50px; height:10px;"/>
					</td>
					<%-- <td>${p.regdate}</td> --%>
				</tr>
			</c:forEach>
		</tbody>
	</table>

<!-- <h2>page List</h2> -->
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
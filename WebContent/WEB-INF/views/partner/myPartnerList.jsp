<%@page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<main class="main">

<h2>Partner List</h2>
	<table id="partner" class="mtable">
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
		<tbody>
			<c:forEach var="p" items="${list}">
				<tr>
					<td><a href="../mypage/mypage?id=${p.mypartners_mid}">${p.mypartners_mid}</a></td>
					
					<td>${p.email}</td>
					
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
					<%-- <td><fmt:formatDate pattern="yyyy-MM-dd" value="${p.regdate}" /></td> --%>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</main>
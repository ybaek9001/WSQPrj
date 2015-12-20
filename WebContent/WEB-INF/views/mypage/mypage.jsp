<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<main class="main">

<h2>${mProfile.member_mid}님의 MyPage</h2>
<div id="mypage">
	
		<ul>				
			<li>Name: ${mProfile.name} </li>
		
			<li>Email Address: ${mProfile.email}</li>
			
			<li>Age: ${mProfile.age} </li>
				
			<li>Gender: ${mProfile.gender} </li>
			
			<li>Nationality: ${mProfile.country}</li>

			<li>RegDate: <fmt:formatDate pattern="yyyy-MM-dd" value="${mProfile.regDate}" /></li>
			
			<li id="cmt">Introduce Yourself</br><textarea name="comment" rows="5" cols="70">${mProfile.comment}</textarea></li>
		
		</ul>
		<P>
			<a id="button" href="mypageRev?id=${mProfile.member_mid}">MyPage 수정</a>
		</P>
		
</div>
</main>
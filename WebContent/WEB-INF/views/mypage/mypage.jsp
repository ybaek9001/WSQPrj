<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<main class="main">

<h2>${member.mid}님의 MyPage</h2>
<div id="mypage">
	
		<ul>				
			<li>Name: ${mProfile.name} </li>
		
			<li>Email Address: ${member.email}</li>
			
			<li>Age: ${mProfile.age} </li>
				
			<li>Gender: ${mProfile.gender} </li>
			
			<li>Nationality Code: ${mProfile.nationality_country_code}</li>
			
			<li>Habitat Code: ${mProfile.habitat_country_code}</li>

			<li>RegDate: <fmt:formatDate pattern="yyyy-MM-dd" value="${member.regDate}" /></li>
			
			<li id="cmt">Introduce Yourself</br><textarea name="comment" rows="5" cols="70">${mProfile.comment}</textarea></li>
		
		</ul>
		<P>
			<a id="button" href="mypageRev?c=${member.mid}">MyPage 수정</a>
		</P>
		
</div>
</main>
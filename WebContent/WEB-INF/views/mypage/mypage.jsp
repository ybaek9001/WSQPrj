<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="e" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<main class="main">

<h2>${mProfile.member_mid}'sMyPage</h2>
<div id="mypage">

	<ul>
		<li>Name: ${mProfile.name}</li>

		<li>Email Address: ${mProfile.email}</li>

		<li>Age: ${mProfile.age}</li>

		<li>Gender: ${mProfile.gender}</li>

		<li>Nationality: ${mProfile.country}</li>

		<li>RegDate: <fmt:formatDate pattern="yyyy-MM-dd"
				value="${mProfile.regDate}" /></li>
	</ul>

	<div class="language">
		<table>
			<tr>
				<td>#</td>
				<td>Native Language</td>
				<td>Mentor Level</td>
			</tr>
			<c:forEach var="nlist" items="${nlist}">
				<tr>
					<td>${nlist.native_num}</td>
					<td>${nlist.native_language}</td>
					<td>${nlist.mentor_level}</td>
				</tr>
			</c:forEach>
		</table>
	</div>

	<div class="language">
		<table>
			<tr>
				<td>#</td>
				<td>Learning Language</td>
				<td>Mentee Level</td>
			</tr>
			<d:forEach var="llist" items="${llist}">
				<tr>
					<td>${llist.language_num}</td>
					<td>${llist.learning_language}</td>
					<td>${llist.mentee_level}</td>
				</tr>
			</d:forEach>
		</table>
		<br />

	</div>
	
	<div class="language">
	<table>
		<tr>
			<td>내가 친구 요청한 List</td>
		</tr>
		<e:forEach var="mplist" items="${mplist}">
			<tr>
				<td>${mplist.mypartners_mid}</td>
			</tr>
		</e:forEach>
	</table>
	</div>

	<p id="cmt">
		Introduce Yourself<br /> <span>${mProfile.comment}</span>
	</p>
	<P>
		<a id="button" href="mypageRev?id=${mProfile.member_mid}">MyPage
			수정</a>
	</P>

	<form action="friendManager" method="post">
		<input type="text" name="friendID" value="${mProfile.member_mid}"
			; style="display: none;" /> <input type="submit" value="친구 신청" />
	</form>


</div>
</main>
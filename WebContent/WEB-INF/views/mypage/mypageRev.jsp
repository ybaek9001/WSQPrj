<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<main class="main">

<h2>${member.mid}님의 MyPage</h2>
<div id="mypageRev">
	<form action="mypageRev" method="post">
		<ul>
					
			<li>RegDate: <fmt:formatDate pattern="yyyy-MM-dd" value="${member.regDate}" /></li>
			
			<li>Email Address: ${member.email}</li>
			
			<li>Name: <input type="text" name="name" autofocus> </li>
			
			<!-- <li><label class="userPicture">Picture:</label> 
			<input type="file" name="picture"></li> -->
			
			<li>Age: <input type="text" name="age"></li>
				
			<li>Gender: <input type="radio" name="gender" value="male">Male,
				<input type="radio" name="gender" value="female">Female</li>
						
			<li>Nationality: <select name="nationality_country_code">
					<option value="1">Korean</option>
					<option value="2">English</option>
					<option value="3">Japanese</option>
					<option value="4">Chinese</option>
			</select></li>

			<!-- <li>Level: 
			<input type="checkbox" name="levelMentor" value="Beginner">Beginner, 
			<input type="checkbox" name="levelMentor" value="Intermediate">Intermediate, 
			<input type="checkbox" name="levelMentor" value="Advanced">Advanced
			</li>

			<li class="language">Learning Language: <select>
					<option>Korean</option>
					<option>English</option>
					<option>Japanese</option>
					<option>Chinese</option>
			</select></li>

			<li>Level: <input type="checkbox" name="LL_LV" value="Beginner">Beginner, 
			<input type="checkbox" name="levelMentee" value="Intermediate">Intermediate, 
			<input type="checkbox" name="levelMentee" value="Advanced">Advanced
			</li>

			<br /> -->

			<li id="cmt">Introduce Yourself <br /> <textarea placeholer="간단하게 입력하세요" name="comment" rows="5" cols="50"></textarea></li>
		</ul>
		<P>
			<input type="submit" value="MyPage 등록">
		</P>
		
	</form>
</div>
</main>
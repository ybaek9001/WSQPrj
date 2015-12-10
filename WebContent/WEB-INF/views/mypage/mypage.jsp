<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<main class="main">

<h2>MyPage</h2>
<div>
	<form id="mypage" action="mypageRegProc.jsp" method="post" enctype="multipart/form-data">
		<ul>
			<li><label class="userID"> I D:</label> 
			<input type="text" name="id" autofocus></li>
			
			<li><label class="userName">Name:</label> 
			<input	type="text" name="name"></li>
			
			<li><label class="userEMAIL">Email:</label> 
			<input type="email" name="email"></li>
			
			<li><label class="userPicture">Picture:</label> 
			<input type="file" name="picture"></li>
			
			<li>Gender: <input type="radio" name="gender" value="male">Male,
				<input type="radio" name="gender" value="female">Female
			</li>

			<li class="language">Speaking Language: <select name="s_language">
					<option>Korean</option>
					<option>English</option>
					<option>Japanese</option>
					<option>Chinese</option>
			</select></li>

			<li>Level: 
			<input type="checkbox" name="sl_LV" value="Beginner">Beginner, 
			<input type="checkbox" name="sl_LV" value="Intermediate">Intermediate, 
			<input type="checkbox" name="sl_LV" value="Advanced">Advanced
			</li>

			<li class="language">Learning Language: <select>
					<option>Korean</option>
					<option>English</option>
					<option>Japanese</option>
					<option>Chinese</option>
			</select></li>

			<li>Level: <input type="checkbox" name="LL_LV" value="Beginner">Beginner, 
			<input type="checkbox" name="ll_LV" value="Intermediate">Intermediate, 
			<input type="checkbox" name="ll_LV" value="Advanced">Advanced
			</li>

			<br />

			<li>자기소개 <br /> <textarea name="comment" rows="5" cols="50">간단하게 입력하세요.</textarea></li>
		</ul>
		<P>
			<input type="submit" value="MyPage 등록">
		</P>
	</form>
</div>
</main>
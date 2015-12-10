<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	<main class="main">
	
	<h2>MyPage</h2>
	<div>
		<form id="mypage">
			<ul>
				<li><label class="userID" for="userID"> I D:</label> <input
					type="text" id="ID" autofocus></li>
				<li><label class="userName" for="userName">Name:</label> <input
					type="text" id="PW"></li>
				<li><label class="userEMAIL" for="userEMAIL">Email:</label> <input
					type="email" name="email"></li>
				<li><label class="userPicture" for="userPic">Picture:</label> <input
					type="file" name="picture"></li>
	
				<li>Gender: <input type="radio" name="gender" value="male">Male,
					<input type="radio" name="gender" value="female">Female
				</li>
	
				<li class="language">Speaking Language: <select>
						<option>Korean</option>
						<option>English</option>
						<option>Japanese</option>
						<option>Chinese</option>
				</select></li>
	
				<li>Level: <input type="checkbox" name="SL_LV"
					value="SL_Beginner">Beginner, <input type="checkbox"
					name="SL_LV" value="SL_Intermediate">Intermediate, <input
					type="checkbox" name="SL_LV" value="SL_Advanced">Advanced
				</li>
	
				<li class="language">Learning Language: <select>
						<option>Korean</option>
						<option>English</option>
						<option>Japanese</option>
						<option>Chinese</option>
				</select></li>
	
				<li>Level: <input type="checkbox" name="LL_LV"
					value="LL_Beginner">Beginner, <input type="checkbox"
					name="LL_LV" value="LL_Intermediate">Intermediate, <input
					type="checkbox" name="LL_LV" value="LL_Advanced">Advanced
				</li>
	
				<br />
	
				<li>자기소개 <br /> <textarea rows="5" cols="50">간단하게 입력하세요.</textarea></li>
			</ul>
			<P>
				<input type="submit" value="MyPage 등록">
			</P>
		</form>
	</div>
	</main>
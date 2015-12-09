<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>MyPage</title>
<link href="/WSQPrj/content/css/reset.css" type="text/css" rel="stylesheet">
<link href="/WSQPrj/content/customer/css/style.css" type="text/css" rel="stylesheet">
</head>
<body>
	<header id="header">
		<div class="content-container">
			<h1 id="logo">
				<a href="../main.html">
					<p class="hidden">World Square</p> <img src="../images/WSQlogo.jpg"
					alt="WSQ" />
				</a>
			</h1>


			<section>
				<h1 class="hidden">헤더</h1>

				<nav id="main-menu">
					<h1 class="hidden">메인메뉴</h1>
					<ul>
						<li><a href="mypage.html">MyPage</a></li>
						<li><a href="userlist.jsp">Find Partner</a></li>
						<li><a href="debate">WSQ Debate</a></li>
						<li><a href="">Notice</a></li>
						<li><a href="">Customer Center</a></li>
					</ul>
				</nav>

				<nav id="join-menu">
					<h1 class="hidden">회원메뉴</h1>
					<ul>
						<li><a href="../joinus/join.jsp">회원가입</a></li>
						<li><a href="../joinus/login.jsp">로그인</a></li>
					</ul>
				</nav>
			</section>
		</div>
	</header>


	<div id="mypage-body">

		<div class="content-container clearfix">

			<main class="main">

			<h2>MyPage</h2>
			<div>
				<form id="mypage">
				<ul>
					<li><label class="userID" for="userID"> I D:</label>
						<input type="text" id="ID" autofocus></li>
					<li><label class="userName" for="userName">Name:</label>
						<input type="text" id="PW"></li>
					<li><label class="userEMAIL" for="userEMAIL">Email:</label>
						<input type="email" name="email"></li>
					<li><label class="userPicture" for="userPic">Picture:</label>
						<input type="file" name="picture"></li>
						
					<li>Gender:
						<input type="radio" name="gender" value="male">Male,
                    	<input type="radio" name="gender" value="female">Female</li>
					
					<li class="language">Speaking Language:  
					<select>
	                 <option>Korean</option>
	                 <option>English</option>
	                 <option>Japanese</option>
	                 <option>Chinese</option>   
               		</select></li>
               		
               		<li>Level:  
                    <input type="checkbox" name="SL_LV" value="SL_Beginner">Beginner, 
                  	<input type="checkbox" name="SL_LV" value="SL_Intermediate">Intermediate, 
                   	<input type="checkbox" name="SL_LV" value="SL_Advanced">Advanced
                   	</li>
               		
               		<li class="language">Learning Language:  
					<select>
	                 <option>Korean</option>
	                 <option>English</option>
	                 <option>Japanese</option>
	                 <option>Chinese</option>   
               		</select></li>
               		
               		<li>Level:  
                    <input type="checkbox" name="LL_LV" value="LL_Beginner">Beginner, 
                  	<input type="checkbox" name="LL_LV" value="LL_Intermediate">Intermediate, 
                   	<input type="checkbox" name="LL_LV" value="LL_Advanced">Advanced
                   	</li>
                   	
					<li>자기소개 
					<textarea rows="5" cols="50">간단하게 입력하세요.</textarea></li>
				</ul>
				<P><input type="submit" value="MyPage 등록"></P>
				</form>
			</div>
			</main>
		</div>
	</div>




	<footer id="footer">
		<div class="content-container">
			<section>
				<h1>사이트정보</h1>
				<section>
					<h1>회사 정보</h1>
					<dl>
						<dt>주소:</dt>
						<dd>SSIT</dd>
						<dt>관리자메일:</dt>
						<dd>admin@mansoo.com</dd>
						<dt>사업자 등록번호:</dt>
						<dd>132-18-46763</dd>
					</dl>
				</section>
				<section>
					<h1>저작권 정보</h1>
					<p>Copyright ⓒ newlecture.com 2012-2014 All Right Reserved.
						Contact admin@newlecture.com for more information</p>
				</section>
			</section>
		</div>
	</footer>

</body>
</html>
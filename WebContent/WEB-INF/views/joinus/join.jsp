<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JOIN</title>
<link href="/WSQPrj/content/joinus/css/loginjoin.css" type="text/css" rel="stylesheet"> 
</head>
<body>
	<header id="header">
	<div class="content-container">
		<h1 id="logo">
			<a href="../main">
				<p class="hidden">World Square</p> <img src="/WSQPrj/content/images/WSQlogo.jpg"
				alt="WSQ" />
			</a>
		</h1>


		<section>
		<h1 class="hidden">헤더</h1>

		<nav id="main-menu">
		<h1 class="hidden">메인메뉴</h1>
		<ul>
			<li><a href="../customer/mypage">MyPage</a></li>
			<li><a href="../customer/userlist">Find Partner</a></li>
			<li><a href="../customer/debate">WSQ Debate</a></li>
			<li><a href="">Notice</a></li>
			<li><a href="">Customer Center</a></li>
		</ul>
		</nav> <nav id="join-menu">
		<h1 class="hidden">회원메뉴</h1>
		<ul>
			<li><a href="join">회원가입</a></li>
			<li><a href="login">로그인</a></li>
		</ul>
		</nav> </section>
	</div>
	</header>


	<div id="loginjoin-body">

		<div class="content-container clearfix">

			<main class="main">

			<h2 class="hidden">회원가입</h2>
			<div>
				<form id="loginjoin" action="joinProc.jsp" method="post">
					<dl>
						<dt class="join-form-title">아이디</dt>
						<dd class="join-form-data">
							<input type="text" name="uid" />
						</dd>
						<dt class="join-form-title">비밀번호</dt>
						<dd class="join-form-data">
							<input type="password" name="pwd" />
						</dd>
						<dt class="join-form-title">이메일</dt>
						<dd class="join-form-data">
							<input type="text" name="email" />
						</dd>
					</dl>
					<P>
						<input type="submit" value="회원가입">
					</P>
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
		</section> <section>
		<h1>저작권 정보</h1>
		<p>Copyright ⓒ newlecture.com 2012-2014 All Right Reserved.
			Contact admin@newlecture.com for more information</p>
		</section> </section>
	</div>
	</footer>

</body>
</html>
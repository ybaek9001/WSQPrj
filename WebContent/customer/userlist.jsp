<%@page import="java.util.List"%>
<%@page import="com.wsq.webprj.dao.mybatis.MyBatisMemberDao"%>
<%@page import="com.wsq.webprj.dao.MemberDao"%>
<%@page import="com.wsq.webprj.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



<%
MemberDao dao = new MyBatisMemberDao();
List<Member> list = dao.getMembers(1);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../css/reset.css" type="text/css" rel="stylesheet">
<link href="../css/style.css" type="text/css" rel="stylesheet">
<link href="../css/userlist_style.css" type="text/css" rel="stylesheet">

<title>MemberList</title>
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
						<li><a href="">Find Partner</a></li>
						<li><a href="debate.html">WSQ Debate</a></li>
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


	<div id="userlist">
		<div class="content-container clearfix">
			<main class="main">
			<h2>User List</h2>
			<table class="memberList">
						<caption class="hidden">
							회원목록
						</caption>
						<thead>
							<tr>
								<th class="id">ID</th>
								<th class="passward">PW</th>
								<th class="email">EMAIL</th>
								<th class="regdate">가입일</th>
							</tr>
						</thead>
						<tbody>			
						<% for(Member m : list) { %>
							<tr>
								<td class="id"><%=m.getMid()%></td>
								<td class="passward"><%=m.getPwd()%></td>
								<td class="email"><%=m.getEmail()%></td>
								<td class="regdate"><%=m.getRegDate()%></td>
							</tr>
						<% } %>
						</tbody>
					</table>
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script src="/WSQPrj/content/js/ui.js" type="text/javascript"></script>
<script>
	window.onload = function() 
	{		
		var sendMsgs = document.querySelectorAll(".send-msg");

		for (var i = 0; i < sendMsgs.length; i++) {
			sendMsgs[i].onclick = function(event) {
				
				var friendID = event.target.nextSibling.innerHTML;
				var dlg = showDialog("msgReg", ".btn-send", function() { //여기 function()은 showDialog함수안에서 사용될 때 실행 됨
					var request = new XMLHttpRequest();
					request.open("POST", "msgReg", true);
					
					//test 성공!!
					/* request.onreadystatechange = function()
					{
						if (request.readyState == 4) 
						{
							var test = request.responseText;
							var data = JSON.parse(test);
							alert(data.name);
							alert(data.language);
						}
					} */
					
					
					//open과 send 사이에 집어넣어야 함
					request.setRequestHeader("Content-type",
							"application/x-www-form-urlencoded");

					var message = dlg.querySelector("textarea").value;
					var data = "msg=" + message + "&friendID=" + friendID; //controller에서는 매개변수명을 msg로 해야 message변수의 값을 사용할 수 있음
					request.send(data);
					closeDialog(dlg);
					alert("Your message was sent successfully!")
				});
				
			}
		}

		//----------------------------메세지 open클릭하면 Ajax Get방식으로 확인하기--------------------------------//

		var openMsgs = document.querySelectorAll(".open-msg");

		for (var i = 0; i < openMsgs.length; i++) {
			openMsgs[i].onclick = function(event) {
				var friendID = event.target.nextSibling.innerHTML;
				var dlg = showDialog("msgOpen?friendID="+friendID, ".btn-close", function() { //여기 function()은 showDialog함수안에서 사용될 때 실행 됨
					closeDialog(dlg);
				});
				
			}
		}

	}
</script>


<main class="main">

<h2>${mProfile.member_mid}'s MyPage</h2>
<div id="mypage">

	<ul>
		<li>Name: ${mProfile.name}</li>

		<li>Email Address: ${mProfile.email}</li>

		<li>Age: ${mProfile.age}</li>

		<li>Gender: ${mProfile.gender}</li>

		<li>Nationality: ${mProfile.nationality_country}</li>
		
		<li>Living Country: ${mProfile.habitat_country}</li>

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
			<c:forEach var="llist" items="${llist}">
				<tr>
					<td>${llist.language_num}</td>
					<td>${llist.learning_language}</td>
					<td>${llist.mentee_level}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	<c:if test="${pageContext.request.userPrincipal.name==mProfile.member_mid}">
	<div class="language">
	<table>
		<tr>
			<td>Partners on Waiting List</td>
		</tr>
		<c:forEach var="send_list" items="${send_list}">
			<tr>
				<td>${send_list.mypartners_mid}</td>
			</tr>
		</c:forEach>
	</table>
	</div>
	
	<div class="language">
	<table>
		<tr>
			<td>List of Invitations</td>
			<td>Accept</td>
		</tr>
		<c:forEach var="receive_list" items="${receive_list}">
		<form action="friendManager" method="post">
			<tr>
				<td>${receive_list.mypartners_mid}</td>
				<td>
					<input type="text" name="friendID" value="${receive_list.mypartners_mid}" style="display: none;" /> 
					<input type="text" name="choice" value="beFriends" style="display: none;" /> 
					<input type="submit" value="O"/>
				</td>
			</tr>
		</form>
		</c:forEach>
	</table>
	</div>
	
	<div class="language">
	<table id="friends">
		<tr>
			<td>Friends List</td>
			<td>Send Message</td>
			<td>Received Message</td>
		</tr>
		<c:forEach var="friends_list" items="${friends_list}" varStatus="status">
			<tr>
				<td class="friend-ID">${friends_list.mypartners_mid}</td>
				<td><input type="button" class="send-msg" value="Send"><span style="display: none;">${friends_list.mypartners_mid}</span></td>
				<td><input type="button" class="open-msg" value="Open(${msgCount[status.index]})"><span style="display: none;">${friends_list.mypartners_mid}</span></td>
			</tr>
		</c:forEach>
	</table>
	</div>
	</c:if>

	<p id="cmt">
		My Comments<br /> <span>${mProfile.comment}</span>
	</p>
	
	<c:if test="${pageContext.request.userPrincipal.name==mProfile.member_mid}">
	<P>
		<a id="button" href="mypageRev?id=${mProfile.member_mid}">MyPage 수정</a>
	</P>
	</c:if> 
	
	<c:if test="${pageContext.request.userPrincipal.name!=mProfile.member_mid}">
	<form action="friendManager" method="post" style="text-align:center;">
		<input type="text" name="friendID" value="${mProfile.member_mid}" style="display: none;" /> 
		<input type="submit" value="친구 신청" />
	</form>
	</c:if>


</div>
</main>
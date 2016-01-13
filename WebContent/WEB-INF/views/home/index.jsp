<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
#btn-conn{
	position:fixed; 
	top:115px; 
	right:60px;
	color:black; 
	font-size:20px;
	font-weight:bold;
	background:yellow;
	padding:5px;
	border:1px solid green;
	text-align:center;
}
</style>

<script src="/WSQPrj/content/js/chat.js" type="text/javascript"></script>
<script>
	window.onload =  function(){
		
	//현재 페이지를 구성하는 객체 또는 변수들 선언
	//var wsocket;
	
	var btnConn=document.querySelector("#btn-conn");
	
	//현재 페이지에서 사용하는 이벤트 처리 함수들
	btnConn.onclick = function(event){
		var dlg = showDialog("/WSQPrj/content/js/chat.html");
	}
	
	
}


</script>



<div id="btn-conn">Click!<br/>For OpenChat</div>

<main class="main">
<h2>전 세계 친구들과 즐거운 대화를 나누고 서로의 언어 멘토가 되어 주세요</h2>
<div>
	<h3>WSQ 주요 기능</h3>
	<dl>

		<a href="findpartner/userlist"> 
		<img src="/WSQPrj/content/images/find.png" alt="find_partner" />
		</a>
		<dt>Find Chat Partner</dt>
		<dd>전 세계 사람들과 언어교환을 할 수 있도록 쉽게 파트너를 찾아주는 기능입니다</dd>


		<a href="wsqdebate/debate"> 
		<img src="/WSQPrj/content/images/debate.png" alt="debate"
			class="img_debate" />
		</a>
		<dt>WSQ Debate</dt>
		<dd>세계 핫이슈나 토론주제를 가지고 자유롭게 찬반 논쟁을 할 수 있는 공간입니다</dd>

	</dl>
</div>
</main>
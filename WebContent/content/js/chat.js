/**
 * 작성일: 2015-12-30
 * 작성자:yb
 */

var showDialog = function(url, guestID){
	//전체 틀을 만들기 위한 설정
	var uid = guestID;

	
	//위에 만들었던 틀 안에 하얀색 영역(글 등록 form이 들어갈 곳) 설정
	var dlg = document.createElement("div");			
	dlg.style.background = "#fff";
	dlg.style.width = "350px";
	dlg.style.height = "500px";
	dlg.style.position = "fixed";
	dlg.style.top = "200px";
	dlg.style.right = "50px";
	dlg.style.opacity = 0.9;
	
	
	document.body.appendChild(dlg);
	
	
	//-------------------XMLHttpRequest 준비---------------------//
	var	request = new XMLHttpRequest();
	
	request.open("GET", url, true); //true:비동기 방식
	request.send(null); 
			
	request.onreadystatechange = function()
	{
		if (request.readyState == 4) 
		{
			//tbody의 안쪽 방을 비우기
			dlg.innerHTML=request.responseText;	//url데이터를 container영역으로 얻어옴(수업 땐 noticeRegPartial글쓰기양식을 얻어옴)		
			
			
			//현재 페이지를 구성하는 객체 또는 변수들 선언
			var wsocket;
			
			var btnConn=document.querySelector("#btn-conn");
			var btnSend=document.querySelector("#chat-input-panel .btn");
			var outputList=document.querySelector("#chat-output ul");
			var inputBox=document.querySelector("#chat-input-panel textarea");
			var chatOutput = document.querySelector("#chat-output")
			var btnClose=document.querySelector("#btn-close");
			//현재 페이지에서 사용하는 서비스 처리 함수들
			function printMessage(userName, msg){
				
				var template = document.querySelector("#chat-template");
				var clone = document.importNode(template.content, true)
				//alert(inputBox);
				//clone 한 틀에 데이터를 심자!!
				var userNameBox = clone.querySelector("li > div > div:first-child");
				var msgBox = clone.querySelector("li > div > div:last-child");
				
				userNameBox.innerText = userName;
				msgBox.innerText = msg;
				//alert(outputList);
				outputList.appendChild(clone);
				chatOutput.scrollTop = chatOutput.scrollHeight;
			}
			
			
			//현재 페이지에서 사용하는 이벤트 처리 함수들
			
			if(wsocket==undefined)
			{
				//wsocket = new WebSocket("ws://211.238.142.248/JSPPrj/content/chatserver")
				wsocket = new WebSocket("ws://211.238.142.115:8080/WSQPrj/content/chatserver")
				wsocket.onopen = sockOpen;
				wsocket.onclose = sockClose;
				wsocket.onmessage = sockMessage;
			}
			
			
			function sockOpen(){
				//alert("접속 되었습니다");
			}
			
			function sockClose(){
				alert("접속이 끊겼습니다");
			}
			
			function sockMessage(event){
				var data = JSON.parse(event.data);
				printMessage(data.uid, data.msg);
			}
			
			btnSend.onclick = function(event){
				var msg = inputBox.value;
				var data = {uid:uid, msg:msg};
				
				data = JSON.stringify(data);
				wsocket.send(data);
				
				inputBox.value="";
			}
			
			
			/*inputBox.onkeyup = function(e){	//onkeydown, onkeypress
				if(e.keyCode == 13){
					var event = document.createEvent("MouseEvent");	//event type, bubbles, cancelable
					event.initEvent("click",true,true)	
					
					btnSend.dispatchEvent(event);
				}
			}*/
			
			//--------------Shift+Enter=개행 / Enter누르면 전송 ----------------//
			inputBox.onkeydown = function(e){
				if(e.keyCode == 13 && e.shiftKey)
				{
					
				}	
				else if(e.keyCode == 13){
					var event = document.createEvent("MouseEvent");	//event type, bubbles, cancelable
					event.initEvent("click",true,true)		
					btnSend.dispatchEvent(event);
					e.preventDefault();
				}
			}
			
			btnClose.onclick = function(){
				document.body.removeChild(dlg);
			}
			
			
			
				
		}
	}
	
	return dlg;
};

/*var closeDialog = function(dlg){
	document.body.removeChild(dlg)	
};*/
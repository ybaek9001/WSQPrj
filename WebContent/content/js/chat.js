/**
 * 작성일: 2015-12-30
 * 작성자:yb
 */

var showDialog = function(url){
	var wsocket;
	
	
	//위에 만들었던 틀 안에 하얀색 영역(글 등록 form이 들어갈 곳) 설정
	var dlg = document.createElement("div");			
	dlg.style.background = "#fff";
	dlg.style.width = "400px";
	dlg.style.height = "500px";
	dlg.style.position = "fixed";
	
	dlg.style.top = "200px";
	dlg.style.right = "65px";
	
	dlg.style.zIndex = 2;
	dlg.style.opacity = 0.9;
	
	if(wsocket==undefined)
	{
		//wsocket = new WebSocket("ws://211.238.142.248/JSPPrj/content/chatserver")
		wsocket = new WebSocket("ws://211.238.142.115:8080/WSQPrj/content/chatserver")
		wsocket.onopen = sockOpen;
		wsocket.onclose = sockClose;
		wsocket.onmessage = sockMessage;
	}
	
	function sockOpen(){
		alert("접속 되었습니다");
	}
	
	function sockClose(){
		alert("접속이 끊겼습니다");
	}
	
	function sockMessage(event){
		alert(event.data);
		printMessage("newlec",event.data);
		
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
	
	
		
	document.body.appendChild(dlg);
	
	//-------------------XMLHttpRequest 준비---------------------//
	var	request = new XMLHttpRequest();
	
	request.open("GET", url, true); //true:비동기 방식
	request.send(null); 
			
	request.onreadystatechange = function()
	{
		if (request.readyState == 4) 
			dlg.innerHTML=request.responseText;	//url데이터를 container영역으로 얻어옴(수업 땐 noticeRegPartial글쓰기양식을 얻어옴)	

		var btnClose = dlg.querySelector("#btn-close");
		var inputBox=document.querySelector("#chat-input-panel textarea");
		var btnSend=dlg.querySelector("#chat-input-panel .btn");
		
		btnClose.onclick = function(){
			document.body.removeChild(dlg);
		}
		
		btnSend.onclick = function(event){
			var userName ="newlec";
			var msg = inputBox.value;
			
			wsocket.send(msg);
			//printMessage(userName,msg);
			//텍스트 입력 상자의 문자열을 지우는 코드
			inputBox.value="";
		}
		
		inputBox.onkeyup = function(e){	//onkeydown, onkeypress
			if(e.keyCode == 13){
				var event = document.createEvent("MouseEvent");	//event type, bubbles, cancelable
				event.initEvent("click",true,true)	
				
				btnSend.dispatchEvent(event);
			}
		}
		
		
		
		
		
		
	}
	return dlg;
};

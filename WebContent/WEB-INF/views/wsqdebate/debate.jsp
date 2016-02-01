<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<script type="text/javascript"
	src="http://code.jquery.com/jquery-2.2.0.min.js"></script>	
<script type="text/javascript">

window.onload = function(){		
	
	$("#debate-image").css({		
		background : "chat.png"
	});	
		
	function dataBind(row, data) {
	      var tds = row.querySelectorAll("td");
	      var keys = [ "code", "id", "context" ];

	      for (var i = 0; i < tds.length; i++) //for-in문
	      { 
	         tds[i].innerHTML = data[keys[i]];
	      }
	}	
	
	var writeModify = document.querySelectorAll("#writeModify");	
	var btnReply = document.querySelectorAll("input[value='답글']");	
	
	//var next = btnReply[0].nextSibling.value; //sibling
	
	for(var i = 0; i < btnReply.length; i++){	
		btnReply[i].onclick = function(event){
			event.preventDefault(); //이벤트 전파를 막음.						
			var statusCount = event.target.className;	
			
			var coCode = event.target.nextSibling.innerHTML;			
			//alert("coCode : "+coCode);
			
			//-- request ------------------------------------------------------------------------
			var request;
		       if (window.ActiveXObject)
		          request = new ActiveXObject("Microsoft.XMLHTTP");
		       else if (window.XMLHttpRequest)
		          request = new XMLHttpRequest();
		       
	       request.onreadystatechange = function() {
	           if (request.readyState == 4) // operation is complete
	           {
	        	  //alert("댓글을 불러옵니다.");
	        	   
	              datas = eval(request.responseText); // 전역변수 설정
	              var template = document.querySelector("#notice-row");	 
				  
	              if(datas == ""){
	            	  var clone =  document.createElement("p");
	            	  clone.innerHTML = "등록된 답글이 없습니다";
	            	  writeModify[statusCount-1].appendChild(clone);
	              }
	              else{
		              for (var i in datas) {	            	  
		                 var clone = document.importNode(template.content, true); // 틀만 복사
		                 dataBind(clone, datas[i]);
		                 writeModify[statusCount-1].appendChild(clone);
		              }	  
	              }
	           }
	        };
	        request.open("GET", "debateJSON?c=" + coCode, true); //false면 동기, true면 비동기식
	        request.send(); // 데이터 요청..		       
	        
		};
	}
};



 var count = 0; 
 	function addForm(thisCode, thisContext, eachCount) {
		
 		eachCount = eachCount - 1;
		
		var writeModify = document.querySelectorAll("#writeModify");			   
	    	    
		var str = '수정 내용 : ' + '<input type="text" name="context" value="'+thisContext+'" /> ' 
		+ ' <input type="submit" value="완료"/>'
		+ ' <input type="button" value="취소" onclick="delForm('+eachCount+')"/>';
		
		if(count < 1){
			var addedDiv = document.createElement("div"); // 폼 생성
			
			addedDiv.innerHTML = str; // 폼 Div안에 HTML삽입
			addedDiv.setAttribute("id", "keyword_Frm"+eachCount);
			
			//writeModify.appendChild(addedDiv); // 삽입할 DIV에 생성한 폼 삽입
			//writeModify.item(writeModify.length).appendChild(addedDiv);
				
			//for(var i = 0; i < writeModify.length; i++)	         
			writeModify[eachCount].appendChild(addedDiv);			
			
			count++;		
		}else {
			alert("2개 이상 수정은 아니되어요");
		}		
	}
	
	function delForm(eachCount){
	//이 부분에는 추가될 부분의 div 이름을 넣으시면 됩니당
		var writeModify = document.querySelectorAll("#writeModify");
		var thisDiv = document.getElementById("keyword_Frm"+(eachCount));
		
		//document.writeModify.reset(); // 폼 내용 삭제
		writeModify[eachCount].removeChild(thisDiv); // 폼 삭제 
		
		count--;
	}
</script>

<main id="main">
<h2 id="debate">Debate Topics</h2>
<table  id="topic">
	<thead>
		<tr align="center">
			<th width="30%">제목</th>
			<th width="40%">${debate.title}</th>
        </tr>
	</thead>
	<tbody>
         <tr>
             <td>작성일</td>
             <td><fmt:formatDate pattern="yyyy-MM-dd" value="${debate.regDate}" /></td>
         </tr>
         <tr>
			<td>조회수</td>
			<td><font color="#000">${debate.hit}</font></td>
			<td>찬성</td>
			<td><font color="red">${debate.agreeCnt}</font></td>
			<td>반대</td>
			<td><font color="blue">${debate.disagreeCnt}</font></td>
         </tr>
         <tr>
             <td id="debate-content">
             	<img src=/>
                 내용 : ${debate.contents}
             </td>
         </tr>
         <tr><a href="/WSQPrj/wsqdebate/debateList"><input type="button"
		value="목록이동" /></a>
		</tr>
     </tbody>
</table>

<%-- <table id="agree">
	<thead>
	</thead>
	<tbody>
	</tbody>
</table>
<div id="debate-comment"></div>
<div id="debate-name">제목 : ${debate.title}</div>
<div id="debate-name">
	날짜 :
	<fmt:formatDate pattern="yyyy-MM-dd" value="${debate.regDate}" />
</div>
<div id="debate-image"></div>
<div id="debate-versus">
	조회수:<font color="#000">${debate.hit}</font> / 찬성:<font color="red">${debate.agreeCnt}</font>
	/ 반대:<font color="blue">${debate.disagreeCnt}</font>
</div>
<div id="debate-content">내용 : ${debate.contents}</div>

<!-- <div style="border: 2px solid #e9e9e9 ; width: 500px; height: 300px;">
		<iframe id="iframe" style="width: 100%; height: 100%" src="frame.html"></iframe>
	</div> -->

<div>
	<a href="/WSQPrj/wsqdebate/debateList"><input type="button"
		value="목록이동" /></a>
</div> --%>

<div id="debate-comment">
	<c:if test="${comments[0] == null}">
		<p>등록된 댓글이 없습니다</p>
	</c:if>
		
	<table>
	</table>
	
	<c:forEach var="co" items="${comments}" varStatus="status">
		<!-- 찬성 댓글 ----------------------------------------------------------------->
		<c:if test="${co.opinion == true}">				
			<form action="commentReg?c=${co.debateCode}&code=${co.code}" method="POST">
					<table id="writeModify">  <!-- style="padding-right: 150px;" -->		
		
					<tr>
						<td>${co.id}&nbsp;</td>
						<td><fmt:formatDate pattern="MM-dd HH:mm" value="${co.regDate}" />&nbsp;</td>
		
						<security:authorize ifAnyGranted="ROLE_ADMIN">
							<c:if test="${userid == co.id}">
								<td>
									<input type="button" value="수정" onclick="addForm(${co.code},'${co.context}', ${status.count})" />&nbsp;
								</td>				
								<td>
									<a href="debateDelete?c=${co.debateCode}&code=${co.code}&type=${co.opinion}">
									<input type="button" value="삭제"/></a>&nbsp;
								</td>
							</c:if>
						</security:authorize>
						<td>
							<input id="btn-reply" type="button" value="답글" class="${status.count}"/><span style="display: none;">${co.code}</span>&nbsp;
						</td>
		
						<%-- <input type="hidden" name="c" value="${param.c}"/> --%>
		
						<%-- <form action="commentReg?c=${co.debateCode}&code=${co.code}" method="POST">
							<div id="writeModify"></div>
						</form> --%>
					</tr>
					<tr>
						<td><font color="blue">찬성&nbsp;</font></td>
						<td>${co.context}&nbsp;</td>
					<tr/>
				</table>
			</form>
		</c:if>
		

		<!-- 반대 댓글 ---------------------------------------------	-------------------->
		<c:if test="${co.opinion == false}">
			<form action="commentReg?c=${co.debateCode}&code=${co.code}" method="POST">
					<table id="writeModify">  <!-- style="padding-right: 150px;" -->		
		
					<tr>
						<td><font color="red">반대&nbsp;</font></td>
						<td><fmt:formatDate pattern="MM-dd HH:mm" value="${co.regDate}" />&nbsp;</td>
						<td>${co.id}&nbsp;</td>
						<td>${co.context}&nbsp;</td>
		
						<security:authorize ifAnyGranted="ROLE_ADMIN">
							<c:if test="${userid == co.id}">
								<td><input type="button" value="수정"
									onclick="addForm(${co.code},'${co.context}', ${status.count})" />&nbsp;</td>				
							<td><a href="debateDelete?c=${co.debateCode}&code=${co.code}&type=${co.opinion}">
									<input type="button" value="삭제"/></a>&nbsp;</td>
							</c:if>
						</security:authorize>
						<td><input id="btn-reply" type="button" value="답글" class="${status.count}"/><span style="display: none;">${co.code}</span>&nbsp;</td>
		
						<%-- <input type="hidden" name="c" value="${param.c}"/> --%>
		
						<%-- <form action="commentReg?c=${co.debateCode}&code=${co.code}" method="POST">
							<div id="writeModify"></div>
						</form> --%>
					</tr>
				</table>
			</form>
		</c:if>

	</c:forEach>


	<!-- </iframe> -->
</div>

<%-- <table id="notices">
   <caption class="hidden">공지사항</caption>
   <thead>
      <tr>
         <th class="seq">번호</th>
         <th class="title">제목</th>
         <th class="writer">작성자</th>
         <th class="regdate">작성일</th>
         <th class="hit">조회수</th>
      </tr>
   </thead>
   <tbody style="display:block; position:relative;">
      <c:forEach var="co" items="${comments}">
         <tr>
            <td class="code">${co.code}</td>
            <td class="id">${co.title}</td>
            <td class="context">${co.id}</td>
            <td class="regdate"><fmt:formatDate pattern="yyyy-MM-dd"
                  value="${co.regDate}" /></td>            
         </tr>
      </c:forEach>
   </tbody>
</table> --%>

<template id="notice-row">
<tr>
   <td class="code"></td>
   <td class="id"></td>
   <td class="context"></td>
</tr>
</template>


<%-- <table>
	<c:forEach var="co" items="${comments}">
		<tr>
			<th>test</th>
			<th>${co.debateCode}</th>
			<th>${co.id}</a></th>
			<th>${co.context}</th>
			<th><fmt:formatDate pattern="yyyy-MM-dd" value="${c.regDate}" /></th>
		</tr>
	</c:forEach>
</table> --%>


<form action="debate?c=${debate.code}" method="post">
	<!-- encType="multipart/form-data" -->
	<div>
		<input type="radio" name="opinion" value="True" checked="checked">
		찬성 <input type="radio" name="opinion" value="False"> 반대

		<dl>
			<dt>[아이디]</dt>
			<dd>&nbsp; ${userid}</dd>
		</dl>

		<div>
			<p>[내용]</p>
			<input id="txtContent" class="txtContent" name="context"
				style="width: 400px; height: 18px;"></input>


			<input type="submit" value="댓글 등록" /> <a class="btn-cancel button"
				href="">취소</a>

		</div>
	</div>

</form>

</main>
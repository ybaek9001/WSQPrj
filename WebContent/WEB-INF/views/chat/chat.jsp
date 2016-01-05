<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<main>
	<fieldset>
		<textarea id="messageWindow" rows="25" cols="80" readonly="true"></textarea>
		<br /> <input id="inputMessage" type="text" /> 
		<input id="btn-send" type="submit" value="send" />
	</fieldset>
	<script>
window.onload = function() 
{
	var textarea = document.getElementById("messageWindow");
	var inputMessage = document.getElementById('inputMessage');
	var btnSend = document.querySelector("#btn-send");
	btnSend.onclick = function()
	{
		textarea.value += "나 : " + inputMessage.value + "\n";
		inputMessage.value = "";
	}
}
</script>
</main>

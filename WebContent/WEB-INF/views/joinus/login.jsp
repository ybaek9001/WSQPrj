<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
		<main class="main">
		
		<h2 class="hidden">로그인</h2>
		<div>
			<form id="loginjoin" action="loginProc.jsp" method="post">
				<dl>
					<dt class="join-form-title">I D</dt>
					<dd class="join-form-data">
						<input type="text" name="uid" />
					</dd>
					<dt class="join-form-title">PASSWORD</dt>
					<dd class="join-form-data">
						<input type="password" name="pwd" />
					</dd>
				</dl>
				<p>
					<input type="submit" value=" Log in ">
				</p>
			</form>
		</div>
		</main>
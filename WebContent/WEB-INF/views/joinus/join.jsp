<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

		<main class="main">
		<h2 class="hidden">회원가입</h2>
		<div>
			<form id="loginjoin" action="joinProc.jsp" method="post">
				<dl>
					<dt class="join-form-title">I D</dt>
					<dd class="join-form-data">
						<input type="text" name="uid" />
					</dd>
					<dt class="join-form-title">PASSWORD</dt>
					<dd class="join-form-data">
						<input type="password" name="pwd" />
					</dd>
					<dt class="join-form-title">EMAIL</dt>
					<dd class="join-form-data">
						<input type="text" name="email" />
					</dd>
				</dl>
				<P>
					<input type="submit" value=" Sign in ">
				</P>
			</form>
		</div>
		</main>
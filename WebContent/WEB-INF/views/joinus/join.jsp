<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
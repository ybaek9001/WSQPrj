<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<main class="main">
		<h2 class="hidden">회원가입</h2>
		<div>
			<form id="loginjoin" action="join" method="post">
				<dl>
					<dt class="join-form-title">I D</dt>
					<dd class="join-form-data">
						<input type="text" name="mid" />
					</dd>
					<dt class="join-form-title">PASSWORD</dt>
					<dd class="join-form-data">
						<input type="password" name="pwd" />
					</dd>
					<dt class="join-form-title">CONFIRM PASSWORD</dt>
					<dd class="join-form-data">
						<input type="password" name="confirm_pwd" />
					</dd>
					<dt class="join-form-title">EMAIL</dt>
					<dd class="join-form-data">
						<input type="email" name="email" />
					</dd>
				</dl>
				<div style="color:red;">
					<c:if test="${c!=null && errorID!=null}">
					${errorID}
					</c:if>
					<c:if test="${c!=null && errorPW!=null}">
					${errorPW}
					</c:if>
				</div>
				<P>
					<input type="submit" value=" Sign in ">
				</P>
			</form>
		</div>
		</main>
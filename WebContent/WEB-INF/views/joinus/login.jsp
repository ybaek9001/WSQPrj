<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
		<main class="main">
		
		<h2 class="hidden">로그인</h2>
		<div>
			<form id="loginjoin" action="<c:url value="/j_spring_security_check"/>" method="post">
				<dl>
					<dt class="join-form-title">I D</dt>
					<dd class="join-form-data">
						<input type="text" name="j_username" />
					</dd>
					<dt class="join-form-title">PASSWORD</dt>
					<dd class="join-form-data">
						<input type="password" name="j_password" />
					</dd>
				</dl>
				<div><c:if test="${error!=null}">${error}</c:if></div>
				<p>
					<input type="submit" value=" Log in ">
				</p>
			</form>
		</div>
		</main>
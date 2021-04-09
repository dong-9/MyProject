<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<link rel="stylesheet" type="text/css" href="resources/user/css/topMenu.css">

<ul id="top-menu">
	<!-- login -->
	<!-- 로그인 인증을 받았을때 -->
	<security:authorize access="isAuthenticated()">
		<security:authentication property="principal" var="user"/>
		<li class="user-id">${user.email}</li>
		<li>
			<form name="logout" action="logout" method="POST">
				<security:csrfInput/>
				<a href="javascript:logout.submit();" class="top-menu-btn">로그아웃</a>
			</form>
		</li>
		<li><a href="myPage">마이페이지</a></li>
	</security:authorize>
	<!-- //login -->
	
	<!-- logout -->
	<!--  익명사용자 -->
	<security:authorize access="isAnonymous()">
		<li><a href="login" class="top-menu-btn">로그인</a></li>
		<li><a href="join">회원가입</a></li>
	</security:authorize>
	<!-- //logout -->	
</ul>

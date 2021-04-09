<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<security:csrfMetaTags/>
<title>고속버스통합예매</title>
<!-- user common file setting -->
<c:import url="../common/userSettings.jsp"></c:import>
<!-- css -->
<link rel="stylesheet" type="text/css" href="resources/user/css/myPage/changeNumber.css">
</head>
<body>
	<!-- side-manu -->
	<c:import url="../common/sideMenu.jsp"></c:import>
	<!-- // side-manu -->
	<!-- main -->
	<div id="main">
		<!-- top-menu -->
		<c:import url="../common/topMenu.jsp"></c:import>
		<!-- // top-menu -->
		<!-- header -->
		<header id="header">
			<h2>휴대폰번호 변경</h2>
		</header>
		<!-- // header -->
		<!-- content -->
		<section id="content">
			<h3>현재 사이트에 등록된 비밀번호와 변경하실 새로운 휴대폰 번호를 입력하세요.</h3>
			<!-- content-box -->
			<div class="content-box">
				<!-- change-pn-box -->
				<div class="change-pn-box">
					<div class="area">
						<div class="input-box">
							<label for="pw">비밀번호</label>
							<input type="password" id="pw" placeholder="비밀번호를 입력하세요."/>
						</div>
					</div>
					<div class="area">
						<div class="input-box">
							<label for="phone">휴대폰번호</label>
							<input type="text" id="phone" placeholder="휴대폰번호를 입력하세요."/>
						</div>
					</div>
				</div>
				<!-- // change-pn-box -->
			</div>
			<!-- // content-box -->
			<security:authentication property="principal" var="user"/>
			<input type="hidden" id="user-id" value="${user.email}">
			<input type="button" class="change-pn-btn" value="변경하기" />
			<!-- content-box -->
			<div class="content-box result">
				<!-- result-box -->
				<div class="result-box">
					<div class="area">
						<div class="input-box">
							<label for="phone">휴대폰번호</label>
							<input type="text" id="phone" placeholder="휴대폰번호를 입력하세요."/>
						</div>
					</div>
				</div>
				<!-- // result-box -->	
			</div>
			<!-- // content-box -->
			<input type="button" class="check-btn result" value="확인" />
		</section>
		<!-- // content -->
		<!-- footer -->
		<c:import url="../common/footer.jsp"></c:import>
		<!-- // footer -->		
	</div>
	<!-- // main -->
	<!-- js -->
	<script src="resources/user/js/myPage/changeNumber.js"></script>
</body>
</html>
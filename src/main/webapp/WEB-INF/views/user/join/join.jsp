<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<security:csrfMetaTags/>
<title>고속버스통합예매</title>
<!-- user common file setting -->
<c:import url="../common/userSettings.jsp"></c:import>
<!-- css -->
<link rel="stylesheet" type="text/css" href="resources/user/css/join/join.css">

<!-- jQuery 데이터 피커 -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="resources/user/js/join/join.js"></script>
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
			<h2>회원가입</h2>
		</header>
		<!-- // header -->
		<!-- content -->
		<section id="content">
			<h3>회원정보를 입력해주세요.</h3>
			<!-- content-box -->
			<div class="content-box">
				<form:form id="join" action="join" method="post" modelAttribute="memberVO">
				<!-- join-box -->
				<div class="join-box">
					<security:csrfInput/>
					<!-- input-box -->
					<div class="input-box">
						<label for="user-ID">아이디</label>
						<input type="email" id="user-ID" name="email" placeholder="이메일을 입력해 주세요."/>
						<input type="button" id="check-id" value="ID 중복확인"/>
						<form:errors path="email" />
					</div>
					<!-- // input-box -->
					<!-- input-box -->
					<div class="input-box">
						<label for="user-PW">비밀번호</label>
						<input type="password" id="user-PW" name="password" placeholder="영문 숫자 특수문자 포함 8자리 이상 입력해주세요"/>
						<form:errors path="password" />
					</div>
					<!-- // input-box -->
					<!-- input-box -->
					<div class="input-box">
						<label for="check-PW">비밀번호 확인</label>
						<input type="password" id="check-PW" value="" placeholder="비밀번호를 재입력 하세요."/>
					</div>
					<!-- // input-box -->
					<!-- select-box -->
					<div class="input-box">
						<label for="birthd">출생년도</label>
						<input type="text" id="birthd" name="birthd" value="" placeholder="날짜를 선택해주세요">
					</div>
					<!-- // select-box -->
					<!-- input-box -->
					<div class="input-box">
						<label for="phone">휴대폰번호</label>
						<input type="text" id="phone" name="phone" placeholder="010-1234-5678"/>
						<input type="hidden" name="point" id="point" value="10000">
						<form:errors path="point" />
					</div>
					<!-- // input-box -->
				</div>
				<!-- // join-box -->
				</form:form>
			</div>
			<!-- // content-box -->
			<ul class="btn-box">
				<li><input type="button" class="join-btn" value="회원가입" /></li>
			</ul>
			<ul class="text-box">
				<li>고객님의 이메일과 출생, 성별은 아이디와 비밀번호 분실 시 필요한 정보입니다.</li>
				<li>고객님의 출생과 성별은 더 나은 서비스를 위해 마케팅 정보로 활용됩니다.</li>
			</ul>
			
			
		</section>
		<!-- // content -->
		<!-- footer -->
		<c:import url="../common/footer.jsp"></c:import>
		<!-- // footer -->		
	</div>
	<!-- // main -->
</body>
</html>
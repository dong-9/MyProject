<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고속버스통합예매</title>
<!-- user common file setting -->
<c:import url="../common/userSettings.jsp"></c:import>
<!-- css -->
<link rel="stylesheet" type="text/css" href="resources/user/css/login/login.css">
<script type="text/javascript">
	function loginSubmit(){
		$('#login').submit();
	}
</script>
</head>
<body>
	<c:if test="${!empty loginFailMsg}">
		<script>alert('${loginFailMsg}')</script>
	</c:if>
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
			<!-- content-box -->
			<div class="content-box">
				<!-- login-box -->
				<div class="login-box">
					<h3>회원 로그인</h3>
					<p><span>고속버스 통합 예매 홈페이지</span>는 고속버스모바일앱의 회원 아이디와 비밀번호로 이용이 가능합니다.</p>
					<!-- login-form -->
					<div class="login-form">
						<form id="login" action="login" method="post">
						<div class="login-form-box">
							<div class="input-warp">
								<div class="input-box">
									<label for="user-id">아이디</label>
									<input type="text" name="email" id="user-id" placeholder="아이디를 입력하세요"/>
								</div>
								<div class="input-box">
									<label for="user-pw">비밀번호</label>
									<input type="password" name="password" id="user-pw" placeholder="비밀번호를 입력하세요"/>
								</div>
							</div>
							<security:csrfInput/>
							<input type="button" class="login-btn" value="로그인" onclick="loginSubmit()"/>
						</div>
						</form>
						<div class="find-box">
							<a href="findID"><span class="img"></span>아이디찾기</a> 
							<a href="findPW"><span class="img"></span>비밀번호 찾기</a>
						</div>
					</div>
					<!-- //login-form -->

				</div>
				<!-- // login-box -->
				<!-- join-box -->
				<div class="join-box">
					<div class="sub-box">
						<span>고속버스 통합회원으로 가입하시면 홈페이지와 모바일앱과의 예매내역 공유로 더욱 편리한 고속버스 이용이 가능합니다.</span>
						<a href="join"><img src="resources/user/images/login/ico_joinUs_s.png" alt="join" title="join"/>통합회원가입</a>
					</div>
				</div>
				<!-- // join-box -->
			</div>
			<!-- // login_wrap -->
			<!-- banner -->
			<div class="banner">
				<p>예매부터 탑승까지 원스탑 모바일 서비스! <b>고속버스 모바일앱</b></p>
				<img src="resources/user/images/login/bnr_app_s.png" alt="banner" title="banner" />
			</div>
			<!-- // banner -->
		</section>
		<!-- // content -->
		<!-- footer -->
		<c:import url="../common/footer.jsp"></c:import>
		<!-- // footer -->		
	</div>
	<!-- // main -->
	
</body>
</html>
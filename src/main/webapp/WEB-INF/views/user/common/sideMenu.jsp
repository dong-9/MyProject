<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<link rel="stylesheet" type="text/css" href="resources/user/css/sideMenu.css">

<div id="side-menu">
	<!-- logo -->
	<div class="logo">
		<a href="main">
			<img src="resources/common/images/logo_pc.png" alt="logo" title="logo" />
			<span>고속버스통합예매</span>
		</a>
	</div>
	<!-- // logo -->
	<!-- menu -->
	<ul class="menu">
		<li><a href="ticketList">예매확인</a></li>
		<li><a href="terminal">이용안내</a></li>
		<li><a href="qnaList">고객센터</a></li>
		<li><a href="#" id="kakaoMap" onclick="openPop()">지도검색</a></li>
	</ul>
	<!-- // menu -->
</div>
<script>
	function openPop(){
		var popup = window.open('kakaoMap', '카카오 지도', 'width=900px, height=600px, scrollbars=yes');
	}
</script>
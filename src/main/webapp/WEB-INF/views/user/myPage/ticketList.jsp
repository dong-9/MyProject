<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
<link rel="stylesheet" type="text/css" href="resources/user/css/myPage/ticketList.css">
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
			<h2>예매확인/취소</h2>
		</header>
		<!-- // header -->
		<!-- sub-pame-menu -->
		<ul id="sub-pame-menu">
			<li><a href="main">HOME</a></li>
			<li>예매확인</li>
			<li>예매확인/취소</li>
		</ul>
		<c:catch>
		</c:catch>
		<!-- // sub-pame-menu -->
		<!-- content -->
		<section id="content">
			<!-- content-box -->
			<div class="content-box">
				<!-- data-box -->
				<div class="data-box">
					<div class="data-head-box">
						<span>예매내역</span>
						<img src="resources/user/images/myPage/ticketList/ico_tab_s_on3.png" alt="check" title="check" />
					</div>
					<div class="data-body-box">
					<c:if test="${empty myTicketList}">
						<!-- not-data -->
						<p class="not-data">예매 자료가 존재하지 않습니다.</p>
						<!-- // not-data -->
					</c:if>
					<c:if test="${!empty myTicketList}">
					<c:forEach var="list" items="${myTicketList}">
						<!-- item -->
						<div class="data-info-box">
							<div class="info-title-box">티켓</div>
							<div class="info-head-box">${list.departure_date} 출발</div>
							<div class="info-body-box">
								<div class="left-box">
									<div class="info-box">
										<div class="round">출발</div>
										<div class="text">${list.departure_area}</div>
									</div>
									<div class="info-box">
										<div class="round">도착</div>
										<div class="text">${list.destination}</div>
									</div>
								</div>
								<div class="right-box">
									<div class="info-box">
										<span class="s-text">매수</span>
										<span class="m-text">${list.number_of_tickets}</span>
									</div>
									<div class="info-box">
										<span class="s-text">좌석</span>
										<span class="m-text">
											<c:forTokens varStatus="vs" var="seat" items="${list.seat_number}" delims="/">
												${seat}${vs.last ? '' : ','}
											</c:forTokens>
										</span>
									</div>
								</div>
							</div>
						</div>
						<c:if test="${list.ticketing_status eq 1 && fn:contains(list.departure_date, serverTime)}">
							<input type="button" class="cancel-btn" id="${list.ticketing_number}" value="예매취소" />
						</c:if>
						<c:if test="${list.ticketing_status eq 1 && !fn:contains(list.departure_date, serverTime)}">
							<input type="button" class="cancel-btn" id="${list.ticketing_number}" value="운행완료" disabled="disabled"/>
						</c:if>
						<c:if test="${list.ticketing_status eq 0}">
							<input type="button" class="cancel-btn" id="${list.ticketing_number}" value="취소완료" disabled="disabled"/>
						</c:if>
						<!-- // item -->
					</c:forEach>
					</c:if>
					</div>
				</div>
				<!-- // data-box -->
				<ul class="text-box">
					<li>과거 예매 내역은 출발일 날짜 기준 당일까지, 예매 취소 내역은 과거 3개월까지 조회 가능합니다.</li>
					<li><em>홈티켓으로 발권된 내역은 변경이 불가</em>하니 변경을 원하시면 취소 후 다시 예매를 진행하시기 바랍니다.</li>
					<li>마일리지 구매 승차권은 시간변경이 불가하니 변경을 원하시면 취소 후 다시 예매를 진행하시기 바랍니다.</li>
					<li>마일리지 승차권 취소 시, 마일리지 수수료 정책에 따라 처리됩니다.</li>
					<li>신용카드 예매 취소 또는 변경 시 일주일 내로 예매했던 카드로 청구 취소 처리가 되면서 반환됩니다.</li>
					<li><em>시간변경은 취소 위약금을 부과하지 않습니다.</em></li>
				</ul>
			</div>
			<!-- // content-box -->
		</section>
		<!-- // content -->
		<!-- footer -->
		<c:import url="../common/footer.jsp"></c:import>
		<!-- // footer -->		
	</div>
	<!-- // main -->
	<script src="resources/user/js/myPage/cancleTicket.js"></script>
</body>
</html>
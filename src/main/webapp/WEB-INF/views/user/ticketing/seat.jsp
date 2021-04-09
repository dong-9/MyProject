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
<link rel="stylesheet" type="text/css" href="resources/user/css/ticketing/seat.css">
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
			<h2>고속버스예매</h2>
		</header>
		<!-- // header -->
		<!-- sub-pame-menu -->
		<ul id="sub-pame-menu">
			<li><a href="main">HOME</a></li>
			<li>고속버스예매</li>
		</ul>
		<!-- // sub-pame-menu -->
		<!-- content -->
		<section id="content" class="seat-data-box">
			<h3>매수 및 좌석선택</h3>
			<!-- content-box -->
			<div class="content-box">
				<!-- info-box -->
				<div class="info-box">
					<div class="date-box">${serverTime}</div>
					<div class="time-box"><span>출발 </span><span id="departure_date">${bus_info.departure_time}</span></div>
					<div class="terminal-box">
						<div class="start">
							<div class="round">출발</div>
							<div class="text" id="departure_area">${bus_info.departure_area}</div>
						</div>
						<div class="end">
							<div class="round">도착</div>
							<div class="text" id="destination">${bus_info.destination}</div>
						</div>
					</div>
				</div>
				<!-- // info-box -->
				<!-- detail-box -->
				<div class="detail-box">
					<div class="detail-head-box">
						<div class="seat">잔여 ${bus_info.remaining_seats}석 / 전체 ${bus_info.total_seats}석</div>
						<div class="text"><span class="square-orange"></span>여성/노약자 우선</div>
					</div>
					<div class="detail-body-box">
						<div class="select-seat-box">
							<div class="seat-bg">
								<div class="seat-list">
									<c:forEach var="list" items="${seatList}">
									<div class="seat-area ${list.available_seat eq 1 ? 'disabled' : ''}">
										<input type="checkbox" id="seat${list.seat_number}" class="select_seat" value="${list.seat_number}"/>
										<label for="seat${list.seat_number}">${list.seat_number}</label>
									</div>
									</c:forEach>
								</div>
							</div>
						</div>
						<div class="select-data-box">
							<div class="seat-info">
								<div class="text">선택좌석</div>
								<div class="seat-number"></div>
							</div>
							<div class="price-info">
								<span class="text">총 결제금액</span>
								<span class="price"></span>
							</div>
							<!-- 선택한좌석 없으면 alert and 밑에 안나오게-->
							<input type="button" class="seat-btn" value="선택완료"/>
						</div>
					</div>
				</div>
				<!-- // detail-box -->
			</div>
			<!-- // content-box -->
			<!-- text-box -->
			<ul class="text-box">
				<li>심야 시간대 출발차량의 1번부터 9번 좌석까지는 여성고객 및 노약자를 위한 좌석으로 운영되고 있습니다. 교통 약자를 위해 배려해 주시기 바랍니다.</li>
				<li>일부 버스의 경우 실제 좌석배치와 다를 수 있습니다.</li>
				<li><span class="square-orange">색상표기 좌석</span>은 여성고객 및 노약자를 위한 좌석입니다. 배려해 주시기 바랍니다.</li>
			</ul>
			<!-- // text-box -->
		</section>
		<!-- // content -->
		<!-- content -->
		<section id="content" class="payment-data-box">
			<h3>가는 편 승차권 정보</h3>
			<!-- content-box -->
			<div class="content-box">
				<div class="payment-head-box">${serverTime} ${bus_info.departure_time}</div>
				<div class="payment-body-box">
					<div class="right-box">
						<div class="start">
							<div class="round">출발</div>
							<div class="text">${bus_info.departure_area}</div>
						</div>
						<div class="end">
							<div class="round">도착</div>
							<div class="text">${bus_info.destination}</div>
						</div>
					</div>
					<div class="left-box">
						<div class="basics-box">
							<div>매수</div>
							<div id="ticket-num"></div>
						</div>
						<div class="basics-box">
							<div>좌석</div>
							<div class="seat-number"></div>
						</div>
						<div class="price-box">
							<div>총 결제금액</div>
							<div class="price"></div>
						</div>
					</div>
				</div>
			</div>
			<!-- // content-box -->
			<security:authentication property="principal" var="user"/>
			<input type="hidden" id="user-id" value="${user.email}">
			<input type="hidden" id="busName" value="${bus_info.bus_name}">
			<input type="hidden" id="area" value="${area}">
			<input type="button" class="payment-btn" value="결제하기" />
		</section>
		<!-- // content -->
		<!-- footer -->
		<c:import url="../common/footer.jsp"></c:import>
		<!-- // footer -->		
	</div>
	<!-- // main -->
	<!-- js -->
	<script src="resources/user/js/ticketing/seat.js"></script>
</body>
</html>
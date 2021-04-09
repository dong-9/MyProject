<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리</title>
<!-- admin common file setting -->
<c:import url="../common/adminSettings.jsp"></c:import>
</head>
<body>
	<div class="container-scroller">
		<!-- header -->
		<nav class="navbar default-layout col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
			<!-- 상단 로고 박스 -->
			<div class="text-center navbar-brand-wrapper d-flex align-items-top justify-content-center">
				<a class="navbar-brand brand-logo" href="/admin/member/list">
					<img src="/resources/admin/images/logo.svg" alt="logo" />
				</a>
				<a class="navbar-brand brand-logo-mini" href="/admin/member/list">
					<img src="/resources/admin/images/logo-mini.svg" alt="logo" />
				</a>
			</div>
			<!-- //상단 로고 박스 -->
			<!-- 상단 흰색 바 -->
			<div class="navbar-menu-wrapper d-flex align-items-center"></div>
			<!-- //상단 흰색 바 -->
		</nav>
		<!-- header -->
		<!-- main -->
		<div class="container-fluid page-body-wrapper">
			<!-- side menu -->
			<nav class="sidebar sidebar-offcanvas" id="sidebar">
				<ul class="nav">
					<!-- menu title -->
					<li class="nav-item nav-category">Main Menu</li>
					<!-- //menu title -->
					<!-- item -->
					<li class="nav-item">
						<a class="nav-link" href="/admin/member/list"> 
							<i class="menu-icon typcn typcn-document-text"></i>
							<span class="menu-title">회원관리</span>
						</a>
					</li>
					<!-- //item -->
					<!-- item -->
					<li class="nav-item">
						<a class="nav-link" href="/admin/ticketing/list">
							<i class="menu-icon typcn typcn-document-text"></i>
							<span class="menu-title">예매관리</span>
						</a>
					</li>
					<!-- //item -->
					<!-- item -->
					<li class="nav-item">
						<a class="nav-link" href="/admin/questions/list">
							<i class="menu-icon typcn typcn-document-text"></i>
							<span class="menu-title">Q&#38;A 답변관리</span>
						</a>
					</li>
					<!-- //item -->
				</ul>
			</nav>
			<!-- //side menu -->
			<!-- white box  -->
			<div class="main-panel">
				<!-- content box -->
				<div class="content-wrapper">
					<!-- white box -->
					<div class="col-lg-6 grid-margin stretch-card">
						<div class="card">
							<div class="card-body">
								<h3>회원 수정</h3>
								<br>
								<form:form class="forms-sample" modelAttribute="memberInfo" action="update" method="POST">
									<security:csrfInput/>
									<!-- form-group -->
									<div class="form-group row">
										<label for="email" class="col-sm-2 col-form-label">email</label>
										<div class="col-sm-10">
											<form:input path="email" cssClass="form-control" readonly="true"/>
										</div>
									</div>
									<!-- //form-group -->
									<!-- form-group -->
									<div class="form-group row">
										<label for="password" class="col-sm-2 col-form-label">password</label>
										<div class="col-sm-10">
											<input type="password" id="password" class="form-control" name="password" value="${memberInfo.password}"/>
											<form:errors path="password"/>
										</div>
									</div>
									<!-- //form-group -->
									<!-- form-group -->
									<div class="form-group row">
										<label for="phone" class="col-sm-2 col-form-label">phone</label>
										<div class="col-sm-10">
											<form:input path="phone" cssClass="form-control" />
											<form:errors path="phone"/>
										</div>
									</div>
									<!-- //form-group -->
									<!-- form-group -->
									<div class="form-group row">
										<label for="date" class="col-sm-2 col-form-label">birthd</label>
										<div class="col-sm-10">
											<!--  달력 넣기 -->
											<form:input path="birthd" id="date" cssClass="form-control" />
											<form:errors path="birthd"/>
										</div>
									</div>
									<!-- //form-group -->
									<!-- form-group -->
									<div class="form-group row">
										<label for="point" class="col-sm-2 col-form-label">point</label>
										<div class="col-sm-10">
											<form:input path="point" cssClass="form-control" />
											<form:errors path="point"/>
										</div>
									</div>
									<!-- //form-group -->
									<input type="submit" style="float: right" class="btn btn-success mr-2" value="등록">
								</form:form>
							</div>
						</div>
					</div>
					<!-- // white box -->
				</div>
				
				<!-- //content box -->
				<!-- footer -->
				<footer class="footer">
					<div class="container-fluid clearfix">
						<span class="text-muted d-block text-center text-sm-left d-sm-inline-block">Copyright © bootstrapdash.com 2020</span>
						<span class="float-none float-sm-right d-block mt-1 mt-sm-0 text-center">
							Free 
							<a href="https://www.bootstrapdash.com/bootstrap-admin-template/" target="_blank">Bootstrap admin templates</a> 
							from Bootstrapdash.com
						</span>
					</div>
				</footer>
				<!-- //footer -->
			</div>
			<!-- //white box  -->
		</div>
		<!-- //main -->
	</div>
</body>
</html>
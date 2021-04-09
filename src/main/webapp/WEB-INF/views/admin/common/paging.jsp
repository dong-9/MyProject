<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div style="text-align: center;">
	<c:if test="${pageMaker.prev && pageMaker.startPageNum > 1}">
		<a href="list${pageMaker.makeSearchQuery(1)}" class="btn btn-primary">처음</a>
		<a href="list${pageMaker.makeSearchQuery(pageMaker.startPageNum - 1)}" class="btn btn-primary">이전</a>
	</c:if>
	<c:forEach var="i" begin="${pageMaker.startPageNum}" end="${pageMaker.endPageNum}">
		<a href="list${pageMaker.makeSearchQuery(i)}" class="btn btn-primary">${i}</a>
	</c:forEach>
	<c:if test="${pageMaker.next && pageMaker.endPageNum > 0}">
		<a href="list${pageMaker.makeSearchQuery(pageMaker.endPageNum + 1)}" class="btn btn-primary">다음</a>
		<a href="list${pageMaker.makeSearchQuery(pageMaker.lastPageNum)}" class="btn btn-primary">끝</a>
	</c:if>
</div>
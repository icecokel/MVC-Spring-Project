<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	

<c:forEach var="i" begin="1" end="5">
	<li class="list-group-item"><strong>한겨례 신문 : ${i }번째 기사.</strong></li>
	<p>${i }기사내용</p>
</c:forEach>
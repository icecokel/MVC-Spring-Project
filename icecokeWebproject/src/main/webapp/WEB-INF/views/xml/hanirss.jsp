<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section>
	<%-- <c:forEach var="hani" items="${titles }">
	<li class="list-group-item"><strong>${hani}</strong></li>
</c:forEach>
 --%>

	<%-- 	<c:forEach var="i" begin="1" end="5">
		<li> ${titles } </li>
		<p> ${contents }</p>
	</c:forEach> --%>

	<c:forEach var="hanilist" items="${hanilist }">
		<li class="list-group-item"><strong>${hanilist.num}번 기사
				: ${hanilist.title}</strong></li>
		<li class="list-group-item"><strong>${hanilist.content}</strong></li>
	</c:forEach>

</section>
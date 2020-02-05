<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
#hanilist {
	font-size: 14px;
}

#hanicontent {
	font-size: 12px;
}
</style>
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
		<p id="hanilist"><a href="${hanilist.link }">${hanilist.num}번기사: ${hanilist.title}</a></p>
		
		<p id="hanicontent">&nbsp;&nbsp;${hanilist.content}</p>
		
	</c:forEach>

</section>
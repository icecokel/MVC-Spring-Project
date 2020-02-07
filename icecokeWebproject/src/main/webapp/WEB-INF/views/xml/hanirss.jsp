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

	<c:forEach var="hanilist" items="${hanilist }">

		<img src="${hanilist.img }" align ="left">
		<a href="${hanilist.link }" id="hanilist">${hanilist.num} )
			${hanilist.title}</a>
		<p id="hanicontent">&nbsp;&nbsp;${hanilist.content}</p>
		<br/><br/><br/><br/>
	</c:forEach>



</section>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
@import url(//fonts.googleapis.com/earlyaccess/jejugothic.css);

.filelistdiv {
	font-size: 10px;
	font-family: 'Jeju Gothic', sans-serif;
	
}
</style>
<section>
	<div class="filelistdiv">
		<table class="table" border="1px">
			<thead>
				<tr>
					<td scope="col" width="5%">번호</td>
					<td scope="col" width="65%" style="text-align: center">파일이름</td>
					<td scope="col" width="10%">작성자</td>
					<td scope="col" width="10%">수정일</td>
					<td scope="col" widtH="10%">파일크기</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="boardDto" items="${boardlist }">
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</section>
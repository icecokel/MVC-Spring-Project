<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
@import url(//fonts.googleapis.com/earlyaccess/jejugothic.css);

.filelistdiv {
	font-family: 'Jeju Gothic', sans-serif;
	padding-left: 3%;
	padding-right: 3%;
}
</style>

<link
	href="/resources/startbootstrap/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="/resources/startbootstrap/css/clean-blog.min.css"
	rel="stylesheet">
<link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link
	href="/resources/startbootstrap/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800'
	rel='stylesheet' type='text/css'>

<section>

	<div class="filelistdiv">
		<table class="table" >
			<thead>
				<tr>
					<th scope="col" width="5%">번호</th>
					<th scope="col" width="65%" style="text-align: center">파일이름
					</th>
					<th scope="col" width="10%">작성자</th>
					<th scope="col" width="10%">수정일</th>
					<th scope="col" widtH="10%">파일크기</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="files" items="${filedownload }">
					<tr>
						<td>${files.filenum }</td>
						<td><a href="/filedown/${files.filenum}" target="_blank">${files.filename }</a></td>
						<td>${files.nickname }</td>
						<td>${files.dispdate }</td>
						<td>${files.filesize }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</section>


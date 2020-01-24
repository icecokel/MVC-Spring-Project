<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<style>
@import url(//fonts.googleapis.com/earlyaccess/jejugothic.css);

.filelistdiv {
	font-family: 'Jeju Gothic', sans-serif;
}
</style>
<section>
	<div align = 'center'>
		<c:if test="${user ==null }">
		
			<h3>파일 업로드  <br/>서비스는 로그인을 해야 사용 하실 수 있습니다.</h3>
		</c:if>
		<c:if test="${user !=null }">
		<form method="post" enctype="multipart/form-data" >
			<!-- <input type="file" multiple="multiple" id="files" name ="files"  ><br/> -->
			<input type="file" id="files" name ="files"  ><br/>
			<input type="submit" value="업로드" class="btn btn-primary"/>
		</form>
		</c:if>
	</div>
</section>

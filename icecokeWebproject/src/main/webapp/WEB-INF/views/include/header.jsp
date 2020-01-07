<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<style>
@import url(//fonts.googleapis.com/earlyaccess/jejugothic.css);

.listdiv {
	font-family: 'Jeju Gothic', sans-serif;
	padding-left: 5%;
	padding-right: 5%;
}

.logindiv {
	font-family: 'Jeju Gothic', sans-serif;
	text-align: center;
	padding-left: 15%;
	padding-right: 15%;
}
 .joinformdiv{
 	font-family: 'Jeju Gothic', sans-serif;
	
	padding-left: 15%;
	padding-right: 15%;
 }
 .filelistdiv{
 	font-family: 'Jeju Gothic', sans-serif;
	
	padding-left: 10%;
	padding-right: 10%;
 }
</style>
<!-- JQuery 설정  -->
<script src="/resources/jquery/jquery.js"></script>

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Welcome! ICE COKE PROJECT</title>

<!-- Bootstrap core CSS -->
<link
	href="/resources/startbootstrap/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
	

<!-- Custom fonts for this template -->
<link
	href="/resources/startbootstrap/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800'
	rel='stylesheet' type='text/css'>

<!-- Custom styles for this template -->
<link href="/resources/startbootstrap/css/clean-blog.min.css"
	rel="stylesheet">
	<link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
</head>

<body>

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-light fixed-top"
		id="mainNav">
		<div class="container">
			<a class="navbar-brand" href="/">IceCoke</a>
			
			<button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation">
				Menu 
				<!-- <i class="fas fa-bars"></i> -->
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav mr-auto">
					<c:if test="${user == null}">
						<li class="nav-item"><a class="nav-link" href="/user/login">Login</a></li>
					</c:if>
	
					<c:if test="${user != null}">

						<a href ="/user/profile" ><img src ="/userimage/${user.image}" id="img" class="rounded-circle" width="30" height="30" /></a>
						
						<li class="nav-item"><a class="nav-link" href="/user/profile">${user.nickname}님이 로그인 </a></li>
						<li class="nav-item"><a class="nav-link" href="/user/logout">Logout</a></li>
					</c:if>
	
					<li class="nav-item"><a class="nav-link" href="/board/list">MyBoard</a></li>
					<li class="nav-item"><a class="nav-link" href="/file/filelist">FileList</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="">ETC</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<!-- Page Header -->
	<header class="masthead"
		style="background-image: url('/resources/startbootstrap/img/cokeHome-bg.jpg')">
		<div class="overlay"></div>
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-md-10 mx-auto">
					<div class="site-heading">
						<h1>ICE COKE Webproject</h1>
						<span class="subheading">공부 및 편의를 위한 개인 공간입니다.</span>
					</div>
				</div>
			</div>
		</div>
	</header>
</body>
</html>
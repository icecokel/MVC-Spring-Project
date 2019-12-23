<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- header.jsp 파일을 추가 -->
<%@ include file="include/header.jsp"%>
<section class="content">
	<div class="listdiv">
		<ul class="list-group list-group-flush">
			<c:if test="${user == null}">
				<li class="list-group-item"><a href='/user/login'>로그인
						페이지로이동</a></li>
			</c:if>

			<c:if test="${user != null}">
				<div class="alert alert-success" role="alert" align ='center'>
					<a href="#" class="alert-link">${user.nickname}님</a> 로그인을 성공 하셨습니다.
				</div>
				<li class="list-group-item"><a href=''>계정 생성 페이지로 이동</a></li>
			</c:if>

			<li class="list-group-item">게시판으로 이동</li>
			<li class="list-group-item">파일 리스트로 이동</li>
		</ul>
	</div>
</section>

<!-- footer.jsp 파일을 추가 -->

<%@ include file="include/footer.jsp"%>


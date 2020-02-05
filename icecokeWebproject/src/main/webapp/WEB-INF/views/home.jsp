<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- header.jsp 파일을 추가 -->
<%@ include file="include/header.jsp"%>
<section class="content">
	<div class="listdiv">
		<ul class="list-group list-group-flush">
			<c:if test="${user == null}">
				<li class="list-group-item">
					<div style="text-align: center; color: red;">대부분의 서비스는 로그인 후
						사용이 가능합니다.</div>
				</li>
				<li class="list-group-item"><a href='/user/login'>로그인
						페이지로이동</a></li>

			</c:if>

			<c:if test="${user != null}">
				<div class="alert alert-success" role="alert" align='center'>
					<a href="#" class="alert-link">${user.nickname}님</a> 로그인을 성공 하셨습니다.
				</div>
				<li class="list-group-item"><a href='/user/join'>계정 생성 페이지로
						이동</a></li>
				<li class="list-group-item"><a href="/board/list">게시판으로 이동</a></li>
				<li class="list-group-item"><a href="/file/filelist">파일
						리스트로 이동</a></li>
			</c:if>
			
				
			
		</ul>
		<iframe src ="/xml/hanirss" width="100%" height="500px" frameborder="0"></iframe>		
	</div>
</section>
<!-- footer.jsp 파일을 추가 -->
<%@ include file="include/footer.jsp"%>
<script src="/resources/scripts/home.js"></script>


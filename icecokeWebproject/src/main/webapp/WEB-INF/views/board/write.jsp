<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

<!-- include libraries(jQuery, bootstrap) -->
<link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script> 
<!-- include summernote css/js-->
<link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.css" rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.js"></script>
<!-- include summernote-ko-KR -->
<script src="/resources/summernote/summernote-ko-KR.js"></script>
<section>
	<form method="post" id="writeform">
		<div class="container" role="main">

			<h2>글쓰기</h2>

			<div class="mb-3">

				<label for="title">제목</label> <input type="text"
					class="form-control" name="boardtitle" id="boardtitle"
					placeholder="제목을 입력해 주세요">

			</div>

			<div class="mb-3">

				<label for="reg_id">작성자</label> <input type="text"
					class="form-control" value="${user.nickname}"
					placeholder="이름을 입력해 주세요" id="nickname" readonly>

			</div>

			<div class="mb-3">

				<label for="content">내용</label>

				<textarea id="boardcontent" name="boardcontent"></textarea>

			</div>

			<div>

				<input type="submit" class="btn btn-sm btn-primary" id="btnSave"
					value="저장" />
				<input type="button" class="btn btn-sm btn-primary" id="btnList" value="목록"/>

			</div>
		</div>
	</form>
</section>
<%@ include file="../include/footer.jsp"%>
<script src="/resources/scripts/write.js"></script>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

<!-- include libraries(jQuery, bootstrap) -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.15/dist/summernote.min.js"></script>
<!-- include summernote-ko-KR -->
<script src="/resources/summernote/summernote-ko-KR.js"></script>
<section>
	<form method="post" id="boardupdate">
		<div class="container" role="main">

			<h2>글쓰기</h2>

			<div class="mb-3">

				<label for="title">제목</label> <input type="text"
					class="form-control" name="boardtitle" id="boardtitle"
					value="${board.boardtitle }">

			</div>

			<div class="mb-3">

				<label for="reg_id">작성자</label> <input type="text"
					class="form-control" value="${board.nickname}"
					placeholder="이름을 입력해 주세요" id="nickname" readonly>

			</div>

			<div class="mb-3">

				<label for="content">내용</label>

				<textarea id="boardcontent" name="boardcontent">${board.boardcontent }</textarea>

			</div>

			<div>

				<input type="submit" class="btn btn-sm btn-primary" id="btnupdate"
					value="수정" />
				<input type="button" class="btn btn-sm btn-primary" id="btnList" value="목록"/>

			</div>
		</div>
	</form>
</section>
<%@ include file="../include/footer.jsp"%>
<script src="/resources/scripts/update.js"></script>
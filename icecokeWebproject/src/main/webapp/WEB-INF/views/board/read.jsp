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
	<form method="post" id="readupdate">
		<div class="container" role="main">
			<input type="text" id ="boardnum" value="${boardread.boardnum}" style="visibility:hidden"/>
			<h3>글 상세보기</h3>
			<p>${msg }</p>
			
			<div class="mb-3">

				<label for="title">글제목</label> <input type="text"
					class="form-control" value="${boardread.boardtitle }"
					name="boardtitle" id="boardtitle" readonly>


			</div>

			<div class="mb-3">

				<label for="reg_id">작성자</label> <input type="text"
					class="form-control" value="${boardread.nickname}" readonly>

			</div>

			<div class="mb-3">

				<label for="content">내용</label>
<%-- 				<textarea id ="boardcontent" >${boardread.boardcontent }</textarea> --%>
				<textarea id ="boardcontent" name="boardcontent" >${boardread.boardcontent }</textarea>
			</div>

			<div>
				<button type="button" class="btn btn-sm btn-primary" id="btnList">목록</button>
				
				<c:if test="${boardread.nickname eq user.nickname}">
					<input type="button" value="수정하기" style="visibility: visible"
						id="btnupdate" class="btn btn-sm btn-success" />
					<input type="button" value="삭제하기" style="visibility: visible"
						id="btndelete" class="btn btn-sm btn-success" />
				</c:if>
				<input type="submit" value="완료" style="visibility: hidden"
					id="submitupdate" class="btn btn-sm btn-success" />
			</div>
		</div>
	</form>
</section>

<%@ include file="../include/footer.jsp"%>
<script src="/resources/scripts/read.js"></script>

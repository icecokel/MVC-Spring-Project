<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<section>
	<form method="post"  id="boardform">
		<div class="container" role="main">

			<h2>글쓰기</h2>

			<div class="mb-3">

				<label for="title">제목</label> 
				<input type="text" class="form-control" name="boardtitle" id="boardtitle"
					placeholder="제목을 입력해 주세요">

			</div>

			<div class="mb-3">

				<label for="reg_id">작성자</label> 
				<input type="text" class="form-control" value="${user.nickname}"
					placeholder="이름을 입력해 주세요">

			</div>

			<div class="mb-3">

				<label for="content">내용</label>
				<textarea class="form-control" rows="5" name="boardcontent"
					id="boardcontent" placeholder="내용을 입력해 주세요"></textarea>

			</div>

			<div>

				<input type="submit" class="btn btn-sm btn-primary" id="btnSave" value = "저장"/>
				<button type="button" class="btn btn-sm btn-primary" id="btnList">목록</button>

			</div>
		</div>
	</form>
</section>
<%@ include file="../include/footer.jsp"%>

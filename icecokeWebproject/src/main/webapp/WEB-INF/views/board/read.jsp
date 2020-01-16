<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp"%>
<script type="text/javascript" src="//code.jquery.com/ui/1.11.1/jquery-ui.js">
</script>
<section>
	<form method="post" id="readupdate">
		<div class="container" role="main">

			<h2>글 상세 보기</h2>

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
				<textarea class="form-control" rows="5" name="boardcontent"
					id="boardcontent" readonly>${boardread.boardcontent }</textarea>

			</div>

			<div>
				<button type="button" class="btn btn-sm btn-primary" id="btnList">목록</button>
				<c:if test="${boardread.nickname eq user.nickname}">
					<input type="button" value="수정하기" style="visibility: visible"
						id="btnupdate" class="btn btn-sm btn-success" />
					<input type="button" value="삭제하기" style="visibility: visible"
						id="btndelete" class="btn btn-sm btn-success" />


					<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
					<script src="/resources/jquery/jquery-ui.js"></script>
					<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
					<div id="dialog-confirm" title="삭제?" style="display: none;">
						<p>정말로 삭제하시겠습니까?</p>
					</div>


				</c:if>
				<input type="submit" value="완료" style="visibility: hidden"
					id="submitupdate" class="btn btn-sm btn-success" />
			</div>
		</div>
	</form>
</section>

<%@ include file="../include/footer.jsp"%>
<script src="/resources/bootstrap/js/read.js"></script>
<script>
var btndelete = document.getElementById("btndelete");
btndelete.addEventListener("click", function() {
	$("#dialog-confirm").dialog( {
		resizable : false,
		height : "auto",
		width : 400,
		modal : true,
		buttons : {
			"삭제" : function() {
				$(this).dialog("close");
				location.href = "/board/delete/${vo.bno}";
			},
			"취소" : function() {
				$(this).dialog("close");
			}
		}
	});
});

</script>

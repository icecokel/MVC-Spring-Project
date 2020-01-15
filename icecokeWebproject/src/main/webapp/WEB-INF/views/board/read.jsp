<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp"%>
<section>
	<form method="post" id="readupdate">
		<div class="container" role="main">

			<h2>글 상세 보기</h2>

			<div class="mb-3">

				<label for="title">글제목</label> <input type="text"
					class="form-control" value="${boardread.boardtitle }" name ="boardtitle" id ="boardtitle" readonly>


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
			      <input type="button" value ="수정하기" style="visibility:visible" id ="btnupdate"class="btn btn-sm btn-success"/>
				</c:if>
				<input type="submit" value ="완료" style="visibility:hidden" id ="submitupdate" class="btn btn-sm btn-success"/>
			</div>
		</div>
	</form>
</section>

<%@ include file="../include/footer.jsp"%>

<script>


	var btnList = document.getElementById("btnList");
	
	btnList.addEventListener("click", function(e) {
		location.href = "/board/list";
	});
	
	var btnupdate = document.getElementById("btnupdate");
	var submitupdate = document.getElementById("submitupdate");
	
	var boardtitle = document.getElementById("boardtitle");
	var boardcontent = document.getElementById("boardcontent");

	
	btnupdate.addEventListener("click" , function(e){
		btnupdate.style.visibility="hidden";
		submitupdate.style.visibility ="visible";
		$("#boardtitle").attr("readonly", false);
		$("#boardcontent").attr("readonly",false);
		
	});
	
	
	var readupdate = document.getElementById("readupdate");
	
	readupdate.addEventListener("submit", function(e){
		
	})


	
</script>
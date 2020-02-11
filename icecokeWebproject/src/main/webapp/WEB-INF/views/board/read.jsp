<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

<style>
#commentdiv {
	font-size: 12px;
}
#dispdate{
}
#commentcontent,#comment{ display: inline;
width : 90%;
}
#comcontent {
	font-size : 14px;
	
}
</style>
<section>
	
		<div class="container" role="main">

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
				<div>${boardread.boardcontent }</div>
			</div>

			<div>
				<button type="button" class="btn btn-sm btn-primary" id="btnList">목록</button>

				<c:if test="${boardread.nickname eq user.nickname}">
					<a href="/update/${boardread.boardnum }"><input type="button"
						value="수정하기" style="visibility: visible" id="btnupdate"
						class="btn btn-sm btn-success" /></a>
					<input type="button" value="삭제하기" style="visibility: visible"
						id="btndelete" class="btn btn-sm btn-success" />
				</c:if>
			</div>
			<br/>  
			<div id ="comcnt"></div>
			<c:if test="${user != null}">
			<div>
				<input type="text" class="form-control"id ="commentcontent" name ="commentcontent"placeholder="내용을 입력하세요"/>
				<input type="button" value="댓글입력" id ="btncommentwrite"class="btn btn-sm btn-primary"/> 
			</div>
			</c:if>
			<div>
				<div id="commentlist"> </div>
				
 			</div>
 			
		</div>
	
</section>

<script>
 var boardnum = ${boardread.boardnum};
</script>

<%@ include file="../include/footer.jsp"%>
<script src="/resources/scripts/read.js"></script>

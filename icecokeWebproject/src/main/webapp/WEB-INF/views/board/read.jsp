<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

<style>
#commentdiv {
	font-size: 12px;
}
</style>
<section>
	
		<div class="container" role="main">
			<input type="text" id="boardnum" value="${boardread.boardnum}"
				style="visibility: hidden" />
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

			<div>
				<table id="commentdiv">
					<thead>
						<tr>
							<th colspan="3" width="900px"><b>댓글 (${commentcnt })</b></th>
						</tr>
					</thead>
					<tbody>
						<tr><td><br/></td></tr>
						<tr>
							<td width="2%"> </td>
							<td width="96%"><textarea rows="2" cols="150" id="comment"></textarea></td>
							<td width="2%" align="right"><input type="button" value="댓글달기" id="btncomment" /></td>
						
						</tr>
						<tr>
							<td><br/></td>
						</tr>
					</tbody>
					
					<tfoot>
						<c:forEach var="comments" items="${comments }">
						<tr>
							<td ></td>
							<td ><b>${comments.email } &nbsp;&nbsp;</b><br />
								<p>&nbsp;&nbsp;${comments.commentcontent } </p>
								<p> 답글 &nbsp; 수정 &nbsp; 삭제</p>
							</td>
							<td width="3%" align="right">${comments.dispdate }</td>
						</tr>
						</c:forEach>
					</tfoot>
				</table>
			</div>
		</div>
	
</section>

<%@ include file="../include/footer.jsp"%>
<script src="/resources/scripts/read.js"></script>

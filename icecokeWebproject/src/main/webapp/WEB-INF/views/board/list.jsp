<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

<section>
	<div class="filelistdiv">
		<table class="table">
			<thead>
				<tr>
					<td><a href="/board/write"><input type="button"
							value="글쓰기" /></a></td>
				</tr>
				<tr>
					<th scope="col" width="5%">글번호</th>
					<th scope="col" width="70%" style="text-align: center">글 제목</th>
					<th scope="col" width="10%">작성자</th>
					<th scope="col" width="10%">수정일</th>
					<th scope="col" width="5%">조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="boardDto" items="${boardlist }">
					<tr>
						<td>${boardDto.boardnum }</td>
						<td><a href="/read/${boardDto.boardnum}">${boardDto.boardtitle }</a></td>
						<td>${boardDto.nickname }</td>
						<td>${boardDto.dispdate }</td>
						<td>${boardDto.boardreadcnt }</td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</section>

<%@ include file="../include/footer.jsp"%>
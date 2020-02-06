<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

<section>
	<div class="filelistdiv">
		<table class="table">
			<thead>
				<tr>
					<td><a href="/board/write"><input type="button"
							value="글쓰기" class="btn btn-primary" /></a></td>
					<td><a href="/file/exceldownload.xls"><input type="button"
							value="엑셀출력" class="btn btn-success" /></a></td>
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
		<div align ='center'>
			<c:forEach var="i" begin="1" end="${boardcnt}">
				<a href ="/board/list?page=${i }"><input type="button" value="${i}"/></a>
			</c:forEach>
		</div>
	</div>
</section>

<%@ include file="../include/footer.jsp"%>
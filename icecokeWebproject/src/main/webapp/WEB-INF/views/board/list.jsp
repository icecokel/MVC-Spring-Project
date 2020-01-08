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
					<th scope="col" width="70%" style="text-align:center">글 제목</th>
					<th scope="col" width="10%">글쓴이</th>
					<th scope="col" width="10%">수정일</th>
					<th scope="col" width="5%">조회수</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th scope="row">1</th>
					<td>Mark</td>
					<td>Otto</td>
					<td>@mdo</td>
					<td>1</td>
				</tr>

			</tbody>
		</table>
	</div>
</section>

<%@ include file="../include/footer.jsp"%>
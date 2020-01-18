<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<section>
	<div class="filelistdiv">
		<table class="table">
			<tr>
				<th colspan="2"style="text-align: center" ><h3>파일 리스트</h3></th>
			</tr>
			<tr>
				<td width="50%" style="text-align: center">파일 업로드</td>
				<td width="50%" style="text-align: center">파일 다운로드</td>
			</tr>
			<tr >
				<td><iframe src="fileupload" width="100%" height="100%"></iframe></td>
				<td><iframe src="filedownload" width="100%" height="100%"></iframe></td>
			</tr>

		</table>
	</div>
</section>
<%@ include file="../include/footer.jsp"%>
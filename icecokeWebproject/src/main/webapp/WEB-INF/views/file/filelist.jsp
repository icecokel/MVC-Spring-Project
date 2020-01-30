<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<section>
	<div class="filelistdiv">


		<div align ="center">
			<h2>파일 리스트</h2>
		</div>
		<div>
			<a href="/file/fileupload" ><input type="button" value="파일 업로드" class="btn btn-primary"/></a>
		</div>
		<div align ="center">
			<span style="text-align: center; color: #212529;">파일 다운로드</span> <br />
			<div><iframe src="filedownload" width="100%" height="500px"></iframe>
			</div>
		</div>
	</div>
</section>
<%@ include file="../include/footer.jsp"%>
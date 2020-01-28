<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<section>
	<div class="filelistdiv">

		
		<div>
			<h3>파일 리스트</h3>
		</div>
		<div style="text-align:center; color:red;"> ${msg}</div>
		<span style="text-align: center">파일 업로드</span> 
		 
		<span> <iframe src="fileupload" width="100%" height="100%"></iframe>
		<span style="text-align: center">파일 다운로드</span> <br />
		</span> <span> <iframe src="filedownload" width="100%" height="100%"></iframe>
		</span>
	</div>
</section>
<%@ include file="../include/footer.jsp"%>
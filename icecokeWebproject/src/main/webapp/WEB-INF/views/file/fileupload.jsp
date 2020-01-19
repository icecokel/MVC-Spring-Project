<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
@import url(//fonts.googleapis.com/earlyaccess/jejugothic.css);

.filelistdiv {
	font-family: 'Jeju Gothic', sans-serif;
}
</style>
<section>
	<div>
		<form method="post" enctype="multipart/form-data" >
			<input type="file" multiple="multiple" id="files" name ="files"><br/>

			<div ><textarea id="filelist" readonly></textarea></div>
			<input type="submit" value="업로드"/>
		</form>
	</div>
</section>

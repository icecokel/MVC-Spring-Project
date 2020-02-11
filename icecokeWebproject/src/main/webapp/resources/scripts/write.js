let writeform = document.getElementById("writeform");
let nickname = document.getElementById("nickname");
let btnList = document.getElementById("btnList");

btnList.addEventListener("click", function(e) {
	location.href = "/board/list";
});

writeform.addEventListener("submit", function(e) {
	if (nickname.value.length < 1) {

		alert("게시글은 로그인 하셔야 사용 하실수 있습니다.");

		location.href = "/user/login";
		e.preventDefault();
		return;
	}

});
$(document).ready(function() {
	$('#boardcontent').summernote({
		  toolbar: [
			    ['style', ['bold', 'italic', 'underline', 'clear']],
			    ['font', ['strikethrough', 'superscript', 'subscript']],
			    ['fontsize', ['fontsize']],
			    ['color', ['color']],
			    ['para', ['ul', 'ol', 'paragraph']],
			    ['height', ['height']]
			  ],
		placeholder : 'content',
		minHeight : 370,
		maxHeight : null,
		focus : true,
		disableDragAndDrop: true,
		lang : 'ko-KR'
	});
});


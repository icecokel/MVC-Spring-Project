let btnList = document.getElementById("btnList");

btnList.addEventListener("click", function(e) {
	location.href = "/board/list";
});

let btnupdate = document.getElementById("btnupdate");
let submitupdate = document.getElementById("submitupdate");

let boardtitle = document.getElementById("boardtitle");
let boardcontent = document.getElementById("boardcontent");

btnupdate.addEventListener("click", function(e) {
	btnupdate.style.visibility = "hidden";
	submitupdate.style.visibility = "visible";
	$("#boardtitle").attr("readonly", false);
	$("#boardcontent").attr("readonly", false);

});

let btndelete = document.getElementById("btndelete");
let boardnum = document.getElementById("boardnum");
btndelete.addEventListener("click", function(e) {
	let result = confirm("정말 삭제 하시겠습니까?");

	if (result == true) {
		alert("게시글이 삭제 되었습니다.");
		location.href = "/board/delete/" + boardnum.value;
	}

})

$(document).ready(function() {
	$('#boardcontent').summernote({
		placeholder : 'content',
		minHeight : 370,
		maxHeight : null,
		focus : true,
		lang : 'ko-KR'
	});
});
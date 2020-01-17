var btnList = document.getElementById("btnList");

btnList.addEventListener("click", function(e) {
	location.href = "/board/list";
});

var btnupdate = document.getElementById("btnupdate");
var submitupdate = document.getElementById("submitupdate");

var boardtitle = document.getElementById("boardtitle");
var boardcontent = document.getElementById("boardcontent");

btnupdate.addEventListener("click", function(e) {
	btnupdate.style.visibility = "hidden";
	submitupdate.style.visibility = "visible";
	$("#boardtitle").attr("readonly", false);
	$("#boardcontent").attr("readonly", false);

});

var btndelete = document.getElementById("btndelete");
var boardnum = document.getElementById("boardnum");
btndelete.addEventListener("click", function(e){
	var result = confirm("정말 삭제 하시겠습니까?");

	if(result == true){
		alert("게시글이 삭제 되었습니다.");
		location.href="/board/delete/"+boardnum.value;
	}
	
})
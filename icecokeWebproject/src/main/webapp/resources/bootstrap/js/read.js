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

btndelete.addEventListener("click", function(e){

	// 여기 눌렀을때 진짜 삭제하는지 경고 메시지 .
	//dialog 사용 할꺼이ㅣㅁ.
	
	$.ajax({
		// 삭제 POST로 보내는 거 짜야함.
		
	})
	
});


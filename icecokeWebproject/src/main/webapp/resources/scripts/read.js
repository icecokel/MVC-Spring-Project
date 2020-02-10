
let btnList = document.getElementById("btnList");

btnList.addEventListener("click", function(e) {
	location.href = "/board/list";
});

let btndelete = document.getElementById("btndelete");



btndelete.addEventListener("click", function(e) {
	let result = confirm("정말 삭제 하시겠습니까?");
	
	
	if (result === true) {
		alert("게시글이 삭제 되었습니다.");
		location.href = "/board/delete/" + boardnum;
	}

});

let commentlist = document.getElementById("commentlist");

var method = {
	commentlistload(){
	
	$.ajax({
	
		url : 'commentlist?boardnum='+ boardnum,
		data : 'json',
		success : function(data){

			
		}
	})
	}
}


// 참고 자료.
//https://freehoon.tistory.com/115?category=735500
//	https://blog.naver.com/choch92/221762793713
//		https://blog.naver.com/ffiwe/221754038905
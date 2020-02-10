
let btnList = document.getElementById("btnList");

btnList.addEventListener("click", function(e) {
	location.href = "/board/list";
});

let btndelete = document.getElementById("btndelete");

if (btndelete != null){
	btndelete.addEventListener("click", function(e) {
		let result = confirm("정말 삭제 하시겠습니까?");
		
		
		if (result === true) {
			alert("게시글이 삭제 되었습니다.");
			location.href = "/board/delete/" + boardnum;
		}
	
	});
}
let commentlist = document.getElementById("commentlist");

function commentlistload(){
	var request=new XMLHttpRequest();
	request.open('GET','/commentlist?boardnum='+boardnum);
	request.send('');

	request.onreadystatechange = function() {
		// 정상 응답이 오면
		if (request.readyState == 4) {
			if (request.status >= 200 && request.status < 300) {
				// 읽어온 데이터를 변수에 저장
				let obj = request.responseText;
				// json 문자열을 파싱
				let json = JSON.parse(obj);

				let htmls ="";
				
				json.forEach(function(data){
					htmls+="<div id='commentdiv'>";
					htmls+="<b>"+data.nickname+"</b>"+""+"<br/>";
					htmls+="<p>"+data.commentcontent+"     "+data.dispdate+"</p>";
					htmls+="답장 "+"수정 "+"삭제  "; 
					htmls+="</div>";
					htmls+="<br/>";
				});
				commentlist.innerHTML = htmls;


			}
		}
	}


}


$(document).ready(function(){
	commentlistload();
	
});



// 참고 자료.
// https://freehoon.tistory.com/115?category=735500
// https://blog.naver.com/choch92/221762793713
// https://blog.naver.com/ffiwe/221754038905

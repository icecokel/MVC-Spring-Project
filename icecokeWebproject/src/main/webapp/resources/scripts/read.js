let btnList = document.getElementById("btnList");
let comcnt = document.getElementById("comcnt");
btnList.addEventListener("click", function(e) {
	location.href = "/board/list";
});

let btndelete = document.getElementById("btndelete");

if (btndelete != null) {
	btndelete.addEventListener("click", function(e) {
		let result = confirm("정말 삭제 하시겠습니까?");

		if (result === true) {
			alert("게시글이 삭제 되었습니다.");
			location.href = "/board/delete/" + boardnum;
		}

	});
}
let commentlist = document.getElementById("commentlist");

function commentlistload() {
	let request = new XMLHttpRequest();
	request.open('GET', '/commentlist?boardnum=' + boardnum);
	request.send('');

	request.onreadystatechange = function() {
		// 정상 응답이 오면
		if (request.readyState == 4) {
			if (request.status >= 200 && request.status < 300) {
				// 읽어온 데이터를 변수에 저장
				let obj = request.responseText;
				// json 문자열을 파싱
				let json = JSON.parse(obj);

				let htmls = "";

				json.forEach(function(data) {
					htmls += "<div id='commentdiv'>";
					htmls += "<b>" + data.nickname + "</b>" + "&nbsp;&nbsp;"
							+ data.dispdate + "<br/>";
					htmls += "<p class='comcontent'id='comcontent"+data.commentnum+"'>" + "&nbsp;&nbsp;"
							+ data.commentcontent + "</p>" + "<br/>";
					htmls += "답장 ";
					htmls += "<a href='#'><span onclick='commentupdate("
							+ data.commentnum + ")'>수정 </span></a>";
					htmls += "<a href='#'><span onclick='commentdel("
							+ data.commentnum + ")'>삭제 </span></a>";
					htmls += "</div>";
					htmls += "<div id='comupddiv" + data.commentnum + "'>";
					htmls += "</div>";
					htmls += "<br/>";
				});
				commentlist.innerHTML = htmls;

			}
		}
	}
}
function commentdel(comnum) {
	let comdel = confirm("댓글을 삭제 할까요?");

	if (comdel == true) {
		$.ajax({
			url : '/commentdel',
			dataType : 'json',
			type : 'POST',
			data : {
				"comnum" : comnum
			},
			success : function(data) {
				if (data.result === 'true') {
					alert("댓글이 삭제 되었습니다.");
					commentlistload();
					commentcnt();
				} else if (data.result == "email") {
					alert("댓글은 작성자만 삭제 할 수 있습니다.");
				} else {
					alert("댓글 삭제를 실패 했습니다. 다시 시도 부탁드립니다.");
				}
			},
			error : function() {
				alert("서버와의 통신이 원활하지 않습니다.")
			}

		})
	}
}
function commentupdate(comnum) {
	let comcontent = document.getElementById("comcontent"+comnum);
	let divid = document.getElementById("comupddiv" + comnum);
	let htmls = "<input type='text'class='form-control'id ='comment'/>"
			+ "<input type='button' value ='수정완료' id ='commentupdatebtn'class='btn btn-sm btn-primary'/>";

	divid.innerHTML = htmls;
	let comment = document.getElementById("comment");
	let commentupdatebtn = document.getElementById("commentupdatebtn");
	

	commentupdatebtn.addEventListener("click", function(e) {

		$.ajax({
			url : "/commentupdate",
			dateType : 'json',
			type : 'POST',
			data : {
				"comnum" : comnum,
				"comment" : comment.value
			},
			success : function(data) {
				if (data.result === 'true') {
					alert("댓글이 수정 되었습니다.");
					commentlistload();
					commentcnt();
				} else if (data.result == "email") {
					alert("댓글은 작성자만 수정 할 수 있습니다.");
				} else {
					alert("댓글 수정에 했습니다. 다시 시도 부탁드립니다.");
				}
			},
			error : function() {
				alert("서버와의 통신이 원활하지 않습니다.")
			}
		})
	})

}

function commentcnt() {
	let htmls = "";

	$.ajax({
		url : '/commentcnt?boardnum=' + boardnum,
		data : 'json',
		success : function(data) {
			htmls += "<b>" + "댓글(" + data.comcnt + ")</b><br/>";
			comcnt.innerHTML = htmls;
		}

	})

}

$(document).ready(function() {
	commentlistload();
	commentcnt();
});

let btncommentwrite = document.getElementById("btncommentwrite");
let commentcontent = document.getElementById("commentcontent");
if (btncommentwrite != null) {
	btncommentwrite.addEventListener("click", function(e) {
		if (commentcontent.value.trim().length <= 0) {
			return;
			alert("내용을 입력하세요.");
		}

		$.ajax({
			url : '/commentwrite',
			type : 'POST',
			dataType : 'json',
			data : {
				"boardnum" : boardnum,
				"commentcontent" : commentcontent.value
			},
			success : function(data) {
				if (data.result === 'true') {
					commentcontent.value = "";
					commentlistload();
					commentcnt();
				}
			}
		})
	});
}

// 참고 자료.
// https://freehoon.tistory.com/115?category=735500
// https://blog.naver.com/choch92/221762793713
// https://blog.naver.com/ffiwe/221754038905

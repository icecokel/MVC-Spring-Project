var writeform =document.getElementById("writeform");
var nickname = document.getElementById("nickname");


writeform.addEventListener("submit", function(e){
	if(nickname.value.length <1){
		
		alert("게시글은 로그인 하셔야 사용 하실수 있습니다.");
		
		location.href = "/user/login";
		e.preventDefault();
		return;
	}
	
	
});
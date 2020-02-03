let passwordchangebtn =document.getElementById("passwordchangebtn");

passwordchangebtn.addEventListener("click", function(e){
	location.href="/user/passwordchange";
});

let profilenickname = document.getElementById("profilenickname");
let nicknamecheck = false;

profilenickname.addEventListener('focusout', function(e) {
	if (profilenickname.value.trim().length < 1) {
		return;
	}
	// jquery의 ajax
	$.ajax({
		url : 'nicknamecheck?nickname=' + profilenickname.value,
		data : 'json',
		success : function(data) {
			if (data.result === 'true') {
				nicknamecheck = true;
				nicknamedisp.innerHTML = '&nbsp;&nbsp;사용 가능한 닉네임';
				nicknamedisp.style.color = 'green';
			} else {
				nicknamecheck = false;
				nicknamedisp.innerHTML = '&nbsp;&nbsp;사용 중인 닉네임';
				nicknamedisp.style.color = 'red';
			}
		}
	});
});





let profileform = document.getElementById("profileform");

let btnsecession = document.getElementById("btnsecession");

btnsecession.addEventListener("click", function(e){
	let result = confirm("정말 탈퇴 하시겠습니까?");
	
	if(result == true){
		alert("탈퇴가 진행 되었습니다. 그 동안 서비스를 이용해 주셔서 감사합니다.");
		location.href = "/user/secession";
	};
	
});


//이미지 파일의 선택이 변경되면 호출
document.getElementById("image").addEventListener("change", function(e) {
	//선택한 파일이 있다면
	//이벤트 처리할 때는 this가 이벤트가 발생한 객체입니다.
	//자바스크립트에서는 	null이 아니면 true로 간주합니다.	
	if (this.files && this.files[0]) {
		//파일의 내용 읽기
		var reader = new FileReader();
		//console.log(reader)

		//파일을 읽는 동작은 비동기적으로 동작
		reader.readAsDataURL(this.files[0]);
		//파일을 읽는 동작이 끝나면 img 태그에 출력하도록 설정
		reader.addEventListener("load", function(e) {
			document.getElementById("img").src = e.target.result;
		});
	}
});
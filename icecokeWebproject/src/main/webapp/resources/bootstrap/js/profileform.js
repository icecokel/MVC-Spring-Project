var passwordchangebtn =document.getElementById("passwordchangebtn");

passwordchangebtn.addEventListener("click", function(e){
	location.href="/user/passwordchange";
});

var profilenickname = document.getElementById("profilenickname");
var nicknamecheck = false;

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





var profileform = document.getElementById("profileform");
profileform.addEventListener("submit", function(e){
	
})
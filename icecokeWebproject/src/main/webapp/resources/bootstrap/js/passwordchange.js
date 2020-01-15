var mainbtn = document.getElementById("mainbtn");

mainbtn.addEventListener("click", function(e) {
	location.href = "/"
})

var logincheckflag = false;

var inputemail = document.getElementById("inputemail");
var inputpassword = document.getElementById("inputpassword");

var userverificationbtn = document.getElementById("userverificationbtn");

userverificationbtn.addEventListener("click", function(e){
	
	
});


// Ajax 참고 .
//nickname.addEventListener('focusout', function(e) {
//	if (nickname.value.trim().length < 1) {
//		return;
//	}
//	// jquery의 ajax
//	$.ajax({
//		url : 'nicknamecheck?nickname=' + nickname.value,
//		data : 'json',
//		success : function(data) {
//			if (data.result === 'true') {
//				nicknamecheck = true;
//				nicknamedisp.innerHTML = '&nbsp;&nbsp;사용 가능한 닉네임';
//				nicknamedisp.style.color = 'green';
//			} else {
//				nicknamecheck = false;
//				nicknamedisp.innerHTML = '&nbsp;&nbsp;사용 중인 닉네임';
//				nicknamedisp.style.color = 'red';
//			}
//		}
//	});
//});




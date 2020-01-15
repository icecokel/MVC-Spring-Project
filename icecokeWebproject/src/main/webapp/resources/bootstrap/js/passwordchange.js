var mainbtn = document.getElementById("mainbtn");

mainbtn.addEventListener("click", function(e) {
	location.href = "/"
})

var logincheckflag = false;

var inputemail = document.getElementById("inputemail");
var inputpassword = document.getElementById("inputpassword");

var userverificationbtn = document.getElementById("userverificationbtn");

var pw = document.getElementById("pw");
var pw2 = document.getElementById("pw2");
var btnchangepw = document.getElementById("btnchangepw");

var userverificationdiv = document.getElementById("userverificationdiv");
var msgidsp = document.getElementById("msgidsp");

userverificationbtn.addEventListener("click", function(e) {
	if (inputemail.value.length <= 0) {
		return;
	}
	if(inputemail.value )
	$.ajax({
		url : '/user/verification',
		type : 'POST',
		dataType : 'json',
		data : {
			"inputemail" : inputemail.value,
			"inputpassword" : inputpassword.value
		},
		success : function(data) {
			if (data.result === 'true') {
				$("#pw").attr("readonly", false);
				$("#pw2").attr("readonly", false);
				$("#btnchangepw").attr("disabled", false);

				msgidsp.innerHTML = "본인인증 성공";
				userverificationdiv.style.visibility = "hidden";
			} else {
				alert("실패");
			}
		}
	})

});

var pwcheckflag = false;
var pwcheckflag2 = false;

pw.addEventListener("keyup",function(e){

	var pwValue = pw.value.trim();

	var passRule = /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;

	if (passRule.test(pwValue)) {
		msgidsp.innerHTML = '&nbsp;&nbsp; 비밀번호 강도 강함!';
		msgidsp.style.color = 'green';
		pwcheckflag2 =true;
	} else {
		msgidsp.innerHTML = '&nbsp;&nbsp; 비밀번호 강도 약함!';
		msgidsp.style.color = 'red';
		pwcheckflag2 =false;
	}

	
});

pw2.addEventListener("keyup", function(e) {
	if (pw.value != pw2.value) {
		msgidsp.innerHTML = "비밀번호가 일치하지 않습니다.";
		pwcheckflag = false;
	} else {
		msgidsp.innerHTML = "비밀번호가 일치합니다.";
		pwcheckflag = true;
	}

});


var passwordchangeform = document.getElementById("passwordchangeform");

passwordchangeform.addEventListener("submit", function(e) {
	if (pwcheckflag == false || pwcheckflag2 == false) {
		msgidsp.innerHTML = "비밀번호를 확인해 주세요.";
		pw.focus();
		e.preventDefault();
		return;
	}
});
let emailcheck = false;
let nicknamecheck = false;

let email = document.getElementById("email");
let nickname = document.getElementById("nickname");

let emaildisp = document.getElementById("emaildisp");
let nicknamedisp = document.getElementById("nicknamedisp");

let endemail = document.getElementById("endemail");
let endemailtextfield = document.getElementById("endemailtextfield");
let emailcheckvalue ="";
// 반복되는 기능을 매소드로 선언 하여, 호출하기 위함.
var method = {
	emailmethod(){
		
		// email에 입력한 내용이 없으면 중복 검사를 수행하지 않음
		if (email.value.trim().length < 1) {
			return;
		}
		// 순수 자바스크립트로 ajax 구현
		// ajax 요청 객체 생성
		let request = new XMLHttpRequest();
		
		if(endemail == "etcemail"){
			emailcheckvalue = email.value ;
		}else{
			emailcheckvalue = email.value + endemail.value;
		}
		
		console.log(emailcheckvalue);
		
		// 요청 주소 생성
		request.open('GET', 'emailcheck?email=' + emailcheckvalue );
		// 요청
		request.send('');
		// ajax 콜백 함수 등록
		request.onreadystatechange = function() {
			// 정상 응답이 오면
			if (request.readyState == 4) {
				if (request.status >= 200 && request.status < 300) {
					// 읽어온 데이터를 변수에 저장
					let obj = request.responseText;
					// json 문자열을 파싱
					let json = JSON.parse(obj);
					if (json.result === "true") {
						emailcheck = true;
						emaildisp.innerHTML = '&nbsp;&nbsp;사용 가능한 이메일';
						emaildisp.style.color = 'green';
						
					} else {
						emailcheck = false;
						emaildisp.innerHTML = '&nbsp;&nbsp;이미 존재하는 이메일';
						emaildisp.style.color = 'red';
					}
				}
			}
		}
	}	
}


// 이미지 파일의 선택이 변경되면 호출
document.getElementById("image").addEventListener("change", function(e) {
	// 선택한 파일이 있다면
	// 이벤트 처리할 때는 this가 이벤트가 발생한 객체입니다.
	// 자바스크립트에서는 null이 아니면 true로 간주합니다.
	if (this.files && this.files[0]) {
		// 파일의 내용 읽기
		var reader = new FileReader();
		// console.log(reader)

		// 파일을 읽는 동작은 비동기적으로 동작
		reader.readAsDataURL(this.files[0]);
		// 파일을 읽는 동작이 끝나면 img 태그에 출력하도록 설정
		reader.addEventListener("load", function(e) {
			document.getElementById("img").src = e.target.result;
		});
	}
});

// 직접 입력을 선택했을 때 진행할 기능 구현
endemail.addEventListener('change', function(e) {
	if (endemail.value == "etcemail") {
		endemail.style.visibility = "hidden";

	}
	
	method.emailmethod();
});
// email 입력 란에서 포커스가 떠나면
email.addEventListener('focusout', function(e) {
	if (endemail.value == "etcemail" ) {
		if(email.value.indexOf('@') <= 0 || email.value.indexOf('.') <= 0){
			emaildisp.innerHTML = "이메일 형식이 잘못되었습니다."
			emaildisp.style.color = 'red';
			email.focus();
			e.preventDefault();
			return;
		}else{
			method.emailmethod();
		}
					

	// 매소드를 호출하여 간단하게 기능 구현.
	}else{
		method.emailmethod();
	}
});

// 닉네임 중복 검사
nickname.addEventListener('focusout', function(e) {
	if (nickname.value.trim().length < 1) {
		return;
	}
	// jquery의 ajax
	$.ajax({
		url : 'nicknamecheck?nickname=' + nickname.value,
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

let pw = document.getElementById("pw");
let pw1 = document.getElementById("pw1");

let pwdisp = document.getElementById("pwdisp");
let passwordcheck = false;
// 비밀번호 강도 정규식
pw.addEventListener(
				"keyup",
				function(e) {
					let pwVlaue = pw.value.trim();

					let passRule = /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;

					if (passRule.test(pwVlaue)) {
						pwdisp.innerHTML = '&nbsp;&nbsp; 비밀번호 강도 강함!';
						pwdisp.style.color = 'green';
					
					} else {
						pwdisp.innerHTML = '&nbsp;&nbsp; 비밀번호 강도 약함!';
						pwdisp.style.color = 'red';
					}

				});

pw1.addEventListener('focusout', function(e) {
	if (pw.value.trim() != "" && pw1.value.trim() != "") {
		if (pw.value != pw1.value) {
			passwordcheck = false;
			pwdisp.innerHTML = '&nbsp;&nbsp;비밀번호가 일치하지 않습니다.';
			pwdisp.style.color = 'red';
		} else {

			passwordcheck = true;
			pwdisp.innerHTML = '&nbsp;&nbsp;비밀번호가 일치합니다.';
			pwdisp.style.color = 'green';

		}
	}

});

let phone = document.getElementById("phone");
let phonedisp = document.getElementById("phonedisp");
let phonecheck = false;
let joinform = document.getElementById("joinform");

phone.addEventListener("focusout", function(e) {
	if (phone.value.length <= 11 && phone.value.length >= 10) {
		// 전화번호 길이 유효성 검사 / true 라면

		for (let i = 0; i < phone.value.length; i = i + 1) {
			let ch = phone.value.charAt(i);

			if (ch < '0' || ch > '9') {
				phonecheck = false;
				break;
				phonedisp.innerHTML = "전화번호를 확인하세요!";
				phonedisp.style.color = 'red';
			}

			phonecheck = true;
			phonedisp.innerHTML = "";
			phonedisp.style.color = 'green';

		}
	} else {
		phonecheck = false;
		phonedisp.innerHTML = "전화번호를 확인하세요!";
		phonedisp.style.color = 'red';
	}

})
let givenewpwA = document.getElementById("givenewpwA");

joinform.addEventListener("submit", function(e) {
	
		email.value = emailcheckvalue;
	
	
	if (phonecheck == false) {
		phonedisp.innerHTML = "전화번호는 10 ~ 11자리 이하 숫자로만 작성되어야 합니다.";
		phonedisp.style.color = 'red';
		phone.focus();
		e.preventDefault();
		return;

	}

	if (passwordcheck == false) {
		pwdisp.innerHTML = "비밀번호가 일치 하지 않거나 , 보안에 취약합니다."
		pwdisp.style.color = 'red';
		// 비밀번호 강도 추가하면 추가 진행.
		pw1.focus();
		e.preventDefault();
		return;

	}
	if (emailcheck == false) {
		emaildisp.innerHTML = "이메일 확인이 필요합니다."
		emaildisp.style.color = 'red';
		email.focus();
		e.preventDefault();
		return;
	}

	if (nicknamecheck == false) {
		nicknamedisp.innerHTML = "닉네임 확인이 필요합니다."
		nicknamedisp.style.color = 'red';
		nickname.focus();
		e.preventDefault();
		return;
	}
	
	if(givenewpwA.value.length <=0){
		givenewpwAdisp.innerHTML = "답변을 기재해 주세요."
		givenewpwAdisp.style.color = 'red';
		givenewpwA.focus();
		e.preventDefault();
		return;
	}
	

});

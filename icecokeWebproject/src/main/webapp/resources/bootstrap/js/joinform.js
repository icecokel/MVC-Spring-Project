	var emailcheck = false;
	var nicknamecheck = false;

	var email = document.getElementById("email");
	var nickname = document.getElementById("nickname");

	var emaildisp = document.getElementById("emaildisp");
	var nicknamedisp = document.getElementById("nicknamedisp");

	//email 입력 란에서 포커스가 떠나면
	email.addEventListener('focusout', function(e) {
		//email에 입력한 내용이 없으면 중복 검사를 수행하지 않음
		if (email.value.trim().length < 1) {
			return;
		}
		//순수 자바스크립트로 ajax 구현
		//ajax 요청 객체 생성
		var request = new XMLHttpRequest();
		//요청 주소 생성
		request.open('GET', 'emailcheck?email=' + email.value);
		//요청
		request.send('');
		//ajax 콜백 함수 등록
		request.onreadystatechange = function() {
			//정상 응답이 오면
			if (request.readyState == 4) {
				if (request.status >= 200 && request.status < 300) {
					//읽어온 데이터를 변수에 저장
					var obj = request.responseText;
					//json 문자열을 파싱
					var json = JSON.parse(obj);
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

	});

	//닉네임 중복 검사
	nickname.addEventListener('focusout', function(e) {
		if (nickname.value.trim().length < 1) {
			return;
		}
		//jquery의 ajax
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

	var pw = document.getElementById("pw");
	var pw1 = document.getElementById("pw1");

	var pwdisp = document.getElementById("pwdisp");
	var passwordcheck = false;
	pw1.addEventListener('focusout', function(e) {
		if (pw.value.trim() != "" && pw1.value.trim() != "") {
			if (pw.value != pw1.value) {
				passwordcheck = false;
				pwdisp.innerHTML = '&nbsp;&nbsp;비밀번호가 일치하지 않습니다.';
				pwdisp.style.color = 'red';
			} else {
				passwordcheck = true;
				pwdisp.innerHTML = '&nbsp;&nbsp;사용 가능한 비밀번호 입니다.';
				pwdisp.style.color = 'green';

				/* 비밀번호 강도 조절 로직 들어가면 좋을 듯, */
			}
		}

	});

	var phone = document.getElementById("phone");
	var phonecheck = false;
	var phonedisp = document.getElementById("phonedisp");
	var phonedispori = document.getElementById("phonedisp").innerHTML;
	phone.addEventListener("focusout", function(e) {
		if (phone.value.trim() > 12) {
			phonecheck = false;
		}else{
			phonecheck = true;
		}
	})
	
	
	var joinform = document.getElementById("joinform");
	
	joinform.addEventListener("submit", function (e){
		
		if (phonecheck == false){
			phonedisp.innerHTML = "전화번호는 11자리 이하 숫자로만 작성되어야 합니다.";
			phonedisp.style.color ='red';
			
		}
		
		if(passwordcheck == false){
			pwdisp.innerHTML = "비밀번호가 일치 하지 않거나 , 부적잘한 형식의 비밀번호 입니다."
			pwdisp.style.color ='red';
//	비밀번호 강도 추가하면 추가 진행.
			
		}
		if(emailcheck == false){
			emaildisp.innerHTML = "이메일 확인이 필요합니다."
			emaildisp.style.color ='red';
		}
		
		if(nicknamecheck == false){
			nicknamedisp.innerHTML ="닉네임 확인이 필요합니다."
			nicknamedisp.style.color = 'red';
		}
		
		
		
	});
	
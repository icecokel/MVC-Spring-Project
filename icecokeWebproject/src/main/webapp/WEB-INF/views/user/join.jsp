<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>


<section class="content">
	<!-- action이 생략되면 이전 요청을 그대로 사용 : user/join
	파일 업로드를 할 때는 enctype 을 설정 -->
	<form method="post" enctype="multipart/form-data" id="joinform">
		<p align="center">
		<table border="1" align="center" width="60%" height="400">
			<tr>
				<td colspan="3" align="center">
					<h3>회원가입</h3>
				</td>
			</tr>

			<tr>
				<td rowspan="8" align="center">
					<p>사진 파일을 업로드 하세요</p> <img id="img" width="100" height="100"
					border="1" /><br /> <input type="file" id="image" name="image"
					accept=".jpg,.jpeg,.gif,.png" /> <br />
				</td>
			</tr>
			<tr>
				<td bgcolor="#f5f5f5">&nbsp;&nbsp;이메일</td>
				<td>&nbsp;&nbsp; <input type="email" id="email" name="email"
					size="40" required="required" />
					<div id ="emaildisp"></div>
				</td>

				
			</tr>

			<tr>
				<td bgcolor="#f5f5f5">&nbsp;&nbsp;비밀번호</td>
				<td>&nbsp;&nbsp; <input type="password" id="pw" name="pw"
					size="40" required="required" />
				</td>
			</tr>
			<tr>
				<td bgcolor="#f5f5f5">&nbsp;&nbsp;비밀번호확인</td>
				<td>&nbsp;&nbsp; <input type="password" id="pw1" size="40"
					required="required" />
				</td>
			</tr>
			<tr>
				<td bgcolor="#f5f5f5">&nbsp;&nbsp;이름</td>
				<td>&nbsp;&nbsp; <input type="text" id="name" name="name"
					size="40" required="required" />
				</td>
			</tr>
			<tr>
				<td bgcolor="#f5f5f5">&nbsp;&nbsp;별명</td>
				<td>&nbsp;&nbsp; <input type="text" id="nickname"
					name="nickname" size="40" required="required" />
					<div id ="nicknamedisp"> </div>
				</td>

				
			</tr>

			<tr>
				<td bgcolor="#f5f5f5">&nbsp;&nbsp;전화번호</td>
				<td>&nbsp;&nbsp; <input type="text" id="phone" name="phone"
					size="20" />
					<p>&nbsp;&nbsp; -를 제외하고 입력</p>
				</td>
			</tr>

			<tr>
				<td bgcolor="#f5f5f5">&nbsp;&nbsp;취미</td>
				<td>&nbsp;&nbsp; <input type="checkbox" name="hobby"
					value="sports" />운동&nbsp; <input type="checkbox" name="hobby"
					value="game" />게임&nbsp; <input type="checkbox" name="hobby"
					value="reading" />독서&nbsp; <input type="checkbox" name="hobby"
					value="computer" />컴퓨터&nbsp; <input type="checkbox" name="hobby"
					value="mountain" />등산&nbsp;
				</td>
			</tr>

			<tr>
				<td colspan="3" align="center">
					<p></p> <input type="submit" value="회원가입" class="btn btn-warning" />

					&nbsp;&nbsp; <input type="button" value="메인으로"
					class="btn btn-primary" id="mainbtn" />
				</td>
			</tr>

		</table>
		</p>
	</form>
</section>
<!-- footer.jsp 포함 -->
<%@ include file="../include/footer.jsp"%>
<script>
	//메인으로 버튼을 눌렀을 때 메인으로 이동하도록 설정
	document.getElementById("mainbtn").addEventListener("click", function(e) {
		//시작 페이지로 이동
		location.href = "/";
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
</script>


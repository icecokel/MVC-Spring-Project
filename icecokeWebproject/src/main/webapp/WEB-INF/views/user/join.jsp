<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>


<section class="content">
	<!-- action이 생략되면 이전 요청을 그대로 사용 : user/join
	파일 업로드를 할 때는 enctype 을 설정 -->
	<form method="post" enctype="multipart/form-data" id="joinform">
		<div class="joinformdiv">
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th colspan="3">
						<h3 align="center"> 계정 생성 페이지 </h3>
					</th>
				</tr>
			</thead>
			<tbody>
<!-- 				<tr>
					<td rowspan="8" align="center">
						<p>사진 파일을 업로드 하세요</p> 
						<img id="img" class="rounded-circle" width = "300" height = "300" /><br/>
						<input type="file" id="image" name="image" accept=".jpg,.jpeg,.gif,.png" /> <br />
					</td>
				</tr> -->
				<tr>
					<td>&nbsp;&nbsp;이메일</td>
					<td>&nbsp;&nbsp; <input type="email" id="email" name="email"
						size="40" required="required" />
						<div id="emaildisp"></div>
					</td>

				</tr>

				<tr>
					<td>&nbsp;&nbsp;비밀번호</td>
					<td>&nbsp;&nbsp; <input type="password" id="pw" name="pw"
						size="40" required="required" />
					</td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;비밀번호확인</td>
					<td>&nbsp;&nbsp; <input type="password" id="pw1" size="40"
						required="required" />
						<div id="pwdisp"></div>
					</td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;이름</td>
					<td>&nbsp;&nbsp; <input type="text" id="name" name="name"
						size="40" required="required" />
					</td>
				</tr>
				<tr>
					<td>&nbsp;&nbsp;별명</td>
					<td>&nbsp;&nbsp; <input type="text" id="nickname"
						name="nickname" size="40" required="required" />
						<div id="nicknamedisp"></div>
					</td>


				</tr>

				<tr>
					<td>&nbsp;&nbsp;전화번호</td>
					<td>&nbsp;&nbsp; <input type="text" id="phone" name="phone"
						size="20" />
						<p id=phonedisp>&nbsp;&nbsp; -를 제외하고 입력</p>
					</td>
				</tr>
				<!-- 
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
 -->
				<tr>
					<td>&nbsp;&nbsp;생년월일</td>
					<td>&nbsp;&nbsp; <select id="year" name="year">
							<c:forEach var="i" begin="1970" end="2020">
								<option value="${i}">${i}</option>
							</c:forEach>
					</select> <select id="month" name="month">
							<c:forEach var="i" begin="1" end="12">
								<option value="${i}">${i}</option>
							</c:forEach>
					</select> <select id="day" name="day">
							<c:forEach var="i" begin="1" end="31">
								<option value="${i}">${i}</option>
							</c:forEach>
					</select></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="3" align="center">
						<p></p> <input type="submit" value="회원가입" class="btn btn-warning" />

						&nbsp;&nbsp; <input type="button" value="메인으로"
						class="btn btn-primary" id="mainbtn" />
					</td>
				</tr>
			</tfoot>
		</table>
</div>
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
</script>
<script src="/resources/bootstrap/js/joinform.js"></script>

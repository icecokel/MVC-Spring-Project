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
							<h3 align="center">계정 생성 페이지</h3>
						</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td rowspan="9" align="center">
							<p>사진 파일을 업로드 하세요</p> <img id="img" class="rounded-circle"
							width="300" height="300" /><br /> <input type="file" id="image"
							name="image" accept=".jpg,.jpeg,.gif,.png" /> <br />
						</td>
					</tr>
					<tr>
						<td>&nbsp;&nbsp;이메일</td>
						<td>&nbsp;&nbsp; 
						<input type="text" id="email" name="email"
							size="30" required="required" />
							<select id="endemail" name="endemail" style="visibility :visible">
									<option value="@naver.com">naver.com</option>
									<option value="@daum.net">daum.net</option>
									<option value="@gmail.com">gmail.com</option>
									<option value="@coke.com">coke.com</option>
									<option value="etcemail">직접 입력</option>
								</select>
							
								<!-- <input type="text" id= "endemailtextfield" style="visibility :hidden" placeholder="사용하시는 메일을 적어주세요"/> -->
							
							<div id="emaildisp"></div>
							
						</td>

					</tr>

					<tr>
						<td>&nbsp;&nbsp;비밀번호</td>
						<td>&nbsp;&nbsp; 
						<input type="password" id="pw" name="pw"
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
					<tr>
					<td>&nbsp;&nbsp;비밀번호 재발급 질문</td>
						<td>
							<div>
								<select id="givenewpwQ" name="givenewpwQ">
									<option value="1.내 첫 입학 초등학교는?">1.내 첫 입학 초등학교는?</option>
									<option value="2.가장 좋아하는 색깔은?">2.가장 좋아하는 색깔은?</option>
									<option value="3.초등학교시절 장래 희망은?">3.초등학교시절 장래 희망은?</option>
									<option value="4.처음 키운 애완동물이름은?">4.처음 키운 애완동물이름은?</option>
								</select>
								<input type="text" id ="givenewpwA" name = "givenewpwA"  placeholder="답변을 입력해주세요!"/>
							</div>
							<div id ="givenewpwAdisp">
							
							</div>
						</td>
	
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
<script src="/resources/scripts/join.js"></script>

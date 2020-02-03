<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<section>
	<div align='center' class="joinformdiv">
		<div>
			<h3>회원 정보 수정</h3>

		</div>
		<!--  이미지 수정 기능 추가해야함. -->
		<form method="post" enctype="multipart/form-data" id="profileform">
			<table border="1" class="table">
				<thead>
					<tr align="center">
						<td colspan="2"><img src="/userimage/${user.image}"
							width="40px" height="40px" /> ${user.nickname}'s Profile</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>이메일</td>

						<td><input id="profileemail" name="profileemail" type="text"
							value="${user.email}" readonly></td>

					</tr>
					<tr>
						<td>이름</td>

						<td><input type="text" value="${user.name}" readonly></td>
					</tr>
					<tr>
						<td>닉네임</td>

						<td><input id ="profilenickname" name="profilenickname" type="text"
							value="${user.nickname}">
							<div id="nicknamedisp"></div></td>
					</tr>



					<tr>
						<td>비밀번호</td>
						<td><input id="passwordchangebtn" type="button"
							value="비밀번호 변경하기" />
							
							
							</td>
					</tr>

					<tr>
						<td>전화번호</td>

						<td><input name="profilephone" type="text"
							value="${user.phone}" />
					</tr>

					<tr>
						<td>임시비밀번호 발급</td>
						<td><select name="profilegivenewpwQ">
								<option value="1.내 첫 입학 초등학교는?">1.내 첫 입학 초등학교는?</option>
								<option value="2.가장 좋아하는 색깔은?">2.가장 좋아하는 색깔은?</option>
								<option value="3.초등학교시절 장래 희망은?">3.초등학교시절 장래 희망은?</option>
								<option value="4.처음 키운 애완동물이름은?">4.처음 키운 애완동물이름은?</option>

						</select> <input name="profilegivenewpwA" type="text"
							value="${user.givenewpwA}"></td>

					</tr>
				</tbody>

				<tfoot>
					<tr align='center'>
						<td colspan="2">
						<input type="submit" value="회원정보 수정하기" /> 
						<input type="button" value="회원 탈퇴하기" id ="btnsecession"/></td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
</section>
<%@ include file="../include/footer.jsp"%>
<script src="/resources/scripts/profile.js"></script>

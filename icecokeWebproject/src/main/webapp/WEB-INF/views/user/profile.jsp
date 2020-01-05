<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<section>
	<div align='center' class="joinformdiv">
		<div>
			<h3>회원 정보 수정</h3>
		</div>
		<form method="post">
			<table align="center" border="2" class="table">
				<thead>
					<tr align="center">
						<td colspan="2"><img src="${user.image}" width="40px"
							height="40px" /> ${user.nickname}'s Profile</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>이메일</td>

						<td><input type="text" value="${user.email}" readonly></td>

					</tr>
					<tr>
						<td>이름</td>

						<td><input type="text" value="${user.name}" readonly></td>
					</tr>
					<tr>
						<td>닉네임</td>

						<td><input type="text" value="${user.nickname}"></td>
					</tr>
					<tr>
						<td>비밀번호</td>

						<td><input type="password" value="${user.password}"><input
							type="button" value="비밀번호 변경하기" /></td>


					</tr>
					<tr>
						<td>비밀번호 확인</td>

						<td><input type="password"></td>
					</tr>
					<tr>
						<td>전화번호</td>

						<td>${user.phone}</td>
					</tr>

					<tr>
						<td>임시비밀번호 발급</td>
						<td><input type="text" value="${user.givenewpwQ}"> <input
							type="text" value="${user.givenewpwA}"></td>

					</tr>


				</tbody>

				<tfoot>
					<tr align='center'>
						<td colspan="2"
						><input type="submit" value="회원정보 수정하기" /> 
						<input type="button" value="회원 탈퇴하기" /></td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
</section>
<%@ include file="../include/footer.jsp"%>
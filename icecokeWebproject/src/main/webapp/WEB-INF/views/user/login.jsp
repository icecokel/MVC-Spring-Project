<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<section>
	<div>
		<div class="logindiv">
			<form method="post">
				<div style='color: red'>${msg}</div>
				<div class="form-group">
					<label for="exampleInputEmail1">Email</label> <input type="email"
						class="form-control" name="inputemail"
						aria-describedby="emailHelp" placeholder="email을 입력하세요">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">비밀번호</label> <input
						type="password" class="form-control" name="inputpassword"
						placeholder="비밀번호를 입력하세요">
				</div>

				<button type="submit" class="btn btn-primary btn-lg btn-block">로그인</button>
			</form>
		</div>
	</div>
</section>
<%@ include file="../include/footer.jsp"%>
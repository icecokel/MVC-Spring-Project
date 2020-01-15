<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>


<div>
	<div class="logindiv">
	<h2>비밀번호 변경 페이지</h2>
			<div style='color: red'>${msg}</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Email</label> <input type="email"
					class="form-control" name="inputemail" id="inputemail" aria-describedby="emailHelp"
					placeholder="email을 입력하세요">
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">비밀번호</label> <input
					type="password" class="form-control" name="inputpassword" id ="inputpassword"
					placeholder="비밀번호를 입력하세요">
			</div>

			<button type="button" class="btn btn-primary btn-lg btn-block" id="userverificationbtn">본인
				인증</button>
			<br />
	</div>

	<div class="logindiv" >
		<label>비밀번호</label> <input type="password" id=pw class="form-control" disabled="disabled"> 
		<label>비밀번호확인</label> <input type="password" id=pw2  class="form-control"disabled="disabled">
			
		<input type="submit" value ="비밀번호 변경하기"  class="btn btn-primary btn-lg btn-block "  disabled="disabled" />
		<input type="button" value ="메인으로." id ="mainbtn" class="btn btn-primary btn-lg btn-block " />
	</div>
</div>
<%@ include file="../include/footer.jsp"%>
<script src="/resources/bootstrap/js/passwordchange.js"></script>

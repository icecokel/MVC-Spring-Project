<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<section>
	<div>
		<div class="logindiv">
			<form method="post" enctype="enctype">
			<div style='color: red'>${msg}</div>
								<div class="form-group">
					<input type="email"
						class="form-control" name="email"
						aria-describedby="emailHelp" placeholder="email을 입력하세요">
				</div>
				<div class="form-group">
					<select class="form-control" id ="givenewpwQ" name="givenewpwQ">
						<option value="1.내 첫 입학 초등학교는?">1.내 첫 입학 초등학교는?</option>
						<option value="2.가장 좋아하는 색깔은?">2.가장 좋아하는 색깔은?</option>
						<option value="3.초등학교시절 장래 희망은?">3.초등학교시절 장래 희망은?</option>
						<option value="4.처음 키운 애완동물이름은?">4.처음 키운 애완동물이름은?</option>
					</select>
				</div>
					
				<div >
					<input type="text" id ="givenewpwA" name = "givenewpwA" class="form-control" placeholder="답변을 입력해주세요!"/>
				</div>
				<div>
				<br/>
					<button type="submit"  class="btn btn-primary btn-lg btn-block">비밀번호 재발급 받기</button>
				</div>
				<br>
				<div>
					<a href="/"><input type="button" value="메인으로" class="btn btn-primary btn-lg btn-block"></a>				
				</div>
			</form>
		</div>
	</div>
</section>

<%@ include file="../include/footer.jsp"%>

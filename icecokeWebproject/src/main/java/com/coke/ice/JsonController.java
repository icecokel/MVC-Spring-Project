package com.coke.ice;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.coke.ice.service.UserService;

@RestController
public class JsonController {

	@Autowired
	private UserService userService;

	// 이메일 중복검사를 위한 메소드
	@RequestMapping(value = "user/emailcheck", method = RequestMethod.GET)
	public Map<String, Object> checkemail(HttpServletRequest request) {
		
		boolean result = userService.checkemail(request);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result + "");
		return map;

	}
	// email 이라는 파라미터를 email 이라는 문자열 변수에 저장

	// nicknamecheck 요청을 처리할 메소드
	// 파라미터를 Service에 읽도록 했기 때문에 매개변수가
	// HttpServletRequest
	@RequestMapping(value = "user/nicknamecheck", method = RequestMethod.GET)
	public Map<String, Object> checknickname(HttpServletRequest request) {
		boolean result = userService.checknickname(request);
		Map<String, Object> map = new HashMap<String, Object>();
//		System.err.println(result);
		
		map.put("result", result + "");
		return map;

	}
}
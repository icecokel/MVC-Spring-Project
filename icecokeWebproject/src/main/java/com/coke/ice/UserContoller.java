package com.coke.ice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.coke.ice.service.UserService;

@Controller
public class UserContoller {
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value = "/user/login", method = RequestMethod.GET)
	public String login (Model model) {
		
		return "/user/login";
	}
	
	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	public String login (Model model, HttpServletRequest request, RedirectAttributes attr) {
		boolean result = userService.login(request);
		if(result == true) {
			return "redirect:/";
			
		}else {
			attr.addFlashAttribute("msg" ,"없는 아이디 이거나 틀린 비밀번호 입니다.");
			return "redirect:/user/login";
		}
		
	}
	
	@RequestMapping(value="user/logout" , method=RequestMethod.GET)
	public String logout(HttpSession session ,RedirectAttributes attr) {
		// 로그아웃 처리 - 세션을 초기화 해도되고, 세선에서 user만 초기화 해도됨.
		session.invalidate();
//		session.removeAttribute("user");
		attr.addFlashAttribute("msg", "로그아웃 하셨습니다.");
		
		return "redirect:/";
	}
	

	
}

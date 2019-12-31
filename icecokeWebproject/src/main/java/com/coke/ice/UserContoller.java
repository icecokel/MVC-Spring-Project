package com.coke.ice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
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
	
	@RequestMapping (value="/user/join" , method= RequestMethod.GET)
	public String join (Model model) {
		
		return "/user/join";
	}
	// 회원가입을 처리하는 메소드
	@RequestMapping (value="user/join" , method = RequestMethod.POST)
	public String join (MultipartHttpServletRequest request , RedirectAttributes attr) {
		userService.userjoin(request);
		
		attr.addFlashAttribute("msg" , "회원가입을 성공했습니다.");
		
		return "redirect:login";
		
	}
	@RequestMapping (value="/user/plznewpw" , method = RequestMethod.GET)
	public String plznewpw (Model model) {
		
		return "/user/plznewpw";
	}
	
	@RequestMapping (value="/user/plznewpw" , method = RequestMethod.POST)
	public String plznewpw (Model model, HttpServletRequest request, RedirectAttributes attr) {
		boolean result = userService.newpassword(request);
		
		
		if (result == true) {
			attr.addFlashAttribute("msg" ,"비밀번호를 재발급 해드렸습니다."+"\n"+ userService.temppassword(10));
			
			
			
		}else {
			attr.addFlashAttribute("msg" ,"선택한 질문과 답이 일치 하지 않습니다.");
		}
		return "redirect:plznewpw";
	}
	
}

package com.coke.ice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.coke.ice.domain.IceUser;
import com.coke.ice.service.UserService;

@Controller
public class UserContoller {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/user/login")
	public String login (Model model) {
		
		return "/user/login";
	}
	
	@PostMapping("/user/login")
	public String login (Model model, HttpServletRequest request, RedirectAttributes attr) {
		boolean result = userService.login(request);
		if(result == true) {
			return "redirect:/";

			
		}else {
			attr.addFlashAttribute("msg" ,"없는 아이디 이거나 틀린 비밀번호 입니다.");
			return "redirect:/user/login";
		}
		
	}
	
	@GetMapping("user/logout")
	public String logout(HttpSession session ,RedirectAttributes attr) {

		session.invalidate();
//		session.removeAttribute("user");
		attr.addFlashAttribute("msg", "로그아웃 하셨습니다.");
		
		return "redirect:/";
	}
	
	@GetMapping("/user/join")
	public String join (Model model) {
		
		return "/user/join";
	}

	@PostMapping("user/join")
	public String join (MultipartHttpServletRequest request , RedirectAttributes attr) {
		userService.userjoin(request);
		
		attr.addFlashAttribute("msg" , "회원가입을 성공했습니다.");
		
		return "redirect:login";
		
	}
	@GetMapping("/user/plznewpw")
	public String plznewpw (Model model) {
		
		return "/user/plznewpw";
	}
	
	@PostMapping("/user/plznewpw")
	public String plznewpw (Model model, HttpServletRequest request, RedirectAttributes attr) {
		boolean result = userService.newpassword(request);
		String newpassword = userService.temppassword(10);
		String secunewpassword = BCrypt.hashpw(newpassword,BCrypt.gensalt(10));
		String email = request.getParameter("email");
		
		IceUser user = new IceUser();
		
		user.setEmail(email);
		user.setPassword(secunewpassword);
		
		
		if (result == true) {

			userService.newpassword2(request, user);
			attr.addFlashAttribute("msg" ,"비밀번호를 재발급 해드렸습니다."+"\n"+ newpassword);
			
			
			
		}else {
			attr.addFlashAttribute("msg" ,"선택한 질문과 답이 일치 하지 않습니다.");
		}
		return "redirect:plznewpw"; 
	}
	
	@GetMapping("/user/profile")
	public String profile (Model model) {
		
		return "/user/profile";
	}
	
	@PostMapping("/user/profile" )
	public String profile (Model model, MultipartHttpServletRequest request) {
		userService.editporifle(request);
		return "redirect:login";
	}
	
	@GetMapping("/user/passwordchange")
	public String passwordchange (Model model) {
		
		return "/user/passwordchange";
	}
	
	@PostMapping("/user/passwordchange")
	public String passwordchange (RedirectAttributes attr, HttpServletRequest request,HttpSession session) {
		String password = request.getParameter("password");
		String secupassword = BCrypt.hashpw(password, BCrypt.gensalt(10));
		String email = request.getParameter("inputemail");
		
		session.invalidate();
		
		IceUser user = new IceUser();
		user.setEmail(email);
		user.setPassword(secupassword);
		
		userService.newpassword2(request, user);
		attr.addFlashAttribute("msg","비밀번호 변경에 성공했습니다.");
		
		return "redirect:login";
	}
	
	
	@GetMapping("/user/secession")
	public String usersecession (HttpServletRequest request, HttpSession session) {
		userService.usersecession(request);
		
		session.invalidate();
		return "redirect:/";
	}

	

}

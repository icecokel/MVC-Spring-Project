package com.coke.ice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.coke.ice.domian.IceUser;

@Controller
public class UserContoller {
	
	@Autowired
	IceUser iceUser;
	
	@RequestMapping(value = "/user/login", method = RequestMethod.GET)
	public String login (Model model) {
		
		return "/user/login";
	}
	
}

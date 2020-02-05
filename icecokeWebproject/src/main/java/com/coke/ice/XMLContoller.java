package com.coke.ice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class XMLContoller {
	
	@RequestMapping (value="/xml/hanirss" , method=RequestMethod.GET)
	public String hanirss(Model model) {
		
		return "/xml/hanirss";
	}

}

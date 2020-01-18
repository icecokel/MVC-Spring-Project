package com.coke.ice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FileController {
	
	@RequestMapping(value = "file/filelist", method = RequestMethod.GET)
	public String filelist(Model model) {

		return "/file/filelist";
	}
	@RequestMapping(value = "file/filedownload", method = RequestMethod.GET)
	public String filedownload(Model model) {
		
		return "/file/filedownload";
	}
	@RequestMapping(value = "file/fileupload", method = RequestMethod.GET)
	public String fileupload(Model model) {
		
		return "/file/fileupload";
	}
}

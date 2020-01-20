package com.coke.ice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.coke.ice.service.FileService;


@Controller
public class FileController {
	
	@Autowired
	private FileService fileservice;
	
	
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
	@RequestMapping(value = "/file/fileupload", method = RequestMethod.POST)
	public String fileupload(Model model, MultipartHttpServletRequest request) {
		
		System.err.println("파일 컨트롤러" + request.toString());
		fileservice.fileupload(request);
		
		return "/file/fileupload";
	}
}

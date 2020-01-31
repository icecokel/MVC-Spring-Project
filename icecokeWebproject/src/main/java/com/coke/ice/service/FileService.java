package com.coke.ice.service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.coke.ice.domain.IceFile;

@Service
public interface FileService {
	public boolean fileupload(MultipartHttpServletRequest request);
	
	public List<IceFile> filedownload(HttpServletRequest request);
	
	public File filedown(HttpServletResponse response,int filenum);
		
}

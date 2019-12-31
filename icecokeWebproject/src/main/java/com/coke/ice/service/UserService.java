package com.coke.ice.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Service
public interface UserService {
	public boolean login(HttpServletRequest request);
	
	public boolean checkemail (HttpServletRequest email);
	
	public boolean checknickname (HttpServletRequest request);
	
	public void userjoin(MultipartHttpServletRequest request);
	
	public boolean newpassword(HttpServletRequest request);
	
	public String temppassword(int len);
	
	
}

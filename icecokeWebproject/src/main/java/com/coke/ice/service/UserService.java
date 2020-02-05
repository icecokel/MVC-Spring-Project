package com.coke.ice.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.coke.ice.domain.IceUser;

@Service
public interface UserService {
	public boolean login(HttpServletRequest request);
	
	public boolean checkemail (HttpServletRequest email);
	
	public boolean checknickname (HttpServletRequest request);
	
	public void userjoin(MultipartHttpServletRequest request);
	
	public boolean newpassword(HttpServletRequest request);
	
	public String temppassword(int len);
	
	public void newpassword2(HttpServletRequest request,IceUser user);
	
	public void editporifle(MultipartHttpServletRequest request);
	
	public boolean userverification(HttpServletRequest request); 
	
	public void usersecession(HttpServletRequest request);
	
	
}

package com.coke.ice.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
	public boolean login(HttpServletRequest request);
}
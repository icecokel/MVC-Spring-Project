package com.coke.ice.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

@Service
public interface FileService {
	public boolean fileupload(HttpServletRequest request);
}

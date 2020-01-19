package com.coke.ice.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Service
public interface FileService {
	public boolean fileupload(MultipartHttpServletRequest request);
}

package com.coke.ice.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coke.ice.dao.FileDAO;
import com.coke.ice.domain.IceFile;
@Service
public class FileSErviceImpl implements FileService {

	@Autowired
	FileDAO fileDao;
	
	@Override
	public boolean fileupload(HttpServletRequest request) {
		boolean result =false;
		
		   
		IceFile file = new IceFile();
		
		
		int r = fileDao.fileupload(file);
		
		if(r >=1) {
			result = true;
		}else {
			result = false;
		}
			
		
		
		return result;
	}

}

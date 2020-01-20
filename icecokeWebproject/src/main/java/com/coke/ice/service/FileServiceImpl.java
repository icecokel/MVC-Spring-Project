package com.coke.ice.service;

import java.util.UUID;

import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.coke.ice.dao.FileDAO;
import com.coke.ice.domain.IceFile;
import com.coke.ice.domain.IceUser;
@Service
public class FileServiceImpl implements FileService {

	@Autowired
	FileDAO fileDao;
	
	@Override
	public boolean fileupload(MultipartHttpServletRequest request) {
		System.out.println("플레그..");
		System.out.println("파일 서비스 ::::::" + request.toString());
		boolean result =false;
//		FTPClient ftp = new FTPClient();
		
		IceUser user = (IceUser)request.getSession().getAttribute("user");
		String email = user.getEmail();
		
		MultipartFile f =request.getFile("files");
		
		String filename = f.getOriginalFilename();
		String fileUUID = UUID.randomUUID().toString();
		String filesize = f.getSize()+"";
		IceFile file = new IceFile();
		
		file.setEmail(email);
		file.setFilename(filename);
		file.setFilesize(filesize);
		file.setFileUUID(fileUUID);
		
		
		
		// db에 상태 값 저장.
		int r = fileDao.fileupload(file);
		
		if(r >=1) {
			result = true;
		}else {
			result = false;
		}
			
		
		
		return result;
	}

}

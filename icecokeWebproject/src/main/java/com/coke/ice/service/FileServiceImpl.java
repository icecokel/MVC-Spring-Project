package com.coke.ice.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.UUID;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
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
	private FileDAO fileDao;
	
	FTPClient ftp = null;
	
	public FileServiceImpl() {
		String host = "icecoke.iptime.org";
		int port = 2222;
		String username = "root";
		String password = "qwe123!@#";
		
		
		ftp = new FTPClient();
		 ftp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
		 try {
			ftp.connect(host, port);
			ftp.login(username, password);
			ftp.setFileType(FTP.BINARY_FILE_TYPE);
	        ftp.enterLocalPassiveMode();
	        
	        System.out.println("연결성공");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("FTP 연결 예외."+e.getMessage());
			e.printStackTrace();
		}
		 
	}
	
	
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
		System.out.println("FTP 서비스:::::"+request.getSession().getServletContext().getRealPath("files"));
		// 파일이 서버에 저장될 디렉터리.		
		String filepath = "/home/WebProject/WebStorage/";
		// 서버에 전송할 파일 정보.
		InputStream input;
		// 전송할 파일의 전체 경로및 네임.
		String localfullname =request.getSession().getServletContext().getRealPath("files");
		try {
			input = new FileInputStream(new File(localfullname));
			try {
				ftp.storeFile(filepath + filename, input);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 업로드 기능 구현.
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(r >=1) {
			result = true;
		}else {
			result = false;
		}
		
		
		return result;
	}

}

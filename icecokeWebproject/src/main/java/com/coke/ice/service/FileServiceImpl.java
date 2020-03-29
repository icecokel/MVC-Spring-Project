package com.coke.ice.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.coke.ice.dao.FileDAO;
import com.coke.ice.dao.ServerDao;
import com.coke.ice.domain.IceFile;
import com.coke.ice.domain.IceServer;
import com.coke.ice.domain.IceUser;

@Service
public class FileServiceImpl implements FileService {

	@Autowired
	private FileDAO fileDao;

	@Autowired
	private ServerDao serverDao;
	
	FTPClient ftp = null;

	final String serverpath = "/home/WebStorage/";

	
	public void ftpconnect() {
		IceServer server =serverDao.server(1); 
		
		String host = server.getHost();
		int port = server.getPort();
		String username = server.getServerid();
		String password = server.getServerpw();
		
		ftp = new FTPClient();
		ftp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
		try {
			ftp.connect(host, port);
			ftp.login(username, password);
			ftp.setFileType(FTP.BINARY_FILE_TYPE);
			ftp.enterLocalPassiveMode();
			ftp.changeWorkingDirectory(serverpath);
			ftp.setControlEncoding("UTF-8");
			System.out.println("연결성공");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("FTP 연결 예외." + e.getMessage());
			e.printStackTrace();
		}
	};
	

	@Override
	public boolean fileupload(MultipartHttpServletRequest request) {
		ftpconnect();

		boolean result = false;


		IceUser user = (IceUser) request.getSession().getAttribute("user");
		String email = user.getEmail();

		MultipartFile f = request.getFile("files");

		String filename = f.getOriginalFilename();
		String fileUUID = UUID.randomUUID().toString();
		String filesize = f.getSize() + "";
		IceFile file = new IceFile();

		file.setEmail(email);
		file.setFilename(filename);
		file.setFilesize(filesize);
		file.setFileUUID(fileUUID);

		int r = fileDao.fileupload(file);

		InputStream input;
		try {

			try {
				input = f.getInputStream();
				ftp.storeFile(serverpath + fileUUID, input);

			} catch (IOException e) {

				e.printStackTrace();
			}
			// 업로드 기능 구현.
		} catch (Exception e) {

			e.printStackTrace();
		}

		if (r >= 1) {
			result = true;
		} else {
			result = false;
		}
		System.out.println("파일업로드 결과 ::::::" + result);
		  
		try {
			ftp.disconnect();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<IceFile> filedownload(HttpServletRequest request) {
		
		IceUser user = (IceUser) request.getSession().getAttribute("user");
		String email = user.getEmail();
		List<IceFile> files = fileDao.filedownload(email);
		int dispNum = 1;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for (IceFile tmp : files) {
			tmp.setDispNum(dispNum);
		double fileSize = Double.parseDouble(tmp.getFilesize());

			int level = 0;

			while (fileSize > 1024) {

				fileSize = fileSize / 1024;
				level++;
			}

			switch (level) {
			case 0: {
				tmp.setFilesize(String.format("%.2f", fileSize) + " byte");
				break;
			}

			case 1: {
				tmp.setFilesize(String.format("%.2f", fileSize) + " Kb");
				break;
			}

			case 2: {
				tmp.setFilesize(String.format("%.2f", fileSize) + " Mb");
				break;
			}
			case 3: {
				tmp.setFilesize(String.format("%.2f", fileSize) + " Gb");
			}
			}
			tmp.setDispdate(sdf.format(tmp.getFileUploaddate()));
			
			
		}
		return files;

	}

	@Override
	public File filedown(HttpServletResponse response, int filenum) {
		ftpconnect();

		IceFile icefile = fileDao.filedown(filenum);
		
		String fileUUID = icefile.getFileUUID();
		String filename = icefile.getFilename();
		

		InputStream is = null;
			
		File result = new File(filename);
		try {
			is = ftp.retrieveFileStream(fileUUID);

			FileUtils.copyInputStreamToFile(is, result);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(is != null) {
				try {
					is.close();
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				
			}
			try {
				ftp.disconnect();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		


		return result;
	}


	@Override
	public void filedelete(int filenum) {
		int r =fileDao.filemove(filenum);
		
		if(r > 0) {
			fileDao.filedelete(filenum);
		}
		
	}

}

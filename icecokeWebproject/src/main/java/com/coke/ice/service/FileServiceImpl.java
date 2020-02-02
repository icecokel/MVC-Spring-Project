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

	final String serverpath = "/home/WebProject/WebStorage/";

	
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
		// System.out.println("플레그..");
		// System.out.println("파일 서비스 ::::::" + request.toString());
		boolean result = false;
		// FTPClient ftp = new FTPClient();

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

		// System.out.println("인코딩 확인 " + filename);

		// db에 상태 값 저장.
		int r = fileDao.fileupload(file);
		// System.out.println("FTP
		// 서비스:::::"+request.getSession().getServletContext().getRealPath("files"));
		// 파일이 서버에 저장될 디렉터리.

		// 서버에 전송할 파일 정보.
		InputStream input;
		try {

			try {
				input = f.getInputStream();
				ftp.storeFile(serverpath + fileUUID, input);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 업로드 기능 구현.
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

		// https://jeong-pro.tistory.com/136 참고 소스
	}

	@Override
	public List<IceFile> filedownload(HttpServletRequest request) {
		
		IceUser user = (IceUser) request.getSession().getAttribute("user");
		String email = user.getEmail();
		List<IceFile> files = fileDao.filedownload(email);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for (IceFile tmp : files) {
		double fileSize = Double.parseDouble(tmp.getFilesize());

			int level = 0;
//			System.out.println(tmp.getFilename() +tmp.getFilesize());
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
//		System.out.println("파일 서비스 :::" + "FLAG");
		IceFile icefile = fileDao.filedown(filenum);
		
		String fileUUID = icefile.getFileUUID();
		String filename = icefile.getFilename();
		
//		System.out.println("파일 서비스 :: 파일 UUID " + fileUUID);
		InputStream is = null;
			
		File result = new File(filename);
		try {
			is = ftp.retrieveFileStream(fileUUID);
//			System.out.println("파일 서비스 :::2" + is.toString());
//			OutputStream output = new FileOutputStream(result);
//
//			IOUtils.copy(is, output);
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
		

		
//		System.out.println("파일 서비스 3:::" + result.toString());
		return result;
	}

}

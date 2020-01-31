package com.coke.ice.service;

import java.io.File;
import java.io.FileOutputStream;
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
import com.coke.ice.domain.IceFile;
import com.coke.ice.domain.IceUser;

@Service
public class FileServiceImpl implements FileService {

	@Autowired
	private FileDAO fileDao;

	FTPClient ftp = null;

	final String serverpath = "/home/WebProject/WebStorage/";

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
			ftp.changeWorkingDirectory(serverpath);
			ftp.setControlEncoding("UTF-8");
			System.out.println("연결성공");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("FTP 연결 예외." + e.getMessage());
			e.printStackTrace();
		}

	}

	@Override
	public boolean fileupload(MultipartHttpServletRequest request) {

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
			int fileSize = Integer.parseInt(tmp.getFilesize());

			int level = 0;
			while (fileSize > 1024) {

				fileSize = fileSize / 1024;
				level++;
			}

			switch (level) {
			case 0: {
				tmp.setFilesize(fileSize + " byte");
				break;
			}

			case 1: {
				tmp.setFilesize(fileSize + " Kbyte");
				break;
			}

			case 2: {
				tmp.setFilesize(fileSize + " Mbyte");
				break;
			}
			case 3: {
				tmp.setFilesize(fileSize + " Gbyte");
			}
			}
			tmp.setDispdate(sdf.format(tmp.getFileUploaddate()));
		}
		return files;

	}
//
//	@Override
//	public boolean filedown(HttpServletResponse response, int filenum) {
//		boolean result = false;
//
//		// System.out.println("서비스 ::::::::" + filenum);
//		IceFile icefile = fileDao.filedown(filenum);
//
//		// System.out.println("서비스 ::::::::" + icefile.toString());
//
//		String fileUUID = icefile.getFileUUID();
//		String filename = icefile.getFilename();
//		// 저장될 파일 경로
//		// String filepath = "C:\\Users\\coke\\Downloads\\Storage\\";
//		// File file = new File(filepath+filename);
//		// FileOutputStream output = null;
//		// System.out.println("서비스 ::::::::" + file.toString());
//		// try {
//		// output = new FileOutputStream(file);
//		// boolean r = ftp.retrieveFile(fileUUID, output);
//		// if(r) {
//		// result = true;
//		// }else {
//		// result = false;
//		// }
//		// System.out.println("서비스 ::::::::" + result);
//		// output.close();
//		// } catch (IOException e) {
//		// e.printStackTrace();
//		// }
//
//		OutputStream os = null;
//		InputStream is = null;
//		try {
//			// 아래 작업을 한번만 할 방법을 찾아보자.
//			os = response.getOutputStream();
//
//			// int length = -1;
//			// byte[] buffer = new byte[1024];
//			// try {
//			// while ((length = is.read(buffer)) > -1) {
//			// os.write(buffer, 0, length);
//			//
//			// }
//			//
//			// } catch (IOException e1) {
//			// result = false;
//			// e1.printStackTrace();
//			// }
//			// 브라우저가 출력하는 것이 아니라 파일 다운로드로 진행 하고 싶을 때 아래 둘 중 하나로 세
//			// response.setContentType("application/octet-stream");
//			// response.setContentType("application/application/download");
//			// os.write(buffer);
//			
//			response.setContentLength(Integer.parseInt(icefile.getFilesize()));
//			response.setHeader("Content-Transfer-Encoding", "binary");
//			try {
//				is = ftp.retrieveFileStream(fileUUID);
//				FileCopyUtils.copy(is, os);
//			} catch (Exception e1) {
//				e1.printStackTrace();
//			}
//
//			result = true;
//
//		} catch (Exception e) {
//			System.out.println("여기인가? ::::" + e.getMessage());
//			e.printStackTrace();
//
//			result = false;
//		} finally {
//			if (os == null) {
//				try {
//					os.flush();
//					os.close();
//					System.out.println("파일 다운로드 정상 진행 완료");
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//	
//			}
//			try {
//				response.flushBuffer();
//				ftp.disconnect();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//
//		return result;
//	}

	@Override
	public File filedown(HttpServletResponse response, int filenum) {
		System.out.println("파일 서비스 :::" + "FLAG");
		IceFile icefile = fileDao.filedown(filenum);
		
		String fileUUID = icefile.getFileUUID();
		
		InputStream is = null;


			
		File result = new File("");
		try {
			is = ftp.retrieveFileStream(fileUUID);
			System.out.println("파일 서비스 :::2" + is.toString());
		}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			FileUtils.copyInputStreamToFile(is, result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("파일 서비스 3:::" + result.toString());
		return result;
	}

}

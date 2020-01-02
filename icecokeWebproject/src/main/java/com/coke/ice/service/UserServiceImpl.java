package com.coke.ice.service;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.coke.ice.dao.UserDAO;
import com.coke.ice.domain.IceUser;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDao;

	@Override
	public boolean login(HttpServletRequest request) {
		boolean result = false;

		String email = request.getParameter("inputemail");
		String password = request.getParameter("inputpassword");

		IceUser user = userDao.login(email);

		request.getSession().removeAttribute("user");
		if (user != null) {
			if (BCrypt.checkpw(password, user.getPassword())) {

				user.setPassword(null);
				request.getSession().setAttribute("user", user);
				result = true;

			}
		}

		return result;
	}

	@Override
	public boolean checkemail(HttpServletRequest request) {
		boolean result = false;

		String email = request.getParameter("email");
		String r = userDao.checkemail(email);
		if (r == null) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}

	@Override
	public boolean checknickname(HttpServletRequest request) {
		boolean result = false;

		String nickname = request.getParameter("nickname");
		String r = userDao.checknickname(nickname);

		// System.err.println(nickname);
		// System.err.println(r);

		if (r == null) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}

	@Override
	public void userjoin(MultipartHttpServletRequest request) {
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String nickname = request.getParameter("nickname");
		String phone = request.getParameter("phone");

		String yyyy = request.getParameter("year");
		String MM = request.getParameter("month");
		String day = request.getParameter("day");
		int dd = Integer.parseInt(day) + 1;

		String givenewpwA = request.getParameter("givenewpwA");
		String givenewpwQ = request.getParameter("givenewpwQ");

		// System.err.println(yyyy);
		// System.err.println(MM);
		// System.err.println(dd);

		String birth = yyyy + "-" + MM + "-" + dd;

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Date birthday = null;

		try {

			birthday = sdf.parse(birth);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// System.err.print(phone);
//		System.err.println(birthday);

		MultipartFile f = request.getFile("image");
		
		String origiName = f.getOriginalFilename();
		String fileName = email + origiName;
		String path = request.getServletContext().getRealPath("/userimage");
		
		if (origiName.length() > 0) {
			File file = new File(path + "/" + fileName);
			try {
				f.transferTo(file);
				System.out.println("여긴가요ㅕ:" + f.toString());
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
				
				System.out.println("여기일것 같아");
			}
		} else {
			fileName = "default.png";
		}

		IceUser user = new IceUser();
		user.setEmail(email);
		user.setPassword(BCrypt.hashpw(pw, BCrypt.gensalt(10)));
		user.setName(name);
		user.setNickname(nickname);
		user.setPhone(phone);
		user.setBirthday(birthday);
		user.setImage(fileName);
		user.setGivenewpwA(givenewpwA);
		user.setGivenewpwQ(givenewpwQ);

		System.err.println(birthday);

		userDao.userjoin(user);

	}

	@Override
	public boolean newpassword(HttpServletRequest request) {
		boolean result = false;
		String email = request.getParameter("email");
		String givenewpwQ = request.getParameter("givenewpwQ");
		String givenewpwA = request.getParameter("givenewpwA");

		IceUser user = userDao.newpassword(email);
		if (user.getGivenewpwQ().equals(givenewpwQ) && user.getGivenewpwA().equals(givenewpwA)) {
			result = true;
		} else {
			result = false;
		}

		return result;
	}

	@Override
	public String temppassword(int len) {
		char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
				'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
		int idx = 0;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < len; i++) {
			idx = (int) (charSet.length * Math.random());
			// 36 * 생성된 난수를 Int로 추출 (소숫점제거) 
			sb.append(charSet[idx]); 
			} 
			
			return sb.toString();
		}

	@Override
	public void newpassword2(HttpServletRequest request ,String newpassword) {
		String email =request.getParameter("email");
		
		IceUser user =  new IceUser();
		user.setEmail(email);
		user.setPassword(newpassword);
		
		userDao.newpassword2(user);
		
		System.err.println(userDao.newpassword2(user));
		
	}
		
		

	

}

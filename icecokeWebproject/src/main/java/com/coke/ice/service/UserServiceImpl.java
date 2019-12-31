package com.coke.ice.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		if(user != null) {
			if(BCrypt.checkpw(password, user.getPassword())) {
				
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
		if(r == null) {
			result = true;
		}else {
			result = false;
		}
		return result;
	}


	@Override
	public boolean checknickname(HttpServletRequest request) {
		boolean result = false;
		
		String nickname = request.getParameter("nickname");
		String r = userDao.checknickname(nickname);
		
//		System.err.println(nickname);
//		System.err.println(r);
		
		if(r == null) {
			result = true;
		}else {
			result = false;
		}
		return result;
	}


	@Override
	public void userjoin(HttpServletRequest request) {
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String nickname = request.getParameter("nickname");
		String phone = request.getParameter("phone");
		String image = request.getParameter("image");
		if(image != null) {
			image = "default.png";
		}
		String yyyy = request.getParameter("year");
		String MM = request.getParameter("month");
		String dd = request.getParameter("day");
		
//		System.err.println(yyyy);
//		System.err.println(MM);
//		System.err.println(dd);
		
		
		String birth = yyyy+"-"+MM+"-"+dd;

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date birthday = null;
		
		try {
			
			birthday = sdf.parse(birth);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		System.err.print(phone);
		System.err.print(birthday);
		
		
		IceUser user = new IceUser();
		user.setEmail(email);
		user.setPassword(BCrypt.hashpw(pw, BCrypt.gensalt(10)));
		user.setName(name);
		user.setNickname(nickname);
		user.setPhone(phone);
		user.setBirthday(birthday);

		userDao.userjoin(user);
		
		
	}

}

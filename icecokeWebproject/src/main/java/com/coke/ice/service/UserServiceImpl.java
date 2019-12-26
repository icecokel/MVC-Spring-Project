package com.coke.ice.service;

import javax.servlet.http.HttpServletRequest;

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
			if(password.equals(user.getPassword())) {
				
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
		String r = userDao.checkemail(nickname);
		if(r == null) {
			result = true;
		}else {
			result = false;
		}
		return result;
	}

}

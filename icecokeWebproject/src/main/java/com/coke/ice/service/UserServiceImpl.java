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

}

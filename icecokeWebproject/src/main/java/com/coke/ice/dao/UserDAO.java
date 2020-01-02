package com.coke.ice.dao;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coke.ice.domain.IceUser;
@Repository
public class UserDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public IceUser login(String email) {
		
		return sqlSession.selectOne("usermapper.login", email);
	}
	
	
	public String checkemail(String email) {
		return sqlSession.selectOne("usermapper.checkemail",email);
	}
	
	
	public String checknickname(String nickname) {
		return sqlSession.selectOne("usermapper.checknickname",nickname);
	}
	
	public int userjoin(IceUser iceUser) {
		return sqlSession.insert("usermapper.userjoin", iceUser);
	}
	
	public IceUser newpassword (String email) {
		
		return sqlSession.selectOne("usermapper.newpassword", email);
	}
	public int newpassword2 (IceUser iceUser) {
		
		return sqlSession.update("usermapper.newpassword2", iceUser);
	}
}

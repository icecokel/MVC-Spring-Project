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
}

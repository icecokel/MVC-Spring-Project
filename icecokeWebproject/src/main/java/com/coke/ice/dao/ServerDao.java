package com.coke.ice.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coke.ice.domain.IceServer;

@Repository
public class ServerDao {
	
	@Autowired
	private SqlSession sqlsession;
	
	public IceServer server (int num) {
		return sqlsession.selectOne("accuntmapper.server", num);
	}
	
}

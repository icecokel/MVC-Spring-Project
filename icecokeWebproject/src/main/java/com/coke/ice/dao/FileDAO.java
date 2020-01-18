package com.coke.ice.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.coke.ice.domain.IceFile;

@Repository
public class FileDAO {
	private SqlSession sqlSession;
	
	public int fileupload(IceFile icefile) {
		return sqlSession.insert("filemapper.fileupload", icefile);
	}
}

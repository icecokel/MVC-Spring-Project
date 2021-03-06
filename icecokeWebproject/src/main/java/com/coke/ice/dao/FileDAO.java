package com.coke.ice.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coke.ice.domain.IceFile;

@Repository
public class FileDAO {
	@Autowired
	private SqlSession sqlSession;
	
	public int fileupload(IceFile icefile) {
		
		return sqlSession.insert("filemapper.fileupload", icefile);
	}
	public List<IceFile> filedownload(String email) {
		return sqlSession.selectList("filemapper.filedownload", email);
	}
	
	public IceFile filedown(int filenum){
		return sqlSession.selectOne("filemapper.filedown" ,filenum);
	}
	 
	public void filedelete(int filenum) {
		sqlSession.delete("filemapper.filedelete", filenum);
	}
	
	public int filemove(int filenum) {
		return sqlSession.insert("filemapper.filemove", filenum);
	}
}

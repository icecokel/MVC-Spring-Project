package com.coke.ice.dao;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coke.ice.domain.IceBoard;
import com.coke.ice.domain.IceComment;


@Repository
public class BoardDAO {
	@Autowired
	private SqlSession sqlSession;
	
	public int boardwrite(IceBoard iceBoard) {
		return sqlSession.insert("boardmapper.boardwrite", iceBoard);
	}
	public Integer maxnum() {
		return sqlSession.selectOne("boardmapper.maxnum");
	}
	
	public List<IceBoard> boardlist () {
		
		return sqlSession.selectList("boardmapper.boardlist");
	}
	
	public List<IceBoard> boardpage (int page){
		return sqlSession.selectList("boardmapper.boardpage", page);
	}
	
	public IceBoard boardread (int boardnum) {
		return sqlSession.selectOne("boardmapper.boardread",boardnum);
	}
	
	public void readcnt (int boardnum) {
		sqlSession.update("boardmapper.readcnt",boardnum);
	}
	
	public int boardupdate (IceBoard iceboard) {
		
		return sqlSession.update("boardmapper.boardupdate", iceboard);
	}
	public void boarddelete(int boardnum) {
		
		sqlSession.delete("boardmapper.boarddelete", boardnum);
	}
	
	public List<IceComment> commentlist (int boardnum){
		
		return sqlSession.selectList("boardmapper.commentlist", boardnum);
	}
}

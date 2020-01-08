package com.coke.ice.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coke.ice.domain.IceBoard;


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
}

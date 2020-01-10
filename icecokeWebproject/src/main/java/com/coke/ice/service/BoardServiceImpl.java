package com.coke.ice.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coke.ice.dao.BoardDAO;
import com.coke.ice.domain.IceBoard;
import com.coke.ice.domain.IceUser;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardDAO boardDao;

	@Override
	public boolean boardwrite(HttpServletRequest request) {
		boolean result = false;
		HttpSession session = request.getSession();
		String boardtitle = request.getParameter("boardtitle");
		String boardcontent = request.getParameter("boardcontent");
		
//		System.err.println("서비스 테스트1 :::::::::" + boardtitle);
//		System.err.println("서비스 테스트2 :::::::::" + boardcontent);
		
		IceUser user = (IceUser) session.getAttribute("user");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		Date date = new Date();
		String titletime =sdf.format(date);
		String email = user.getEmail();
		
//		System.err.println("서비스 테스트3 :::::::::" + email);
		
		if (boardtitle.length() <= 0) {
			boardtitle = user.getNickname() + "님이" + titletime + "에 남기신 글입니다.";

		}
		int boardnum = 1;
		Integer maxnum = boardDao.maxnum();
		
//		System.err.println("서비스 테스트4 :::::::::" + maxnum);
		if (maxnum != null) {
			boardnum = maxnum + 1;
		}

		IceBoard board = new IceBoard();
		board.setBoardtitle(boardtitle);
		board.setBoardcontent(boardcontent);
		board.setBoardnum(boardnum);
		board.setEmail(email);
		
//		System.err.println("boardDTO:::::" + board.toString());
		
		int r = boardDao.boardwrite(board);
		
		if(r >=1) {
			result = true;
		}else {
			result = false;
		}
//		System.err.println("보드 서비스 결과 ::::::::::" +result);
		return result;
	}

}

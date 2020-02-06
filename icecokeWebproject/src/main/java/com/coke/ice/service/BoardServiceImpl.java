package com.coke.ice.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
		
		// System.err.println("서비스 테스트1 :::::::::" + boardtitle);
		System.err.println("서비스 테스트2 :::::::::" + boardcontent);

		IceUser user = (IceUser) session.getAttribute("user");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		Date date = new Date();
		String titletime = sdf.format(date);
		String email = user.getEmail();

		// System.err.println("서비스 테스트3 :::::::::" + email);

		if (boardtitle.length() <= 0) {
			boardtitle = user.getNickname() + "님이 " + titletime + "에 남기신 글입니다.";

		}
		int boardnum = 1;
		Integer maxnum = boardDao.maxnum();

		// System.err.println("서비스 테스트4 :::::::::" + maxnum);

		if (maxnum != null) {
			boardnum = maxnum + 1;
		}
		IceBoard board = new IceBoard();
		board.setBoardtitle(boardtitle);
		board.setBoardcontent(boardcontent);
		board.setBoardnum(boardnum);
		board.setEmail(email);

		// System.err.println("boardDTO:::::" + board.toString());

		int r = boardDao.boardwrite(board);

		if (r >= 1) {
			result = true;
		} else {
			result = false;
		}
		// System.err.println("보드 서비스 결과 ::::::::::" +result);
		return result;
	}

	@Override
	public List<IceBoard> boardlist() {
		List<IceBoard> board = boardDao.boardlist();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd : hh/mm/ss");
		Calendar cal= Calendar.getInstance();
//		cal.set(Calendar.HOUR_OF_DAY,cal.get(Calendar.HOUR_OF_DAY)-9);
		
		String today = sdf.format(cal.getTime());
		
//		System.err.println("today::::::::::"+today);
		
		
		for (IceBoard tmp : board) {	
//			cal.setTime(tmp.getUpdatedate());
//			cal.set(Calendar.HOUR_OF_DAY,cal.get(Calendar.HOUR_OF_DAY)-9);
			
//			System.err.println(sdf2.format(tmp.getUpdatedate()));
//			System.err.println(cal.getTime());
//			
//			cal.getTime();
			if(today.equals((String)sdf.format(tmp.getUpdatedate()))){
				tmp.setDispdate("TODAY");
			}else 
			{
			tmp.setDispdate(sdf.format(tmp.getUpdatedate()));
			
			}
//			System.err.println(sdf.format(cal.getTime()));
			
		}
		return board;
	}

	@Override
	public IceBoard boardread(int boardnum) {

		boardDao.readcnt(boardnum);
		return boardDao.boardread(boardnum);
	}

	@Override
	public boolean boardupdate(HttpServletRequest request, int boardnum) {
		String boardtitle = request.getParameter("boardtitle");
		String boardcontent = request.getParameter("boardcontent");

		IceBoard board = new IceBoard();
		board.setBoardnum(boardnum);
		board.setBoardtitle(boardtitle);
		board.setBoardcontent(boardcontent);
		
		boolean result = false;
		int r = boardDao.boardupdate(board);
		if (r > 0) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}

	@Override
	public void boarddelete(int boardnum) {

		boardDao.boarddelete(boardnum);
	}

}

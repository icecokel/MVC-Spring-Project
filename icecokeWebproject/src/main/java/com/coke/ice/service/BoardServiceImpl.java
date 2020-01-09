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
		IceUser user = (IceUser) session.getAttribute("user");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		Date date = new Date();
		String titletime =sdf.format(date);
		String email = user.getEmail();
		if (boardtitle.length() <= 0) {
			boardtitle = user.getNickname() + "님이" + titletime + "에 남기신 글입니다.";

		}
		int boardnum = 1;
		Integer maxnum = boardDao.maxnum();

		if (maxnum == null) {
			boardnum = maxnum + 1;
		}

		IceBoard board = new IceBoard();
		board.setBoardtitle(boardtitle);
		board.setBoardcontent(boardcontent);
		board.setBoardnum(boardnum);
		board.setEmail(email);

		boardDao.boardwrite(board);

		return result;
	}

}

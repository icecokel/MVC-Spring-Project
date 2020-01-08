package com.coke.ice.service;

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
		
		String boardtitle = request.getParameter("boardtitle");
		String boardcontent = request.getParameter("boardcontent");

		int boardnum =1;
		Integer maxnum = boardDao.maxnum();
		
		if(maxnum == null) {
			boardnum = maxnum +1;
		}
		
		HttpSession session = request.getSession();
		
		IceUser user = (IceUser)session.getAttribute("user");
		
		String email = user.getEmail();
		
		
		IceBoard board = new IceBoard();
		board.setBoardtitle(boardtitle);
		board.setBoardcontent(boardcontent);
		board.setBoardnum(boardnum);
		board.setEmail(email);
		
		boardDao.boardwrite(board);
		
		
	
		return result;
	}

}

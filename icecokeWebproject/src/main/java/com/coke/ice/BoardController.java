package com.coke.ice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.coke.ice.domain.IceBoard;
import com.coke.ice.service.BoardService;


@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping (value="/board/list" , method =RequestMethod.GET)
	public String boardlist (Model model,HttpServletRequest request) {
		List<IceBoard> board = boardService.boardlist(request);
		
		
		model.addAttribute("boardlist", board);
		
		return "/board/list";
	}
	@RequestMapping (value="/board/write" , method =RequestMethod.GET)
	public String boardwrite (Model model) {
		
		return "/board/write";
	}
	
	
	@RequestMapping (value="board/write" , method =RequestMethod.POST)
	public String boardwrite (Model model, HttpServletRequest request) {
//		System.err.println("리퀘스트 확인" +request.toString());
//		System.err.println("보드타이틀" + request.getParameter("boardtitle"));
//		System.err.println("보드타이틀" + request.getParameter("boardcontent"));
		
		boolean r =boardService.boardwrite(request);
		
		if(r == true) {
			System.err.println("성공");
			
			return "redirect:/board/list";
			
		}else {
			System.err.println("실패");
			return "redirect:/board/write";
		}
		
	}
	@RequestMapping (value="/read/{boardnum}", method=RequestMethod.GET)
	public String boardread(Model model , @PathVariable("boardnum") int boardnum) {
	
		model.addAttribute("boardread",boardService.boardread(boardnum));
		
//		System.err.println("보드 컨트롤러 테스트 :::"+boardService.boardread(boardnum));
		return "/board/read";
	}
	
	@RequestMapping (value="/read/{boardnum}" , method=RequestMethod.POST)
	public String boardupdate (Model model , HttpServletRequest request , @PathVariable("boardnum") int boardnum) {
		// 업데이트.
		boolean result = boardService.boardupdate(request ,boardnum);
		
		if (result == true) {
			System.err.println("성공");
//			request.getSession().setAttribute("msg", "게시글을 수정 했습니다.");
			return "redirect:/board/read/{boardnum}";
		}else {
			System.err.println("실패");
//			request.getSession().setAttribute("msg", "게시글을 수정하지 못했습니다. 다시 시도 해 주십시오.");
			return "redirect:/board//read/{boardnum}";
		
		}
		
	}
	
	@RequestMapping (value="/board/delete/{boardnum}", method=RequestMethod.GET)
	public String boarddelete (Model model,@PathVariable("boardnum") int boardnum) {
		
		boardService.boarddelete(boardnum);
		
		return "redirect:/board/list";
	}

	
}

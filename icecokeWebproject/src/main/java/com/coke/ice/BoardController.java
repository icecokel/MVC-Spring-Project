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
	public String boardlist (Model model, HttpServletRequest request) {
		String pageparam = request.getParameter("page");
		int page = 1 ;
		if(pageparam != null ) {
			page = (Integer.parseInt(pageparam)-1)*10;
		}
		List<IceBoard> boardori = boardService.boardlist();
		List<IceBoard> board = boardService.boardpage(page);
		
		int boardcnt = 0;
		int boardsize = boardori.size();
		
		if(boardsize % 10 == 0) {
			boardcnt = boardsize /10;
		}else {
			boardcnt = boardsize /10 +1;
		}
		
		
		model.addAttribute("boardlist", board);
		model.addAttribute("boardcnt", boardcnt);
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
		model.addAttribute("comments", boardService.commentlist(boardnum));
		model.addAttribute("commentcnt", boardService.commentcnt(boardnum));
		
//		System.err.println("보드 컨트롤러 테스트 :::"+boardService.boardread(boardnum));
		return "/board/read";
	}
	
	@RequestMapping (value="/board/delete/{boardnum}", method=RequestMethod.GET)
	public String boarddelete (Model model,@PathVariable("boardnum") int boardnum) {
		
		boardService.boarddelete(boardnum);
		
		return "redirect:/board/list";
	}

	@RequestMapping (value="/update/{boardnum}" , method=RequestMethod.GET)
	public String boardupdate (Model model ,@PathVariable("boardnum") int boardnum){
		model.addAttribute("board",boardService.boardread(boardnum));
		
		return "/board/update";
	}
	
	@RequestMapping (value="/update/{boardnum}", method=RequestMethod.POST)
	public String boardupdate (Model model , HttpServletRequest request , @PathVariable("boardnum") int boardnum){
		System.out.println("보트 업데이트 컨트롤라ㅓ ::"   + boardnum);
		
		boolean result = boardService.boardupdate(request ,boardnum);
		
		if (result == true) {
			System.err.println("성공");
//			request.getSession().setAttribute("msg", "게시글을 수정 했습니다.");
			return "redirect:/board/list";
		}else {
			System.err.println("실패");
//			request.getSession().setAttribute("msg", "게시글을 수정하지 못했습니다. 다시 시도 해 주십시오.");
			return "redirect:/board/list";
		
		}
	}

	@RequestMapping (value="board/delete" , method=RequestMethod.POST)
	public String boarddelete (HttpServletRequest request) {
		int boardnum = Integer.parseInt(request.getParameter("boardnum"));
		
		boardService.boarddelete(boardnum);
		
		return "";
	}
}

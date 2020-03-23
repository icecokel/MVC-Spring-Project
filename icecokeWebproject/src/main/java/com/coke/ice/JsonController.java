package com.coke.ice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.coke.ice.domain.IceComment;
import com.coke.ice.service.BoardService;
import com.coke.ice.service.UserService;

@RestController
public class JsonController {

	@Autowired
	private UserService userService;

	@Autowired
	private BoardService boardService;

	// 이메일 중복검사를 위한 메소드
	@RequestMapping(value = "user/emailcheck", method = RequestMethod.GET)
	public Map<String, Object> checkemail(HttpServletRequest request) {

		boolean result = userService.checkemail(request);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result + "");
		return map;

	}

	@RequestMapping(value = "user/nicknamecheck", method = RequestMethod.GET)
	public Map<String, Object> checknickname(HttpServletRequest request) {
		boolean result = userService.checknickname(request);
		Map<String, Object> map = new HashMap<String, Object>();


		map.put("result", result + "");
		return map;

	}

	@RequestMapping(value = "user/verification", method = RequestMethod.POST)
	public Map<String, Object> userverification(HttpServletRequest request) {
		boolean result = userService.userverification(request);

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("result", result + "");
		return map;

	}

	@RequestMapping(value = "/commentlist", method = RequestMethod.GET)
	public List<IceComment> commentlist(Model model, HttpServletRequest request) {

		int boardnum = Integer.parseInt(request.getParameter("boardnum"));

		List<IceComment> comments = boardService.commentlist(boardnum);

		return comments;
	}

	@RequestMapping(value = "/commentcnt", method = RequestMethod.GET)
	public Map<String, Object> commentcnt(Model model, HttpServletRequest request) {
		int boardnum = Integer.parseInt(request.getParameter("boardnum"));
		Map<String, Object> map = new HashMap<String, Object>();
		int r = boardService.commentcnt(boardnum);
		map.put("comcnt", r + "");

		return map;
	}

	@RequestMapping(value = "/commentwrite", method = RequestMethod.POST)
	public Map<String, Object> commentwrite(HttpServletRequest request) {
		int boardnum = Integer.parseInt(request.getParameter("boardnum"));

		Map<String, Object> map = new HashMap<String, Object>();

		boolean r = boardService.commentwrite(request, boardnum);
		map.put("result", r + "");
		return map;

	}

	@RequestMapping(value = "/commentdel", method = RequestMethod.POST)
	public Map<String, Object> commentdel(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		int commentnum = Integer.parseInt(request.getParameter("comnum"));
		System.out.println("flag");
		boolean cmc = boardService.commentusercheck(request);

		if (cmc) {
			boolean r = boardService.commentdel(commentnum);
			map.put("result", r + "");
			System.out.println(r);
		} else {
			map.put("result", "email");
		}

		System.out.println(map);
		return map;
	}
	
	@RequestMapping (value="/commentupdate", method = RequestMethod.POST)
	public Map<String , Object> commentupdate (HttpServletRequest request){
		
		Map<String , Object> map = new HashMap<String ,Object>();
		boolean cmc = boardService.commentusercheck(request);
		
		if(cmc) {
			boolean r = boardService.commentupdate(request);
			map.put("result", r+"");
		}else {
			map.put("result", "email");
		}
		System.out.println(map);
		return map;
		
	}

}

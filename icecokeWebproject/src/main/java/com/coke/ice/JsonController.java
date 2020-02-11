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
	// email 이라는 파라미터를 email 이라는 문자열 변수에 저장

	// nicknamecheck 요청을 처리할 메소드
	// 파라미터를 Service에 읽도록 했기 때문에 매개변수가
	// HttpServletRequest
	@RequestMapping(value = "user/nicknamecheck", method = RequestMethod.GET)
	public Map<String, Object> checknickname(HttpServletRequest request) {
		boolean result = userService.checknickname(request);
		Map<String, Object> map = new HashMap<String, Object>();
//		System.err.println(result);
		
		map.put("result", result + "");
		return map;

	}
	@RequestMapping (value="user/verification" , method=RequestMethod.POST)
	public Map<String , Object> userverification (HttpServletRequest request){
		boolean result = userService.userverification(request);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("result", result +"" );
		return map;
		
	}

	@RequestMapping (value="/commentlist" ,method=RequestMethod.GET)
	public List<IceComment> commentlist (Model model,HttpServletRequest request){
				
		
		int boardnum = Integer.parseInt(request.getParameter("boardnum"));
		
		List<IceComment> comments = boardService.commentlist(boardnum);
		
		return comments;
	}
	@RequestMapping (value="/commentcnt", method=RequestMethod.GET)
	public Map<String ,Object> commentcnt (Model model, HttpServletRequest request){
		int boardnum = Integer.parseInt(request.getParameter("boardnum"));
		Map<String ,Object> map = new HashMap<String , Object>();
		int r = boardService.commentcnt(boardnum);
		map.put("comcnt", r+"");
		
		return map;
	}
 
	
	@RequestMapping (value="/commentwrite", method=RequestMethod.POST)
	public Map<String ,Object> commentwrite (HttpServletRequest request){
		int boardnum = Integer.parseInt(request.getParameter("boardnum"));
	
		Map<String ,Object> map = new HashMap<String, Object>();
		
		boolean r =boardService.commentwrite(request,boardnum);
		map.put("result", r+"");
		return map;
		
	}

}


package com.coke.ice.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.coke.ice.domain.IceBoard;
@Service
public interface BoardService {
	public boolean boardwrite(HttpServletRequest request);
	
	public List<IceBoard> boardlist(HttpServletRequest request);
}

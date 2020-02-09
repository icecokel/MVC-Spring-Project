package com.coke.ice.domain;

import java.util.Date;

import lombok.Data;

@Data
public class IceComment {
	private int commentnum;
	private String commentcontent;
	private String email;
	private String targetemail;
	private Date commenttime;
	private int commentlevel;
	private int boardnum;
	
	
	private String dispdate;
	private String nickname;
	
}


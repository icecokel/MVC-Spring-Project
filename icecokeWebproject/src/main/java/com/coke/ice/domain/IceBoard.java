package com.coke.ice.domain;

import java.util.Date;

import lombok.Data;

@Data
public class IceBoard {

	private int boardnum;
	private String boardtitle;
	private String boardcontent;
	private int boardreadcnt;
	private Date credate;
	private Date updatedate;
	private String email;
	
	private String nickname;
	private String dispdate;
}

package com.coke.ice.domain;

import java.util.Date;

import lombok.Data;
@Data
public class IceFile {
	private int filenum;
	private String filename;
	private String fileUUID;
	private String filesize;
	private Date fileUploaddate;
	private String email;
	
	private String nickname;
	private String dispdate;
	private int dispNum;
	
}

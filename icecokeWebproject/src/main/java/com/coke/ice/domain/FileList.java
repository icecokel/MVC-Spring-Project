package com.coke.ice.domain;

import java.util.Date;

import lombok.Data;
@Data
public class FileList {
	private int filenum;
	private String filename;
	private String fileUUID;
	private String filesize;
	private Date fileUploaddate;
	
}

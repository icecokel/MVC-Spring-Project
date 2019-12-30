package com.coke.ice.domain;

import java.util.Date;

import org.springframework.stereotype.Service;

import lombok.Data;


@Data
public class IceUser {
	
	private String email;
	private String password;
	private String name;
	private String nickname;
	private String image;
	private String phone;
	
	private Date birthday;
}

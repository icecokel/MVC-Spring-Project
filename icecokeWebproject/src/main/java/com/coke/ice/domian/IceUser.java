package com.coke.ice.domian;

import java.util.Date;

import org.springframework.stereotype.Service;

import lombok.Data;
@Service
@Data
public class IceUser {
	
	private String email;
	private String password;
	private String name;
	private String nickname;
	private String image;
	private Date birthday;
}

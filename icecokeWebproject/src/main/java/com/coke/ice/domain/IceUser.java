package com.coke.ice.domain;

import java.util.Date;


import lombok.Data;


@Data
public class IceUser {
	
	private String email;
	private String password;
	private String name;
	private String nickname;
	private String phone;
	private Date birthday;
	
	private String image ;
	private String givenewpwA;
	private String givenewpwQ;
	private Date reqdate;
	
	
	
	
}

package com.mohaji.dockertest2.model;

import lombok.*;

@Setter
@Getter   

@ToString

public class Member {
	private long id;
	private String name;
	private int age;
	private String email;
	private String regdate;
	private String meno;

	
}

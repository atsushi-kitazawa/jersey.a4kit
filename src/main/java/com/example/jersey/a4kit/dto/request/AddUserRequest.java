package com.example.jersey.a4kit.dto.request;

import lombok.Data;

@Data
public class AddUserRequest {
	private String name;
	private String birth;
	private String email;
}

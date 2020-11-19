package com.example.jersey.a4kit.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

	private String name;
	private String birth;
	private String email;
}

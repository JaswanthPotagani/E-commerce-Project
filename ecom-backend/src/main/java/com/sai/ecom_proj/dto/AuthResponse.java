package com.sai.ecom_proj.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class AuthResponse {
	private String token;
	private String username;

	public AuthResponse(String token, String username) {
		this.token = token;
		this.username = username;
	}

    public void setToken(String token) {
		this.token = token;
	}

    public void setUsername(String username) {
		this.username = username;
	}
	
	
	
}

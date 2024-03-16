package com.chat.model;

import java.time.LocalDateTime;

public class ResetToken {
    private String email;
    private String token;
    private LocalDateTime expiryDate;
	public ResetToken(String email, String token, LocalDateTime expiryDate) {
		super();
		this.email = email;
		this.token = token;
		this.expiryDate = expiryDate;
	}
	public ResetToken() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public LocalDateTime getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDateTime expiryDate) {
		this.expiryDate = expiryDate;
	}

    // Constructors, getters, and setters
    
}


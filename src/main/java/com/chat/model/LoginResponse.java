package com.chat.model;

import com.chat.entities.User;

public class LoginResponse {
	private User employee;
    private String redirectUrl;

    public LoginResponse(User employee, String redirectUrl) {
        this.employee = employee;
        this.redirectUrl = redirectUrl;
    }

    public User getEmployee() {
        return employee;
    }

    public void setEmployee(User employee) {
        this.employee = employee;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }
}

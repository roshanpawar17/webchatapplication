package com.chat.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;

public class UserDto {
	private String eid;
	private String ename;
	private String eemail;	
	private String epassword;
	private LocalDateTime date_joined;
	private Boolean onlineStatus = false;
	
	public Boolean getOnlineStatus() {
		return onlineStatus;
	}

	public void setOnlineStatus(Boolean onlineStatus) {
		this.onlineStatus = onlineStatus;
	}
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEemail() {
		return eemail;
	}
	public void setEemail(String eemail) {
		this.eemail = eemail;
	}
	public String getEpassword() {
		return epassword;
	}
	public void setEpassword(String epassword) {
		this.epassword = epassword;
	}
	public LocalDateTime getDate_joined() {
		return date_joined;
	}
	public void setDate_joined(LocalDateTime date_joined) {
		this.date_joined = date_joined;
	}
	public UserDto(String eid, String ename, String eemail, String epassword, LocalDateTime date_joined) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.eemail = eemail;
		this.epassword = epassword;
		this.date_joined = date_joined;
	}
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

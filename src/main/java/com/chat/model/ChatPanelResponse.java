package com.chat.model;

import com.chat.entities.Groups;
import com.chat.entities.User;

public class ChatPanelResponse {
	private Groups groupData;
	private User loginEmployee;
	public ChatPanelResponse(Groups groupData, User loginEmployee) {
		super();
		this.groupData = groupData;
		this.loginEmployee = loginEmployee;
	}
	public ChatPanelResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Groups getGroupData() {
		return groupData;
	}
	public void setGroupData(Groups groupData) {
		this.groupData = groupData;
	}
	public User getLoginEmployee() {
		return loginEmployee;
	}
	public void setLoginEmployee(User loginEmployee) {
		this.loginEmployee = loginEmployee;
	}
	
	
	
	
}

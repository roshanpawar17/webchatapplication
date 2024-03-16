package com.chat.entities;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Message {
//	private int messageId;
	private String message;
	
//	@ManyToOne
//	@JoinColumn(name = "group_id") // This refers to the foreign key in the userdata table
//	private Groups group;
	
//	@ManyToOne
//	@JoinColumn(name="emp_id")
//	private String ename;
	
	

	public Message(String message) {
		super();
		this.message = message;
	}
	

	public Message() {
		super();		
	}


	public String getMessage() {
		return message;
	}

	

	public void setMessage(String message) {
		this.message = message;
	}

	
	
	
	
	
	
}

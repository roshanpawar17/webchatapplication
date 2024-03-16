package com.chat.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Message {
	private String sender;
	private String message;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "M/d/yyyy, h:mm:ss a")
	private Date timestamp;
	
	public Message(String sender, String message, Date timestamp) {
		super();
		this.sender = sender;
		this.message = message;
		this.timestamp = timestamp;
	}
	


//	@ManyToOne
//	@JoinColumn(name = "group_id") // This refers to the foreign key in the userdata table
//	private Groups group;
	
//	@ManyToOne
//	@JoinColumn(name="emp_id")
//	private String ename;


	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getSender() {
		return sender;
	}


	public void setSender(String sender) {
		this.sender = sender;
	}
	

	public String getMessage() {
		return message;
	}

	
	public void setMessage(String message) {
		this.message = message;
	}


	public Date getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}




	
	
	
	
	
	
}

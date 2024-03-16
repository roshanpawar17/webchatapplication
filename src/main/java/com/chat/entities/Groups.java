package com.chat.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "chatroom")
public class Groups {
	@Id
	@Column(name = "group_id")
	private String gid;
	@Column(name = "group_name")
	private String gname;
	@Column(name = "group_department_name")
	private String gdname;
	@Column(name = "group_team_name")
	private String gtname; 
	
	@JsonManagedReference
	@OneToMany(mappedBy = "groups")
//	@JoinTable(name="groups_of_employees", joinColumns = @JoinColumn(name="emp_id"), 
//											inverseJoinColumns = @JoinColumn(name="group_id"))
	private List<User> users = new ArrayList<>();
	
//	@OneToMany(mappedBy = "group", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	private List<Message> messages;
	
	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public String getGdname() {
		return gdname;
	}

	public void setGdname(String gdname) {
		this.gdname = gdname;
	}

	public String getGtname() {
		return gtname;
	}

	public void setGtname(String gtname) {
		this.gtname = gtname;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Groups() {
		super();
		// TODO Auto-generated constructor stub
	}

//	public Groups(String gid, String gname, String gdname, String gtname, List<User> users) {
//		super();
//		this.gid = gid;
//		this.gname = gname;
//		this.gdname = gdname;
//		this.gtname = gtname;
//		this.users = users;
//	} 

	

//	public List<Message> getMessages() {
//		return messages;
//	}
//
//	public void setMessages(List<Message> messages) {
//		this.messages = messages;
//	}

	
	
	
	
}

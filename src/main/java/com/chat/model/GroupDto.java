package com.chat.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

public class GroupDto {
	private String gid;
	private String gname;
	private String gdname;
	private String gtname; 
	
	
//	@OneToMany(mappedBy = "groups")
	private List<String> users = new ArrayList<>();


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


	public List<String> getUsers() {
		return users;
	}


	public void setUsers(List<String> users) {
		this.users = users;
	}


	public GroupDto(String gid, String gname, String gdname, String gtname, List<String> users) {
		super();
		this.gid = gid;
		this.gname = gname;
		this.gdname = gdname;
		this.gtname = gtname;
		this.users = users;
	}


	public GroupDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

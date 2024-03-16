package com.chat.entities;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "employeedata")
public class User {
	@Id
	@Column(name = "emp_id")	
	private String eid;
	private String ename;
	@Column(unique = true)
	private String eemail;	
	private String epassword;
//	private String erole;
//	@Column(name = "date_of_joined")
	private LocalDateTime date_joined;
	
	@JsonBackReference
	@JsonIgnore 
	@ManyToOne
	@JoinColumn(name = "group_id")
	private Groups groups;
	
	
	public User(String eid) {
		super();
		this.eid = eid;
	}


	public User(String eid, String ename) {
	    this.eid = eid;
	    this.ename = ename;
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
//	public String getErole() {
//		return erole;
//	}
//	public void setErole(String erole) {
//		this.erole = erole;
//	}
	public LocalDateTime getDate_joined() {
		return date_joined;
	}
	public Groups getGroups() {
		return groups;
	}
	public void setGroups(Groups groups) {
		this.groups = groups;
	}
	public void setDate_joined(LocalDateTime date_joined) {
		this.date_joined = date_joined;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}



	
}

package com.chat.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "root_admin")
public class RootAdmin {
	@Id
	@Column(name= "root_id", nullable = false)
	private String rid;
	@Column(name= "root_name", nullable = false)
	private String rname;
	@Column(name= "root_email", unique = true, nullable = false)
	private String remail;
	@Column(name= "root_password", nullable = false)
	private String rpassword;
	@Column(name= "role", nullable = false)
	private String role;
	@Column(nullable = false, columnDefinition = "tinyint(1) default false")
	private Boolean setupcomplete=false; 
	
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public String getRemail() {
		return remail;
	}
	public void setRemail(String remail) {
		this.remail = remail;
	}
	public String getRpassword() {
		return rpassword;
	}
	public void setRpassword(String rpassword) {
		this.rpassword = rpassword;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public Boolean getSetupcomplete() {
		return setupcomplete;
	}
	public void setSetupcomplete(Boolean setupcomplete) {
		this.setupcomplete = setupcomplete;
	}
	public RootAdmin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	 
	
}

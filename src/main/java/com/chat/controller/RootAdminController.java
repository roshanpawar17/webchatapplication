package com.chat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chat.dao.RootAdminRepository;
import com.chat.entities.RootAdmin;
import com.chat.model.RootAdminLoginData;
import com.chat.service.RootAdminService;

@RestController
@RequestMapping("/rootadmin")
@CrossOrigin(origins = "http://localhost:5173")
public class RootAdminController {
	@Autowired
	private RootAdminService rootAdminService;
	@Autowired
	private RootAdminRepository rootAdminRepository;

	@PostMapping("/setupaccount")
	public ResponseEntity<?> addRootUser(@RequestBody RootAdmin rootAdmin){
		try {
			RootAdmin addRootAdmin = this.rootAdminService.addRootAdmin(rootAdmin);
			return ResponseEntity.ok(addRootAdmin);
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went wrong during registration. try again! "+e);
		}
		
	}
	
	@GetMapping("/getroot")
	public ResponseEntity<?> getRootUser(){
		try {
			List<RootAdmin> findAll = this.rootAdminRepository.findAll();
			System.out.println(findAll);
			return ResponseEntity.ok(findAll);
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went wrong. try again! "+e);
		}	
	}
	
	@PostMapping("/rootadminlogin")
	public ResponseEntity<?> rootAdminlogin(@RequestBody RootAdminLoginData rootAdminLoginData){
		RootAdmin rootadmin = this.rootAdminRepository.findByRemail(rootAdminLoginData.getEmail());
		if(rootadmin == null ) {
			System.out.println("you are not root user");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("You are not root user");
		}else if(rootadmin.getRemail().equals(rootAdminLoginData.getEmail()) && rootadmin.getRpassword().equals(rootAdminLoginData
				.getPassword()) && rootadmin.getRole().equals(rootAdminLoginData.getRole())){
			System.out.println("login successfully");
			return ResponseEntity.ok(rootadmin);
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid username and password");
		}
	
	}
	
}

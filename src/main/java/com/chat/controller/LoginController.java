package com.chat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chat.dao.RootAdminRepository;
import com.chat.dao.UserRepository;
import com.chat.entities.RootAdmin;
import com.chat.entities.User;
import com.chat.model.LoginResponse;
import com.chat.model.UserDto;
import com.chat.model.UserLoginData;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "http://localhost:5173")
public class LoginController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RootAdminRepository rootAdminRepository;
	

	@PostMapping("/userlogin")
	public ResponseEntity<?> userLogin(@RequestBody UserLoginData userLoginData) {
//		System.out.println(userLoginData.getUsername()+ " "+userLoginData.getPassword());
		String username= userLoginData.getEmail();
		String password= userLoginData.getPassword();
		
		System.out.println(username);
		System.out.println(password);
		
		
		RootAdmin rootAdmin = rootAdminRepository.findByRemail(username);
		User employee = userRepository.findByEemail(username);
		
		
		if(rootAdmin != null && rootAdmin.getRpassword().equals(password)) {
			return ResponseEntity.status(HttpStatus.OK).body(rootAdmin);
		}else if(employee != null && employee.getEpassword().equals(password)) {
			employee.setOnlineStatus(true);
			userRepository.save(employee);
			String redirectUrl = "/chatpanel?groupId=" + employee.getGroups().getGid() + "&employeeId=" + employee.getEid();
			LoginResponse loginResponse = new LoginResponse(employee, redirectUrl);
		
			return ResponseEntity.status(HttpStatus.OK).body(loginResponse);
		} else {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
	    }
			

		
	}
	

	
	
}

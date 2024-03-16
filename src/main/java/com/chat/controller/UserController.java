package com.chat.controller;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chat.dao.UserRepository;
import com.chat.entities.RootAdmin;
import com.chat.entities.User;
import com.chat.model.UserDto;
import com.chat.service.UserService;


@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {
		
	@Autowired
	private UserService userService;
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/adduser")
	public ResponseEntity<?> addUsers(@RequestBody User user) {
		User u=null;
		try {
			Random random = new Random();
			int rpassno=random.nextInt(4000) + 1000;
			user.setEpassword("Tcorp@"+rpassno);
			user.setDate_joined(LocalDateTime.now());
			u=this.userService.addUser(user);
			return ResponseEntity.ok("user add successfully "+u);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went wrong");
		}		
		
	}
	
	@GetMapping("/getusers")
	public ResponseEntity<?> getUsers(){
		try {
			List<User> findAll = this.userRepository.findAll();			
			return ResponseEntity.ok(findAll);
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went wrong. try again! "+e);
		}	
	}
	
	@PutMapping("/updateuser")
	public ResponseEntity<?> updateUser(@RequestBody UserDto userDto) {
	    try {
	        User updatedUser = userService.updateUser(userDto.getEid(), userDto);
	        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	    } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    }
	}
	
	@DeleteMapping("/deleteuser")
	public ResponseEntity<?> deleteUser(@RequestBody Map<String, String> requestBody) {
	    try {
	    	
	    	String id = requestBody.get("id");
	    	System.out.print(id);
	        userService.deleteUser(id);
	        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
	    } catch (Exception e) {
	        return new ResponseEntity<>("something went wrong", HttpStatus.BAD_REQUEST);
	    }
	}
	
	@DeleteMapping("/removeuser")
	public ResponseEntity<?> removeUser(@RequestBody Map<String, String> requestBody) {
	    try {
	    	
	    	String id = requestBody.get("id");
	    	System.out.print(id);
	        userService.removeUser(id);
	        return new ResponseEntity<>("remove Successfully", HttpStatus.OK);
	    } catch (Exception e) {
	        return new ResponseEntity<>("something went wrong", HttpStatus.BAD_REQUEST);
	    }
	}
	
//	@GetMapping("/countByRole")
//    public ResponseEntity<Long> countUsersByRole(@RequestParam String role) {
//        Long count = this.userRepository.countUsersByEemail(role);
//		return ResponseEntity.ok(count);
//    }
	
	
//	@GetMapping("/searchuser")
//	public ResponseEntity<List<User>> searchUser(@RequestParam String q ){
//		System.out.println(q);
////		List<String> nf=new ArrayList<>();
////		nf.add("Not found");
//		List<User> allUserData = userRepository.getAllUserData(q);
//
////		if(allUserData == null) {
////			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(nf);
////		}else{
//			return ResponseEntity.ok(allUserData);
////		};
//	} 
}

package com.chat.controller;

import java.time.LocalDateTime;
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
import org.springframework.web.bind.annotation.RestController;

import com.chat.dao.GroupRepository;
import com.chat.dao.UserRepository;
import com.chat.entities.Groups;
import com.chat.entities.User;
import com.chat.model.GroupDto;
import com.chat.model.UserDto;
import com.chat.service.GroupService;
import com.chat.service.UserService;

@RestController
@RequestMapping("/groups")
@CrossOrigin(origins = "http://localhost:5173")
public class GroupController {
	
	@Autowired
	public GroupService groupService;
	@Autowired
	public UserRepository userRepository;
	@Autowired
	public GroupRepository groupRepository;
	
	@PostMapping("/creategroup")
	public ResponseEntity<?> createGroups(@RequestBody GroupDto groupDto) {
		Groups g=null;

		try {
			Groups groups = new Groups();
			groups.setGid(groupDto.getGid());
			groups.setGname(groupDto.getGname());
			groups.setGdname(groupDto.getGdname());
			groups.setGtname(groupDto.getGtname());
			groups.setUsers(userRepository.findAllById(groupDto.getUsers()));	
			
			g=this.groupService.createGroup(groups);
			groupService.addEmployeesToGroup(groupDto.getGid(), groupDto.getUsers());
			return ResponseEntity.ok("group created successfully "+g);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went wrong");
		}		
		
	}
	
	@PostMapping("/addusersingroup")
	public ResponseEntity<?> addUsersInGroup(@RequestBody GroupDto groupDto) {
		Groups g=null;

		try {
			groupService.addEmployeesToGroup(groupDto.getGid(), groupDto.getUsers());
			return ResponseEntity.ok("users added successfully ");
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went wrong");
		}		
		
	}
	
	@GetMapping("/getgroups")
	public ResponseEntity<?> getGroups(){
		try {
			List<Groups> findAll = this.groupRepository.findAll();			
			return ResponseEntity.ok(findAll);
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went wrong. try again! "+e);
		}	
	}
	
	@PutMapping("/updategroup")
	public ResponseEntity<?> updateUser(@RequestBody GroupDto groupDto) {
	    try {
	        Groups updatedGroup = groupService.updateGroup(groupDto.getGid(), groupDto);
	        return new ResponseEntity<>(updatedGroup, HttpStatus.OK);
	    } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    }
	}
	
	@DeleteMapping("/deletegroup")
	public ResponseEntity<?> deleteUser(@RequestBody Map<String, String> requestBody) {
	    try {
	    	
	    	String id = requestBody.get("id");
	    	System.out.print(id);
	        groupService.deleteGroup(id);
	        return new ResponseEntity<>("Deleted Successfully", HttpStatus.OK);
	    } catch (Exception e) {
	        return new ResponseEntity<>("something went wrong", HttpStatus.BAD_REQUEST);
	    }
	}
	
}

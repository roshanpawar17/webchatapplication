package com.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chat.dao.GroupRepository;
import com.chat.dao.UserRepository;
import com.chat.entities.Groups;
import com.chat.entities.User;
import com.chat.model.ChatPanelResponse;
import com.chat.model.UserLoginData;

@RestController
@RequestMapping("/chatpanel")
@CrossOrigin(origins = "http://localhost:5173")
public class ChatPanelController {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	public GroupRepository groupRepository;

//	@PostMapping("/paneldata")
//	public ResponseEntity<?> getChatPanelData(@RequestParam String groupId, @RequestParam String empId) {
//		String data="groupId "+groupId+" userId "+empId;
//		System.out.print(data);
//
//		Groups groupData = groupRepository.findByGid(groupId);
//		User loginEmployee = userRepository.findByEid(empId);
//
//		
//		ChatPanelResponse chatPanelResponse = new ChatPanelResponse(groupData, loginEmployee);
//		
//		return ResponseEntity.status(HttpStatus.OK).body(chatPanelResponse);
//	}
	
	@PutMapping("/logout")
	public ResponseEntity<?> getChatPanelData(@RequestParam String empId) {
		User loginEmployee = userRepository.findByEid(empId);
		loginEmployee.setOnlineStatus(false);
		userRepository.save(loginEmployee);
		
		return ResponseEntity.status(HttpStatus.OK).body(loginEmployee);
	}
}

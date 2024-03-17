package com.chat.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chat.entities.Message;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class MessageController {
	
	@MessageMapping("/message")
	@SendTo("/topic/return-to")
	public Message getMessage(@RequestBody Message message) {
		try {
			Thread.sleep(2000);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		return message;
	}
	
	@MessageMapping("/logout")
	@SendTo("/topic/logout")
    public String handleLogout(String userId) {
        // Handle logout message from client
		try {
			Thread.sleep(2000);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
        
        // Notify other clients about the logout event
        return userId;
    }
	
	@MessageMapping("/login")
	@SendTo("/topic/login")
    public String handleLogin(String userId) {
        // Handle logout message from client
		try {
			Thread.sleep(2000);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
        
        // Notify other clients about the logout event
        return userId;
    }
}

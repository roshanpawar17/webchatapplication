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
}

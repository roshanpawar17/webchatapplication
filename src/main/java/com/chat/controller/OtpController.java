package com.chat.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chat.model.EmailRequest;
import com.chat.model.Otp;
import com.chat.service.SendEmail;


@RestController
@RequestMapping("/otp")
@CrossOrigin(origins = "http://localhost:5173")
public class OtpController {
	
	private String email;
	private int generateOtp;
	@Autowired
	private SendEmail sendEmail;
	
	@PostMapping("/sendotp")
	public ResponseEntity<?> sendOtp(@RequestBody EmailRequest emailRequest){
		//generate 6 digit random number otp
		Random random = new Random();
		int OTP=random.nextInt(900000) + 100000;
		
		String msg = "OTP is "+OTP;
		String sub= "OTP from Chat";
		
		email=emailRequest.getEmail();
		generateOtp=OTP;
		
		System.out.println(email);
		System.out.println(generateOtp);
		
		boolean sendMail = sendEmail.sendMail(email, msg, sub);
		
		if(sendMail) {
			return ResponseEntity.ok("OTP Send Successfully On Your Email..! ");
		}else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Somthing went wrong..!");
		}
		
		
	}
	
	@PostMapping("/verifyotp")
	public ResponseEntity<?> verifyOtp(@RequestBody Otp otp) {
		int enterOtp=otp.getOtp();
		int generatedOtp=generateOtp;
		System.out.println("enter otp "+enterOtp);
		System.out.println("generated otp "+generatedOtp);
		System.out.println("enter email "+ email);
		
		if(enterOtp == generatedOtp) {
			System.out.println("valid otp");
			return ResponseEntity.status(HttpStatus.OK).body("Valid otp");			
		}else {
			System.out.println("Invalid otp");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid OTP"); 
		}
			
		
	}
}

package com.chat.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chat.dao.UserRepository;
import com.chat.entities.User;
import com.chat.model.EmailRequest;
import com.chat.model.ResetToken;
import com.chat.service.SendEmail;

@RestController
@RequestMapping("/password")
@CrossOrigin(origins = "http://localhost:5173")
public class ForgotPassword {
	private Map<String, ResetToken> resetTokens = new HashMap<>();
//	@Autowired
//	private UserRepository userRepository;
	@Autowired
	private SendEmail sendEmail;
	
//	@PostMapping("/forgot-password")
//	public ResponseEntity<?> forgotPassword(@RequestBody EmailRequest emailRequest) {
//		String email=emailRequest.getEmail();
//		User user = userRepository.findByEmail(email);
//		if(user == null) {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found..!");
//		}else {
//			// Generate a reset token (secure UUID) and set an expiration time (e.g., 30 minutes)
//	        String token = UUID.randomUUID().toString();
//	        LocalDateTime expiryDate = LocalDateTime.now().plusMinutes(30);
//	        
//	        String sub="Reset Password from chat";
//	        String msg="Click the following link to reset your password: http://localhost:5173/login/reset-password?email=" + email + "&token=" + token;
//
//	        // Save the reset token and its expiry date in the resetTokens map
//	        resetTokens.put(email, new ResetToken(email, token, expiryDate));
//
//	        // Send the reset password link to the user's email
//	        sendEmail.sendMail(email, msg, sub);
//
//	        return ResponseEntity.ok("Reset password link sent to your email");
//		}		
//	}
	
	// Endpoint to handle password reset
//    @PostMapping("/reset-password")
//    public ResponseEntity<String> resetPassword(@RequestParam String email, @RequestParam String token, @RequestParam String newPassword) {
//        // Check if the email exists in your database or data structure
//    	User user = userRepository.getUserByEmail(email);
//		if(user == null) {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found..!");
//		}
//
//        // Check if the reset token is valid and not expired][
//        ResetToken resetToken = resetTokens.get(email);
//        if (resetToken == null || !resetToken.getToken().equals(token) || resetToken.getExpiryDate().isBefore(LocalDateTime.now())) {
//            return ResponseEntity.badRequest().body("Invalid or expired reset token");
//        }
//
//        // Update the user's password in your database or data structure
//        userRepository.updatePassword(newPassword, email);
//
//        // Remove the reset token from the resetTokens map (since it's already used)
//        resetTokens.remove(email);
//
//        return ResponseEntity.ok("Password reset successful");
//    }
}

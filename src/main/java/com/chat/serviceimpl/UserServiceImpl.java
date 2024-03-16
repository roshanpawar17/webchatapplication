package com.chat.serviceimpl;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chat.dao.UserRepository;
import com.chat.entities.User;
import com.chat.model.UserDto;
import com.chat.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;

	@Override
	public User addUser(User user) {
		User saveUser = this.userRepository.save(user);
		return saveUser;
	}

	@Override
	public User updateUser(String id, UserDto userDto) {
		User existingUser = userRepository.findById(id).orElse(null);
		
        existingUser.setEname(userDto.getEname());
        existingUser.setEemail(userDto.getEemail());
        existingUser.setEpassword(userDto.getEpassword());
//        existingUser.setDate_joined(originalDateOfJoin);
		User updateUser = this.userRepository.save(existingUser);
		return updateUser;
	}

	@Override
	public void deleteUser(String id) {
		User existingUser = userRepository.findById(id).orElse(null);
		this.userRepository.delete(existingUser);
	}

	@Override
	public void removeUser(String id) {
		User existingUser = userRepository.findById(id).orElse(null);
		existingUser.setGroups(null);
		userRepository.save(existingUser);
	}
	
	

}

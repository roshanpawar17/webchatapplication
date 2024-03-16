package com.chat.service;

import com.chat.entities.User;
import com.chat.model.UserDto;

public interface UserService {
	public User addUser(User user);
	public User updateUser(String id, UserDto user);
	public void deleteUser(String id);
	public void removeUser(String id);
}

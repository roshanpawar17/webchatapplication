package com.chat.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.chat.entities.User;

public interface UserRepository extends JpaRepository<User, String>{
	
//	@Query("select u from User where u.email=:email")
//	public User getUserByEmail(@Param("email") String email);
	
//	public User findByEmail(String email);
//	
//	@Query("update User u set password=:password where u.email=:email")
//	public User updatePassword(@Param("password") String password, @Param("email") String email);
//	
//	@Query("select u from User u where u.eemail=:username ")
//	public User getUserData(@Param("username") String username);
	
	public User findByEemail(String username);
	public User findByEid(String eid);
//	
//	@Query("select u from User u where u.username=:query ")
//	public List<User> getAllUserData(@Param("query") String query);
	
//	List<User> findByUsernameContainingIgnoreCase(String query);
	
	 // Count users by role
//    public Long countUsersByEemail(String email);
}

package com.chat.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chat.entities.RootAdmin;

public interface RootAdminRepository extends JpaRepository<RootAdmin, String> {
	
	public RootAdmin findByRemail(String email);
}

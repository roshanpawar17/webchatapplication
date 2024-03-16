package com.chat.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chat.entities.Groups;

public interface GroupRepository extends JpaRepository<Groups, String>{

}

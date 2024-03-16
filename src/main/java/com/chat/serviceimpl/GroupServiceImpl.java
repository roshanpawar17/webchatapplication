package com.chat.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chat.dao.GroupRepository;
import com.chat.dao.UserRepository;
import com.chat.entities.Groups;
import com.chat.entities.User;
import com.chat.model.GroupDto;
import com.chat.service.GroupService;

@Service
public class GroupServiceImpl implements GroupService{
	@Autowired
	public GroupRepository groupRepository;
	@Autowired
	public UserRepository userRepository;

	@Override
	public Groups createGroup(Groups group) {
		Groups createGroup=this.groupRepository.save(group);
		return createGroup;
	}
	
	public void addEmployeesToGroup(String groupId, List<String> employeeIds) {
        Groups group = groupRepository.findById(groupId).orElse(null);
        if (group == null) {
            throw new RuntimeException("Group not found");
        }
        
        List<User> employees = userRepository.findAllById(employeeIds);
        if (employees.isEmpty()) {
            throw new RuntimeException("No employees found");
        }

        for (User employee : employees) {
            employee.setGroups(group);
            userRepository.save(employee);
        }
    }

	@Override
	public Groups updateGroup(String gid, GroupDto groupDto) {
		Groups existingGroup = groupRepository.findById(gid).orElse(null);
		
		existingGroup.setGname(groupDto.getGname());
		existingGroup.setGdname(groupDto.getGdname());
		existingGroup.setGtname(groupDto.getGtname());
//        existingUser.setDate_joined(originalDateOfJoin);
		Groups updateUser = groupRepository.save(existingGroup);
		return updateUser;
	}

	@Override
	public void deleteGroup(String id) {
		Groups existingGroup = groupRepository.findById(id).orElse(null);
		this.groupRepository.delete(existingGroup);	
	}

	
}

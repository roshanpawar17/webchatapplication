package com.chat.service;

import java.util.List;

import com.chat.entities.Groups;
import com.chat.model.GroupDto;

public interface GroupService {
	
		public Groups createGroup(Groups group);
		public void addEmployeesToGroup(String groupId, List<String> employeeIds);
		public Groups updateGroup(String gid, GroupDto groupDto);
		public void deleteGroup(String id);

}

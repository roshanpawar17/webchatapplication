package com.chat.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chat.dao.RootAdminRepository;
import com.chat.entities.RootAdmin;
import com.chat.service.RootAdminService;

@Service
public class RootAdminServiceImpl implements RootAdminService{
	@Autowired
	private RootAdminRepository rootAdminRepository; 

	@Override
	public RootAdmin addRootAdmin(RootAdmin rootAdmin) {
		RootAdmin saveRootAdmin = this.rootAdminRepository.save(rootAdmin);
		return saveRootAdmin;
	}

}

package com.moz.policemanager.domain.service;

import java.util.List;

import com.moz.policemanager.ui.request.UserRequest;
import com.moz.policemanager.ui.response.UserRest;

public interface UserServiceResource {
	
	public List<UserRest> listUsers();
	public UserRest searchUserById(Long id);
	public UserRest createUser(UserRequest userRequest);
	public UserRest updateUser(UserRequest userRequest, Long id);

}

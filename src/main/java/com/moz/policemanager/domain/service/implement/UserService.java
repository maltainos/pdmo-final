package com.moz.policemanager.domain.service.implement;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moz.policemanager.domain.repository.UserRepository;
import com.moz.policemanager.domain.dto.UserDto;
import com.moz.policemanager.domain.entity.User;
import com.moz.policemanager.domain.service.UserServiceResource;
import com.moz.policemanager.domain.utils.GenerationCode;
import com.moz.policemanager.ui.request.UserRequest;
import com.moz.policemanager.ui.response.UserRest;

@Service
public class UserService implements UserServiceResource{

	@Autowired
	private UserRepository repository;
	
	@Override
	public List<UserRest> listUsers() {
		
		List<User> users = repository.findAll();
		List<UserRest> returnValue = new ArrayList<UserRest>();
		
		for(User user : users) {
			
			UserDto userDto = new UserDto();
			BeanUtils.copyProperties(user, userDto);
			
			UserRest userRest = new UserRest();
			BeanUtils.copyProperties(userDto, userRest);
			
			returnValue.add(userRest);
		}
		
		return returnValue;
	}

	@Override
	public UserRest searchUserById(Long id) {
		Optional<User> user = repository.findById(id);
		
		if(user.isPresent()) {
			
			UserDto userDto = new UserDto();
			BeanUtils.copyProperties(user.get(), userDto);
			
			UserRest returnValue = new UserRest();
			BeanUtils.copyProperties(userDto, returnValue);
		
			return returnValue;
		}
		
		return null;
	}

	@Override
	public UserRest createUser(UserRequest userRequest) {
		
		GenerationCode userCode = new GenerationCode();
		
		UserDto userDto = new UserDto();
		userDto.setCreateOn(OffsetDateTime.now());
		userDto.setCode(userCode.getCodeUser(12));
		userDto.setEncryptedPassword(userRequest.getPassword());
		
		BeanUtils.copyProperties(userRequest, userDto);
		
		
		User user = new User();
		BeanUtils.copyProperties(userDto, user);
		
		user = repository.save(user);
		UserRest userRest = new UserRest();
		BeanUtils.copyProperties(user, userRest);
		
		return userRest;
	}

	@Override
	public UserRest updateUser(UserRequest userRequest, Long id) {
		
		if(!repository.existsById(id))
			return null;
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userRequest, userDto);
		userDto.setId(id);
		userDto.setCode(null);
		userDto.setUpdateOn(OffsetDateTime.now());
		
		System.out.println(userDto);
		
		User user = new User();
		BeanUtils.copyProperties(userDto, user);
		System.out.println(user);
		user = repository.save(user);
		
		BeanUtils.copyProperties(userDto, userDto);
		
		UserRest returnValue = new UserRest();
		BeanUtils.copyProperties(userDto, returnValue);
		
		return returnValue;
	}
}


















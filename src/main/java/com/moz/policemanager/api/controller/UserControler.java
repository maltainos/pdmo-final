package com.moz.policemanager.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

import javax.validation.Valid;

import com.moz.policemanager.domain.service.implement.UserService;
import com.moz.policemanager.ui.request.UserRequest;
import com.moz.policemanager.ui.response.UserRest;

@RestController
@RequestMapping(path = "/users")
public class UserControler {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public List<UserRest> findAll(){
		return service.listUsers();
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<UserRest> findOne(@PathVariable Long id){
		
		var findValue = service.searchUserById(id);
		if(findValue != null)
			return ResponseEntity.ok(findValue);
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UserRest create(@Valid @RequestBody UserRequest userRequest){
		return service.createUser(userRequest);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UserRest> update(@Valid @RequestBody UserRequest userRequest, 
			@PathVariable Long id) {
		UserRest userRest = service.updateUser(userRequest,id);
		if(userRest != null) {
			return ResponseEntity.ok(userRest);
		}
		return ResponseEntity.notFound().build();
	}
}


















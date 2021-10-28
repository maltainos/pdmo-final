package com.moz.policemanager.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moz.policemanager.domain.service.implement.MultaService;
import com.moz.policemanager.ui.response.MultaRest;

@RestController
@RequestMapping(path = "multas")
public class MultaController {
	
	@Autowired
	private MultaService service;
	
	@GetMapping
	public List<MultaRest> listAll(){
		return service.list();
	}
	
}



















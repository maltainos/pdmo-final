package com.moz.policemanager.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.moz.policemanager.domain.service.implement.ProvinciaService;
import com.moz.policemanager.ui.request.ProvinciaRequest;
import com.moz.policemanager.ui.response.ProvinciaRest;

@RestController
@RequestMapping(path = "provincias")
public class ProvinciaController {
	
	@Autowired
	private ProvinciaService service;
	
	@GetMapping
	public List<ProvinciaRest> listAll(){
		return service.list();
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<ProvinciaRest> search(@PathVariable Long id){
		
		ProvinciaRest returnValue = service.searchProvincia(id);
		if(returnValue != null)
			return ResponseEntity.ok(returnValue);
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ProvinciaRest create(@RequestBody ProvinciaRequest provinciaRequest) {
		return service.createProvincia(provinciaRequest);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<ProvinciaRest> update(@RequestBody ProvinciaRequest provinciaRequest,
			@PathVariable Long id){
		ProvinciaRest updateValue = service.updateProvincia(provinciaRequest, id);
		if(updateValue != null)
			return ResponseEntity.ok(updateValue);
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		if(service.deleteProvincia(id)) 
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.noContent().build();
	}

}























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

import com.moz.policemanager.domain.service.implement.DistritoService;
import com.moz.policemanager.ui.request.DistritoRequest;
import com.moz.policemanager.ui.response.DistritoRest;


@RestController
@RequestMapping(path = "distritos")
public class DistritoController {
	
	@Autowired
	private DistritoService service;
	
	@GetMapping
	public List<DistritoRest> listAll(){
		return service.list();
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<DistritoRest> search(@PathVariable Long id){
		
		DistritoRest returnValue = service.search(id);
		if(returnValue != null)
			return ResponseEntity.ok(returnValue);
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public DistritoRest create(@RequestBody DistritoRequest distritoRequest) {
		return service.create(distritoRequest);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<DistritoRest> update(@RequestBody DistritoRequest distritoRequest,
			@PathVariable Long id){
		DistritoRest updateValue = service.update(distritoRequest, id);
		if(updateValue != null)
			return ResponseEntity.ok(updateValue);
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		if(service.delete(id)) 
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.noContent().build();
	}

}























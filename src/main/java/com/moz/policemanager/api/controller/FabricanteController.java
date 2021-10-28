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

import com.moz.policemanager.domain.service.implement.FabricanteService;
import com.moz.policemanager.ui.request.FabricanteRequest;
import com.moz.policemanager.ui.response.FabricanteRest;

@RestController
@RequestMapping(path = "fabricantes")
public class FabricanteController {

	@Autowired
	private FabricanteService service;
	
	@GetMapping
	public List<FabricanteRest> listAll(){
		return service.list();
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<FabricanteRest> search(@PathVariable Long id){
		
		FabricanteRest returnValue = service.searchById(id);
		if(returnValue != null)
			return ResponseEntity.ok(returnValue);
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public FabricanteRest create(@RequestBody FabricanteRequest fabricanteRequest) {
		return service.create(fabricanteRequest);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<FabricanteRest> update(@RequestBody FabricanteRequest distritoRequest,
			@PathVariable Long id){
		FabricanteRest updateValue = service.update(distritoRequest, id);
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























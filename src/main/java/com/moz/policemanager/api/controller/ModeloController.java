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

import com.moz.policemanager.domain.repository.ModeloRepository;
import com.moz.policemanager.domain.service.implement.ModeloService;
import com.moz.policemanager.ui.request.ModeloRequest;
import com.moz.policemanager.ui.response.ModeloRest;

@RestController
@RequestMapping(path = "/models")
public class ModeloController {
	
	@Autowired
	private ModeloService service;
	
	@GetMapping
	public List<ModeloRest> listAll(){
		return service.list();
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<ModeloRest> search(@PathVariable Long id){
		
		ModeloRest returnValue = service.searchById(id);
		if(returnValue != null)
			return ResponseEntity.ok(returnValue);
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ModeloRest create(@RequestBody ModeloRequest veiculoRequest) {
		return service.create(veiculoRequest);
	}
	
	@Autowired
	ModeloRepository repository;
	
	@GetMapping(path = "codigo/{code}")
	public boolean existe(@PathVariable String code){
		return repository.existsByModeloCode(code);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<ModeloRest> update(@RequestBody ModeloRequest veiculoRequest,
			@PathVariable Long id){
		ModeloRest updateValue = service.update(veiculoRequest, id);
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























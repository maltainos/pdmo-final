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

import com.moz.policemanager.domain.entity.Inflacao;
import com.moz.policemanager.domain.repository.InflacaoRepository;
import com.moz.policemanager.domain.service.implement.MultaService;
import com.moz.policemanager.domain.service.implement.VeiculoService;
import com.moz.policemanager.ui.request.MultaRequest;
import com.moz.policemanager.ui.request.VeiculoRequest;
import com.moz.policemanager.ui.response.MultaRest;
import com.moz.policemanager.ui.response.VeiculoRest;


@RestController
@RequestMapping(path = "cars")
public class VeiculoController {
	
	@Autowired
	private VeiculoService service;
	
	@Autowired
	private MultaService multaService;
	
	@GetMapping
	public List<VeiculoRest> listAll(){
		return service.list();
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<VeiculoRest> search(@PathVariable Long id){
		
		VeiculoRest returnValue = service.search(id);
		if(returnValue != null)
			return ResponseEntity.ok(returnValue);
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public VeiculoRest create(@RequestBody VeiculoRequest veiculoRequest) {
		return service.create(veiculoRequest);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<VeiculoRest> update(@RequestBody VeiculoRequest veiculoRequest,
			@PathVariable Long id){
		VeiculoRest updateValue = service.update(veiculoRequest, id);
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
	
	/**
	 * EMISSAO DE MULTAS PARA UM DETERMINADO VEICULO
	 *
	 */
	
	@Autowired
	private InflacaoRepository inflacaoRepository;
	
	@GetMapping(path = "/inflacoes")
	public List<Inflacao> list(){
		return inflacaoRepository.findAll();
	}
	
	@PostMapping(path = "/{placa}/emitir-multa")
	public MultaRest emitirMulta(@RequestBody MultaRequest multaRequest, @PathVariable String placa) {
		multaRequest.getVeiculo().setPlacCar(placa);
		MultaRest returnValue = multaService.create(multaRequest);
		return returnValue;
	}
	
	@PutMapping(path = "/{placa}/pagar-multa/{multaCode}")
	public MultaRest pagarMulta(@RequestBody MultaRequest multaRequest, @PathVariable String placa,
			@PathVariable String multaCode) {
		multaRequest.getVeiculo().setPlacCar(placa);
		MultaRest returnValue = multaService.create(multaRequest);
		return returnValue;
	}
}























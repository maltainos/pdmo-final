package com.moz.policemanager.domain.service.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moz.policemanager.domain.dto.VeiculoDto;
import com.moz.policemanager.domain.entity.Veiculo;
import com.moz.policemanager.domain.repository.VeiculoRepository;
import com.moz.policemanager.domain.service.VeiculoServiceResource;
import com.moz.policemanager.domain.utils.GenerationCode;
import com.moz.policemanager.ui.request.VeiculoRequest;
import com.moz.policemanager.ui.response.VeiculoRest;

@Service
public class VeiculoService implements VeiculoServiceResource{

	@Autowired
	private VeiculoRepository repository;
	
	@Autowired
	private ModeloService modeloService;
	
	@Autowired
	private FabricanteService fabricanteService;

	@Override
	public List<VeiculoRest> list() {
		
		List<VeiculoRest> returnValue = new ArrayList<VeiculoRest>();
		List<Veiculo> veiculos = repository.findAll();
		
		for(Veiculo veiculo : veiculos) 
			returnValue.add(fromEntityToRest(veiculo));
		return returnValue;
	}

	@Override
	public VeiculoRest search(Long id) {
		Optional<Veiculo> findValue = repository.findById(id);
		if(findValue.isPresent())
			return fromEntityToRest(findValue.get());
		return null;
	}
	
	@Override
	public VeiculoRest create(VeiculoRequest veiculoRequest) {
		
		Veiculo veiculo = fromRequestToEntity(veiculoRequest);
		GenerationCode codeResource = new GenerationCode();
		veiculo.setVeiculoCode(codeResource.getCodeResource(30));
		veiculo = repository.save(veiculo);

		return fromEntityToRest(veiculo);
	}
	
	@Override
	public Veiculo createAndApplyMulta(VeiculoRequest veiculoRequest) {
		Veiculo veiculo = fromRequestToEntity(veiculoRequest);
		GenerationCode codeResource = new GenerationCode();
		veiculo.setVeiculoCode(codeResource.getCodeResource(30));
		return repository.save(veiculo);
	}

	@Override
	public boolean delete(Long id) {
		if(repository.existsById(id)) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public VeiculoRest update(VeiculoRequest veiculoRequest, Long id) {
		if(repository.existsById(id)) {
			Veiculo veiculo = repository.save(fromRequestToEntity(veiculoRequest));
			return fromEntityToRest(veiculo);
		}
		return null;
	}
	
	private VeiculoRest fromEntityToRest(Veiculo veiculo){
		VeiculoDto veiculoDto = new VeiculoDto();
		BeanUtils.copyProperties(veiculo, veiculoDto);
		
		System.out.println(veiculo.getModelo());
		System.out.println(veiculo.getFabricante());
		VeiculoRest returnValue = new VeiculoRest();
		BeanUtils.copyProperties(veiculoDto, returnValue);
		returnValue.setModeloRest(modeloService.fromEntityToRest(veiculo.getModelo()));
		returnValue.setFabricanteRest(fabricanteService.fromEntityToRest(veiculo.getFabricante()));
		return returnValue;
	}
	
	private Veiculo fromRequestToEntity(VeiculoRequest veiculoRequest){
		VeiculoDto veiculoDto = new VeiculoDto();
		BeanUtils.copyProperties(veiculoRequest, veiculoDto);
		Veiculo returnValue = new Veiculo();
		BeanUtils.copyProperties(veiculoDto, returnValue);
		returnValue.setModelo(veiculoRequest.getModeloRequest());
		returnValue.setFabricante(veiculoRequest.getFabricanteRequest());
		return returnValue;
	}

}





























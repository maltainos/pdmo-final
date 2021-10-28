package com.moz.policemanager.domain.service.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moz.policemanager.domain.dto.MultaDto;
import com.moz.policemanager.domain.entity.Driver;
import com.moz.policemanager.domain.entity.LocalEmissao;
import com.moz.policemanager.domain.entity.Multa;
import com.moz.policemanager.domain.entity.Veiculo;
import com.moz.policemanager.domain.repository.DriverRepository;
import com.moz.policemanager.domain.repository.LocalEmissaoRepository;
import com.moz.policemanager.domain.repository.MultaRepository;
import com.moz.policemanager.domain.repository.VeiculoRepository;
import com.moz.policemanager.domain.service.MultaServiceResource;
import com.moz.policemanager.ui.request.MultaRequest;
import com.moz.policemanager.ui.response.MultaRest;

@Service
public class MultaService implements MultaServiceResource{
	
	@Autowired
	private MultaRepository repository;
	
	@Autowired
	private DriverRepository driverRepository;
	@Autowired
	private DriverService driverService;
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	@Autowired
	private VeiculoService veiculoService;
	
	@Autowired
	private LocalEmissaoRepository localEmissaoRepository;

	/**
	 * 
	 */
	@Override
	public List<MultaRest> list() {
		List<Multa> multas = repository.findAll();
		List<MultaRest> returnValue = new ArrayList<MultaRest>();
		for(Multa multa : multas)
			returnValue.add(fromEntityToRest(multa));
		return returnValue;
	}

	/**
	 * 
	 */
	@Override
	public MultaRest searchByCode(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 */
	@Override
	public MultaRest create(MultaRequest multaRequest) {
		Multa multa = new Multa(); 
		
		/**
		 * Find driver
		 */
		Optional<Driver> driver = driverRepository.
				findByCartaConducao(multaRequest.getDriver().getCartaConducao());
		/**
		 * Verify driver
		 */
		if(driver.isPresent()) {
			multa.setDriver(driver.get());
		}else {
			multa.setDriver(driverService.createAndApplyMulta(multaRequest.getDriver()));
		}
		
		/**
		 * Find Car
		 */
		Optional<Veiculo> veiculo = veiculoRepository.
				findByPlacCar(multaRequest.getVeiculo().getPlacCar());
		/**
		 * Verify Car
		 */
		if(veiculo.isPresent()) 
			multa.setVeiculo(veiculo.get());
		else
			multa.setVeiculo(veiculoService.createAndApplyMulta(multaRequest.getVeiculo()));
		/**
		 * Save localEmissao
		 */
		LocalEmissao localEmissao = localEmissaoRepository.save(multaRequest.getLocalEmissao());
		
		multa.setLocalEmissao(localEmissao);
		multa = repository.save(fromRequestToEntity(multaRequest));
		return fromEntityToRest(multa);
	}
	
	/**
	 * Convert Entity Multa to Response Multa
	 * @param multa
	 * @return Response Multa Value
	 */
	private MultaRest fromEntityToRest(Multa multa) {
		
		MultaDto multaDto = new MultaDto();
		BeanUtils.copyProperties(multa, multaDto);
		
		MultaRest returnValue = new MultaRest();
		BeanUtils.copyProperties(multaDto, returnValue);
		return returnValue;
	}
	
	/**
	 * Convert Request Multa to Entity Multa
	 * @param multaRequest
	 * @return Entity Multa Value
	 */
	private Multa fromRequestToEntity(MultaRequest multaRequest) {
		MultaDto multaDto = new MultaDto();
		BeanUtils.copyProperties(multaRequest, multaDto);
		Multa returnValue = new Multa();
		BeanUtils.copyProperties(multaDto, returnValue);
		return returnValue;
	}


	/**
	 * Buy Multa applyed for Driver and Car
	 * @param multaRest
	 * @param id
	 * @return Response Multa Value
	 */
	@Override
	public MultaRest update(MultaRest multaRest, Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}


























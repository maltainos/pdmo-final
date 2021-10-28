package com.moz.policemanager.domain.service.implement;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moz.policemanager.domain.dto.DriverDto;
import com.moz.policemanager.domain.entity.Driver;
import com.moz.policemanager.domain.repository.DriverRepository;
import com.moz.policemanager.domain.service.DriverServiceResource;
import com.moz.policemanager.domain.utils.GenerationCode;
import com.moz.policemanager.ui.request.DriverRequest;
import com.moz.policemanager.ui.response.DriverRest;


@Service
public class DriverService implements DriverServiceResource{
	
	@Autowired
	private DriverRepository repository;
	
	@Override
	public DriverRest create(DriverRequest driverRequest) {
		Driver driver = fromRequestToEntity(driverRequest);
		GenerationCode codeResource = new GenerationCode();
		driver.setDriverCode(codeResource.getCodeResource(30));
		return fromEntityToRest(repository.save(driver));
	}
	
	@Override
	public Driver createAndApplyMulta(DriverRequest driverRequest) {
		Driver driver = fromRequestToEntity(driverRequest);
		GenerationCode codeResource = new GenerationCode();
		driver.setDriverCode(codeResource.getCodeResource(30));
		return repository.save(driver);
	}
	
	private DriverRest fromEntityToRest(Driver driver) {
		
		DriverDto driverDto = new DriverDto();
		BeanUtils.copyProperties(driver, driverDto);
		
		DriverRest returnValue = new DriverRest();
		BeanUtils.copyProperties(driverDto, returnValue);
		return returnValue;
	}
	
	private Driver fromRequestToEntity(DriverRequest driverRequest) {
		DriverDto driverDto = new DriverDto();
		BeanUtils.copyProperties(driverRequest, driverDto);
		Driver returnValue = new Driver();
		BeanUtils.copyProperties(driverDto, returnValue);
		return returnValue;
	}


}

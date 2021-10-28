package com.moz.policemanager.domain.service;

import com.moz.policemanager.domain.entity.Driver;
import com.moz.policemanager.ui.request.DriverRequest;
import com.moz.policemanager.ui.response.DriverRest;

public interface DriverServiceResource {

	DriverRest create(DriverRequest driverRequest);
	Driver createAndApplyMulta(DriverRequest driverRequest);

}

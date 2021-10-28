package com.moz.policemanager.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moz.policemanager.domain.entity.Driver;

public interface DriverRepository extends JpaRepository<Driver, Long> {

	public boolean existsByCartaConducao(Object object);
	public Optional<Driver> findByCartaConducao(String cartaConducao);

}

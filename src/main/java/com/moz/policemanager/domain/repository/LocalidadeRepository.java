package com.moz.policemanager.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moz.policemanager.domain.entity.Localidade;

public interface LocalidadeRepository extends JpaRepository<Localidade, Long> {
	
	public Optional<Localidade> findByLocalidadeCode(String code);

}

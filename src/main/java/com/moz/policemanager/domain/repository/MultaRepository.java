package com.moz.policemanager.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moz.policemanager.domain.entity.Multa;

@Repository
public interface MultaRepository extends JpaRepository<Multa, Long>{
	
	public Optional<Multa> existsByMultaCode(String code);

}

package com.moz.policemanager.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moz.policemanager.domain.entity.Modelo;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long> {

	public Optional<Modelo> findByModeloCode(String code);
	public boolean existsByModeloCode(String code);

}

package com.moz.policemanager.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moz.policemanager.domain.entity.Fabricante;

@Repository
public interface FabricanteRepository extends JpaRepository<Fabricante, Long> {

	public Optional<Fabricante> findByFabricanteCode(String code);

}

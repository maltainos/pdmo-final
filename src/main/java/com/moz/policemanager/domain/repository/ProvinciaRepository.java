package com.moz.policemanager.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moz.policemanager.domain.entity.Provincia;


@Repository
public interface ProvinciaRepository extends JpaRepository<Provincia, Long>{

	public Optional<Provincia> findBySigla(String sigla);
}

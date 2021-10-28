package com.moz.policemanager.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moz.policemanager.domain.entity.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{

	public Optional<Veiculo> findByPlacCar(String placCar);

}

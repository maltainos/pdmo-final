package com.moz.policemanager.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moz.policemanager.domain.entity.Distrito;

@Repository
public interface DistritoRepository extends JpaRepository<Distrito, Long>{

}

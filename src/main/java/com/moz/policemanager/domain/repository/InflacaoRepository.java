package com.moz.policemanager.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moz.policemanager.domain.entity.Inflacao;

@Repository
public interface InflacaoRepository extends JpaRepository<Inflacao, Long> {

}

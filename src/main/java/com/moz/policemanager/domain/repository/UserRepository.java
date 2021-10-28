package com.moz.policemanager.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moz.policemanager.domain.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}

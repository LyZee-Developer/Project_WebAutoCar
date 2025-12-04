package com.example.project_api_car.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.project_api_car.entity.DB_USER;

public interface UserRepository extends  JpaRepository<DB_USER, Long> ,JpaSpecificationExecutor<DB_USER>{
    Optional<List<DB_USER>> findByCode(String Code);
}

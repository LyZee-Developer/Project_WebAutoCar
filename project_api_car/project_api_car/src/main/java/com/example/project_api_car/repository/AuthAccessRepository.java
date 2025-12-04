package com.example.project_api_car.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.project_api_car.entity.DB_AUTH_ACCESS;

public interface AuthAccessRepository extends  JpaRepository<DB_AUTH_ACCESS, Long> ,JpaSpecificationExecutor<DB_AUTH_ACCESS>{
}

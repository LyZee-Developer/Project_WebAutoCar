package com.example.project_api_car.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.project_api_car.entity.DB_BLOCK_CONTENT;

public interface  BlockContentRepository extends  JpaRepository<DB_BLOCK_CONTENT, Long>,JpaSpecificationExecutor<DB_BLOCK_CONTENT>{
}

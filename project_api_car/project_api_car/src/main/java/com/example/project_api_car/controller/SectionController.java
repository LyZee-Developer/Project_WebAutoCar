package com.example.project_api_car.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@Service
public  class SectionController {
    public static ResponseEntity<?> TestController(){
        try {
            return ResponseEntity.ok("Show me your body");
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

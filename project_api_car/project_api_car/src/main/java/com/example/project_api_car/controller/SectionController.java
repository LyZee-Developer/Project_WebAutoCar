package com.example.project_api_car.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.project_api_car.data_model.section.SectionDataModel;
@Service
public  class SectionController {
    public static ResponseEntity<?> TestController(){
        try {
            return ResponseEntity.ok("Show me your body");
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public static ResponseEntity<?> Create(SectionDataModel model){
        try {
            return ResponseEntity.ok("Show me your body2");
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public static ResponseEntity<?> Update(SectionDataModel model){
        try {
            return ResponseEntity.ok("Show me your body");
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

     public static ResponseEntity<?> Delete(Long Id){
        if(Id < 1 ) return new ResponseEntity<>("Id is required!",HttpStatus.BAD_REQUEST);
        return ResponseEntity.ok("Show me your body");
    }
}

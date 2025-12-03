package com.example.project_api_car.apicontroller;

import org.hibernate.annotations.Parameter;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.project_api_car.controller.SectionController;
import com.example.project_api_car.data_model.section.SectionDataModel;
import com.example.project_api_car.helper.SectionHelper;

import jakarta.validation.Valid;

@RestController
@Validated
public class SectionApiController {
    private SectionController sectionDataModel;
       
    @GetMapping("api/test/read")
    public ResponseEntity<?> TestController(){
        ResponseEntity<?> result = sectionDataModel.TestController();
        return new ResponseEntity<>(result.getBody(),HttpStatus.OK);
    }
    
    @PostMapping(SectionHelper.URL.List)
    public String List(){
        return "hello world from spring boot";
    }

    @PostMapping(SectionHelper.URL.Create)
    public ResponseEntity<?> Create(@Valid @RequestBody SectionDataModel model){
        ResponseEntity<?> result = sectionDataModel.Create(model);
        return new ResponseEntity<>(result.getBody(),HttpStatus.OK);
    }

    @PostMapping(SectionHelper.URL.Update)
    public ResponseEntity<?> Update(@Valid @RequestBody SectionDataModel model){
         ResponseEntity<?> result = sectionDataModel.Create(model);
        return new ResponseEntity<>(result.getBody(),HttpStatus.OK);
    }

    // @GetMapping(SectionHelper.URL.Delete+"/{id}")
    // public ResponseEntity<?> Delete(@PathVariable("id")  Long Id){
    //     var result = sectionDataModel.Delete(Id);
    //     return new ResponseEntity<>(result,HttpStatus.OK);
    // }
    @GetMapping(SectionHelper.URL.Delete)
    public ResponseEntity<?> Delete(@RequestParam(value="id")  Long Id){
        var result = sectionDataModel.Delete(Id);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
}

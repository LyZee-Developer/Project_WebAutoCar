package com.example.project_api_car.apicontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.project_api_car.controller.AuthAccessController;
import com.example.project_api_car.data_model.auth_access.AuthAccessDataModel;
import com.example.project_api_car.data_model.auth_access.AuthAccessFilterDataModel;
import com.example.project_api_car.helper.UserHelper;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@Validated
@AllArgsConstructor
public class AuthAccessApiController {
    private final AuthAccessController authAccessController;
    @PostMapping(UserHelper.URL.List)
    public ResponseEntity<?> List(@RequestBody AuthAccessFilterDataModel filer){
        var result = authAccessController.List(filer);
        return new ResponseEntity<>(result.getBody(),result.getStatusCode());
    }

    @PostMapping(UserHelper.URL.Create)
    public ResponseEntity<?> Create(@Valid @RequestBody AuthAccessDataModel model){
        var result = authAccessController.Create(model);
        return new ResponseEntity<>(result.getBody(),result.getStatusCode());
    }

    @PostMapping(UserHelper.URL.Update)
    public ResponseEntity<?> Update(@Valid @RequestBody AuthAccessDataModel model){
        var result = authAccessController.Update(model);
        return new ResponseEntity<>(result.getBody(),result.getStatusCode());
    }

    @GetMapping(UserHelper.URL.Delete)
    public ResponseEntity<?> Delete(@RequestParam(value="Id") Long Id){
        var result = authAccessController.Delete(Id);
        return new ResponseEntity<>(result.getBody(),result.getStatusCode());
    }
    @GetMapping(UserHelper.URL.CheckCode)
    public ResponseEntity<?> CheckCode(@RequestParam(value="Code") String Code){
        var result = authAccessController.CheckCode(Code);
       return new ResponseEntity<>(result.getBody(),result.getStatusCode());
    }
}

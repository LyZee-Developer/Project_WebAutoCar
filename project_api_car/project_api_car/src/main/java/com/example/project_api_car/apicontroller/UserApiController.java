package com.example.project_api_car.apicontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.project_api_car.controller.UserController;
import com.example.project_api_car.data_model.user.UserDataModel;
import com.example.project_api_car.data_model.user.UserFilterDataModel;
import com.example.project_api_car.helper.UserHelper;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class UserApiController {
    private final UserController userController;
    @PostMapping(UserHelper.URL.List)
    public ResponseEntity<?> List(@RequestBody UserFilterDataModel filer){
        var result = userController.List(filer);
        return ResponseEntity.ok(result);
    }

    @PostMapping(UserHelper.URL.Create)
    public ResponseEntity<?> Create(@Valid @RequestBody UserDataModel model){
        var result = userController.Create(model);
        return ResponseEntity.ok(result);
    }

    @PostMapping(UserHelper.URL.Update)
    public ResponseEntity<?> Update(@Valid @RequestBody UserDataModel model){
        var result = userController.Update(model);
        return ResponseEntity.ok(result);
    }

    @GetMapping(UserHelper.URL.Delete)
    public ResponseEntity<?> Delete(@RequestParam(value="Id") Long Id){
        var result = userController.Delete(Id);
        return ResponseEntity.ok(result);
    }
    @PostMapping(UserHelper.URL.List)
    public ResponseEntity<?> CheckCode(@RequestParam(value="Code") String code,@RequestParam(value="Id") Long Id){
        var result = userController.CheckCode(code,Id);
        return ResponseEntity.ok(result);
    }
}

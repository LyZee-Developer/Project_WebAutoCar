package com.example.project_api_car.apicontroller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.project_api_car.controller.BlockContentController;
import com.example.project_api_car.data_model.block_content.BlockContentDataModel;
import com.example.project_api_car.data_model.block_content.BlockContentFilterDataModel;
import com.example.project_api_car.helper.BlockContentHelper;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@Validated
@AllArgsConstructor
public class BlockContentApiController {
    private final BlockContentController blockContentController;
    
    @PostMapping(BlockContentHelper.URL.List)
    public ResponseEntity<?> List(@RequestBody BlockContentFilterDataModel filter){
        ResponseEntity<?> result = blockContentController.List(filter);
       return new ResponseEntity<>(result.getBody(),result.getStatusCode());   
    }

    @PostMapping(BlockContentHelper.URL.Create)
    public ResponseEntity<?> Create(@Valid @RequestBody BlockContentDataModel model){
        ResponseEntity<?> result = blockContentController.Create(model);
        return new ResponseEntity<>(result.getBody(),result.getStatusCode());   
    }

    @PostMapping(BlockContentHelper.URL.Update)
    public ResponseEntity<?> Update(@Valid @RequestBody BlockContentDataModel model){
        ResponseEntity<?> result = blockContentController.Update(model);
        return new ResponseEntity<>(result.getBody(),result.getStatusCode());   
    }
    
    @GetMapping(BlockContentHelper.URL.Delete)
    public ResponseEntity<?> Delete(@RequestParam(value="id")  Long Id){
        var result = blockContentController.Delete(Id);
        return new ResponseEntity<>(result.getBody(),result.getStatusCode());   
    }
}

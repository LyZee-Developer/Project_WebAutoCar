package com.example.project_api_car.controller;

import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.project_api_car.data_model.auth_access.AuthAccessDataModel;
import com.example.project_api_car.data_model.auth_access.AuthAccessFilterDataModel;
import com.example.project_api_car.helper.UserHelper;
import com.example.project_api_car.implement_service.AuthAccessImplement;
import com.example.project_api_car.implement_service.UserImplement;
import com.example.project_api_car.repository.AuthAccessRepository;
import com.example.project_api_car.security.ApiResponseHandler;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AuthAccessController {
    private final AuthAccessImplement authAccessImplement;
    private final AuthAccessRepository authAccessRepository;
    private final UserImplement userImplement;

    public ResponseEntity<?> List(AuthAccessFilterDataModel filter) {
        try {
            var result = authAccessImplement.List(filter);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponseHandler().SetDetail(e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> Create(AuthAccessDataModel model) {
        try {
            if (Objects.isNull(model.getUserId()) || model.getUserId() < 1) {
                return new ResponseEntity<>(new ApiResponseHandler().SetDetail("UserId is required!"),
                        HttpStatus.BAD_REQUEST);
            }
            var existed = userImplement.IsExistedUserById(model.getId());
            if(existed) return new ResponseEntity<>(new ApiResponseHandler().SetDetail("User not found"),HttpStatus.NOT_FOUND);
            var result = authAccessImplement.Create(model);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponseHandler().SetDetail(e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> Update(AuthAccessDataModel model) {
        try {
            if (Objects.isNull(model.getId()) || model.getId() < 1) {
                return new ResponseEntity<>(new ApiResponseHandler().SetDetail("Id is required!"),
                        HttpStatus.BAD_REQUEST);
            }
            if (Objects.isNull(model.getUserId()) || model.getUserId() < 1) {
                return new ResponseEntity<>(new ApiResponseHandler().SetDetail("UserId is required!"),
                        HttpStatus.BAD_REQUEST);
            }
            var existed = userImplement.IsExistedUserById(model.getId());
            if(existed) return new ResponseEntity<>(new ApiResponseHandler().SetDetail("User not found"),HttpStatus.NOT_FOUND);
            var isExisted = authAccessRepository.findById(model.getId());
            if (!isExisted.isPresent())
                return new ApiResponseHandler().SetDetail(UserHelper.Message.NotFound, HttpStatus.NOT_FOUND);
            var result = authAccessImplement.Update(model);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponseHandler().SetDetail(e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> Delete(Long Id) {
        if (Id < 1)
            return new ApiResponseHandler().SetDetail("Id is required!", HttpStatus.BAD_REQUEST);
        var isExisted = authAccessRepository.findById(Id);
        if (!isExisted.isPresent()) {
            return new ApiResponseHandler().SetDetail(UserHelper.Message.NotFound, HttpStatus.NOT_FOUND);
        }
        var result = authAccessImplement.Delete(Id);
        return ResponseEntity.ok(result);
    }

    public ResponseEntity<?> CheckCode(String Code) {
        var result = authAccessImplement.CheckCode(Code,0L);
        return  ResponseEntity.ok(result);
    }
}

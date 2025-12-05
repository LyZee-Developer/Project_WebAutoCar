package com.example.project_api_car.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.project_api_car.data_model.auth_access.AuthAccessDataModel;
import com.example.project_api_car.data_model.auth_access.AuthAccessFilterDataModel;
import com.example.project_api_car.dto.AuthAccessDto;

@Service
public interface AuthAccessService {
    List<AuthAccessDto> List(AuthAccessFilterDataModel filter);
    AuthAccessDto Create(AuthAccessDataModel model);
    AuthAccessDto Update(AuthAccessDataModel model);
    Boolean IsLoginSuccess(String username,String password);
    Boolean Delete(Long Id);
    Boolean CheckUsername(String name,Long Id);
}

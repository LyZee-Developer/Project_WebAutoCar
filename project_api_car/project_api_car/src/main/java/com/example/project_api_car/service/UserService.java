package com.example.project_api_car.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.project_api_car.data_model.user.UserDataModel;
import com.example.project_api_car.data_model.user.UserFilterDataModel;
import com.example.project_api_car.dto.UserDto;

@Service
public interface UserService {
    List<UserDto> List(UserFilterDataModel filter);
    UserDto Create(UserDataModel model);
    UserDto Update(UserDataModel model);
    Boolean CheckCode(String code,Long Id);
    Boolean Delete(Long Id);
}

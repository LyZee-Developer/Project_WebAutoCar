package com.example.project_api_car.data_model.auth_access;

import com.example.project_api_car.data_model.IBaseDataModel;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthAccessDataModel extends  IBaseDataModel{
    public Long Id;
    @Size(max = 1, message = "Type cannot exceed 1 characters")
    private String Type; //A(Admin) || O(Other)
    private Long UserId;
    @Size(max = 30, message = "Username cannot exceed 30 characters")
    private String UserName;
    @Size(max = 500, message = "Password cannot exceed 500 characters")
    private String Password;
    private Boolean Status;
}

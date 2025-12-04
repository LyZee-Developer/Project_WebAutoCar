package com.example.project_api_car.data_model.user;

import com.example.project_api_car.data_model.IBaseDataModel;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDataModel extends  IBaseDataModel{
    public Long Id;
    @Size(max = 50, message = "Name cannot exceed 50 characters")
    public String Name;
    @Size(max = 50, message = "Name cannot exceed 50 characters")
    public String EnglishName;
    @Size(max = 20, message = "Phone cannot exceed 20 characters")
    public String Phone;
    @Size(max = 20, message = "Phone1 cannot exceed 20 characters")
    public String Phone1;
    @Size(max = 100, message = "Name cannot exceed 50 characters")
    public String Email;
     @Size(max = 20, message = "UserCode cannot exceed 20 characters")
    public String UserCode;
    public Boolean GENDER;
}

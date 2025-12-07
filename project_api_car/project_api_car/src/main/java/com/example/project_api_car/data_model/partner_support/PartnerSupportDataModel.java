package com.example.project_api_car.data_model.partner_support;

import com.example.project_api_car.data_model.IBaseDataModel;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PartnerSupportDataModel extends  IBaseDataModel{
    public Long Id;
    @Size(max = 50, message = "Name cannot exceed 50 characters")
    public String Name;
    @Size(max = 50, message = "Name cannot exceed 50 characters")
    public String EnglishName;
    public Boolean Status;
}

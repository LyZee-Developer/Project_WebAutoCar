package com.example.project_api_car.data_model.partner_support;

import com.example.project_api_car.data_model.IBaseDataModel;
import com.example.project_api_car.data_model.upload.UploadDataModel;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PartnerSupportDataModel extends  IBaseDataModel{
    private Long Id;
    @Size(max = 50, message = "Name cannot exceed 50 characters")
    private String Name;
    @Size(max = 50, message = "Name cannot exceed 50 characters")
    private String EnglishName;
    private Boolean Status;
    private UploadDataModel upload;
}

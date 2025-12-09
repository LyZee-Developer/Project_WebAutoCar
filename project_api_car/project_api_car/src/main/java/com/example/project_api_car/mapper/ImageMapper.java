package com.example.project_api_car.mapper;


import com.example.project_api_car.data_model.upload.UploadDataModel;
import com.example.project_api_car.dto.ImageDto;
import com.example.project_api_car.entity.DB_IMAGE;

public class ImageMapper {
    public  static DB_IMAGE MaptoEntity(UploadDataModel model){
        var data = new DB_IMAGE();
        data.setHostImage(model.getHostImage());
        data.setPathImage(model.getPathImage());
        data.setSizeImage(model.getSize());
        data.setType(model.getType());
        data.setTypeImage(model.getTypeImage());
        return data;
    }
    public  static ImageDto MaptoDto(DB_IMAGE model,int recordCount){
        var data = new ImageDto();
        data.setId(model.getId());
        data.setName(model.getNameImage());
        data.setSize(model.getSizeImage());
        data.setRefId(model.getRefId());
        data.setType(model.getType());
        data.setTypeImage(model.getTypeImage());
        data.setPathImage(model.getPathImage());
        return data;
    }
}

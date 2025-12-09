package com.example.project_api_car.mapper;


import java.util.Date;

import com.example.project_api_car.data_model.partner_support.PartnerSupportDataModel;
import com.example.project_api_car.dto.PartnerSupportDto;
import com.example.project_api_car.entity.DB_PARTNER_SUPPORT;
import com.example.project_api_car.helper.GlobalHelper;

public class PartnerSupportMapper {
    public  static DB_PARTNER_SUPPORT MaptoEntity(PartnerSupportDataModel model){
        var data = new DB_PARTNER_SUPPORT();
        data.setNAME(model.getName());
        data.setNAME_EN(model.getEnglishName());
        data.setSTATUS(model.getStatus());
        data.setCREATED_BY(GlobalHelper.Str.ADMIN);
        data.setCREATED_DATE(new Date());
        data.setDB_CODE(GlobalHelper.Str.GlobalDatabase);
        return data;
    }
    public  static PartnerSupportDto MaptoDto(DB_PARTNER_SUPPORT model,int recordCount,String pathImage){
        var data = new PartnerSupportDto();
        data.setId(model.getID());
        data.setName(model.getNAME());
        data.setStatus(model.getSTATUS());
        data.setEnglishName(model.getNAME_EN());
        data.setCreatedBy(model.getCREATED_BY());
        data.setCreatedDate(model.getCREATED_DATE());
        data.setPathImage(pathImage);
        data.setRecordCount(recordCount);
        data.setDatabase(model.getDB_CODE());
        data.setUpdatedBy(model.getUPDATED_BY());
        data.setUpdatedDate(model.getUPDATED_DATE());
        return data;
    }
}

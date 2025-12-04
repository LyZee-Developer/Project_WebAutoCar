package com.example.project_api_car.mapper;


import java.util.Date;

import com.example.project_api_car.data_model.auth_access.AuthAccessDataModel;
import com.example.project_api_car.dto.AuthAccessDto;
import com.example.project_api_car.entity.DB_AUTH_ACCESS;
import com.example.project_api_car.helper.GlobalHelper;

public class AuthAccessMapper {
    public  static DB_AUTH_ACCESS MaptoEntity(AuthAccessDataModel model){
        var data = new DB_AUTH_ACCESS();
        data.setTYPE(model.getType());
        data.setUSER_ID(model.getUserId());
        data.setPASSWORD(model.getPassword());
        data.setCREATED_BY(model.getUsername());
        data.setCREATED_DATE(new Date());
        data.setDB_CODE(GlobalHelper.Str.GlobalDatabase);
        return data;
    }
    public  static AuthAccessDto MaptoDto(DB_AUTH_ACCESS model,int recordCount){
        var data = new AuthAccessDto();
        data.setId(model.getID());
        data.setUserId(model.getUSER_ID());
        data.setUsername(model.getUSERNAME());
        data.setPassword(model.getPASSWORD());
        data.setType(model.getTYPE());
        data.setRecordCount(recordCount);
        data.setCreatedBy(model.getCREATED_BY());
        data.setCreatedDate(model.getCREATED_DATE());
        data.setDatabase(model.getDB_CODE());
        data.setUpdatedBy(model.getUPDATED_BY());
        data.setUpdatedDate(model.getUPDATED_DATE());
        return data;
    }
}

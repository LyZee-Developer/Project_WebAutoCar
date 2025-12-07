package com.example.project_api_car.mapper;


import java.util.Date;

import com.example.project_api_car.data_model.block_content.BlockContentDataModel;
import com.example.project_api_car.dto.BlockContentDto;
import com.example.project_api_car.entity.DB_BLOCK_CONTENT;
import com.example.project_api_car.entity.DB_CAR;
import com.example.project_api_car.helper.GlobalHelper;

public class BlockContentMapper {
    public  static DB_BLOCK_CONTENT MaptoEntity(BlockContentDataModel model){
        var data = new DB_BLOCK_CONTENT();
        data.setSTATUS(model.getStatus());
        data.setCREATED_BY(GlobalHelper.Str.ADMIN);
        data.setCREATED_DATE(new Date());
        data.setDB_CODE(GlobalHelper.Str.GlobalDatabase);
        return data;
    }
    public  static BlockContentDto MaptoDto(DB_CAR model,int recordCount){
        var data = new BlockContentDto();
        data.setId(model.getID());
        data.setStatus(model.getSTATUS());
        data.setCreatedBy(model.getCREATED_BY());
        data.setCreatedDate(model.getCREATED_DATE());
        data.setRecordCount(recordCount);
        data.setDatabase(model.getDB_CODE());
        data.setUpdatedBy(model.getUPDATED_BY());
        data.setUpdatedDate(model.getUPDATED_DATE());
        return data;
    }
}

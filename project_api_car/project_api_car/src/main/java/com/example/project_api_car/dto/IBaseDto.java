package com.example.project_api_car.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public abstract class IBaseDto {
    private String CreatedBy;
    private Date CreatedDate;
    private String Database;
    private String UpdatedBy;
    private Date UpdatedDate;
    private Long RecordCount;
}

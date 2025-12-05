package com.example.project_api_car.dto;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class AuthAccessDto extends IBaseDto {
    public Long  Id;
    private Long UserId;
    private String Username;
    private String Password;
    private String Type;
    private Boolean Status;
}

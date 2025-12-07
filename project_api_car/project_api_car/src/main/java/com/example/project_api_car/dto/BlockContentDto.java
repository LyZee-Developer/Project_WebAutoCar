package com.example.project_api_car.dto;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class BlockContentDto extends IBaseDto{
    public Long  Id;
    private String Title;
    private String TitleEnglish;
    private String Description;
    private String SubTitle;
    private String SubTitleEnglish;
    private String DescriptionEnglish;
    private String Type;
    private Boolean Status;
}

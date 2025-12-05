package com.example.project_api_car.dto;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class BookingAppointmentDto extends IBaseDto {
    public Long Id;
    private String Fullname;
    private String Email;
    private String Phone;
    private Long ServiceId;
    private String ServiceName;
    private String ServiceEnglishName;
    private String Problem;
    private Long CarId;
    private String CarName;
    private String CarEnglishName;
    private String Year;
    private Boolean IsComplete;
}

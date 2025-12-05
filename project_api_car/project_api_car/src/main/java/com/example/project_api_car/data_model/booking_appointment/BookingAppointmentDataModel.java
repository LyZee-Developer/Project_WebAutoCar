package com.example.project_api_car.data_model.booking_appointment;

import com.example.project_api_car.data_model.IBaseDataModel;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingAppointmentDataModel extends  IBaseDataModel{
    public Long Id;
    @Size(max = 50, message = "Full Name cannot exceed 50 characters")
    private String Fullname;
    @Size(max = 255, message = "Email cannot exceed 255 characters")
    private String Email;
    @Size(max = 20, message = "Phone cannot exceed 20 characters")
    private String Phone;
    @Size(max = 1000, message = "Problem cannot exceed 1000 characters")
    private String Problem;
    private Long ServiceId;
    private Long CarId;
    private String Year;
    private Boolean IsComplete;
}

package com.example.project_api_car.controller;

import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.project_api_car.data_model.booking_appointment.BookingAppointmentDataModel;
import com.example.project_api_car.data_model.booking_appointment.BookingAppointmentFilterDataModel;
import com.example.project_api_car.helper.UserHelper;
import com.example.project_api_car.implement_service.BookingAppointmentImplement;
import com.example.project_api_car.repository.BookingAppointmentRepository;
import com.example.project_api_car.security.ApiResponseHandler;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BookingAppointmentController {
    private final BookingAppointmentImplement bookingAppointmentImplement;
    private final BookingAppointmentRepository bookingAppointmentRepository;

    public ResponseEntity<?> List(BookingAppointmentFilterDataModel filter) {
        try {
            var result = bookingAppointmentImplement.List(filter);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponseHandler().SetDetail(e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> Create(BookingAppointmentDataModel model) {
        try {
            
             if (model.getServiceId()<1){
                return new ResponseEntity<>(new ApiResponseHandler().SetDetail("The field ServiceId is required!"),
                    HttpStatus.BAD_REQUEST);
            }
            if (model.getCarId()<1){
                return new ResponseEntity<>(new ApiResponseHandler().SetDetail("The field CardId is required!"),
                    HttpStatus.BAD_REQUEST);
            }

            var result = bookingAppointmentImplement.Create(model);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponseHandler().SetDetail(e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> Update(BookingAppointmentDataModel model) {
        try {
            if (Objects.isNull(model.getId()) || model.getId() < 1) {
                return new ResponseEntity<>(new ApiResponseHandler().SetDetail("Id is required!"),
                        HttpStatus.BAD_REQUEST);
            }
            if (model.getServiceId()<1){
                return new ResponseEntity<>(new ApiResponseHandler().SetDetail("The field ServiceId is required!"),
                    HttpStatus.BAD_REQUEST);
            }
            if (model.getCarId()<1){
                return new ResponseEntity<>(new ApiResponseHandler().SetDetail("The field CardId is required!"),
                    HttpStatus.BAD_REQUEST);
            }
            // var existedCode = bookingAppointmentImplement.CheckCode(model.getUserCode(),model.getId());
            // if(existedCode) return new ResponseEntity<>(new ApiResponseHandler().SetDetail("UserCode already existed!"),HttpStatus.NOT_FOUND);
            var isExisted = bookingAppointmentRepository.findById(model.getId());
            if (!isExisted.isPresent())
                return new ApiResponseHandler().SetDetail(UserHelper.Message.NotFound, HttpStatus.NOT_FOUND);
            var result = bookingAppointmentImplement.Update(model);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponseHandler().SetDetail(e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> Delete(Long Id) {
        if (Id < 1)
            return new ApiResponseHandler().SetDetail("Id is required!", HttpStatus.BAD_REQUEST);
        var isExisted = bookingAppointmentRepository.findById(Id);
        if (!isExisted.isPresent()) {
            return new ApiResponseHandler().SetDetail(UserHelper.Message.NotFound, HttpStatus.NOT_FOUND);
        }
        var result = bookingAppointmentImplement.Delete(Id);
        return ResponseEntity.ok(result);
    }

}

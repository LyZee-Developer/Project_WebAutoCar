package com.example.project_api_car.helper;


import com.example.project_api_car.security.ApiResponseHandler;

public class BookingAppointmentHelper {
    public static class URL {
        public final static String List="api/booking_appointment/list";
        public final static String Create="api/booking_appointment/create";
        public final static String Update="api/booking_appointment/update";
        public final static String Delete="api/booking_appointment/delete";
    }
    public static class Message{
        public static final ApiResponseHandler NotFound = new ApiResponseHandler().SetDetail("Booking Appointment not found!");
    }
}

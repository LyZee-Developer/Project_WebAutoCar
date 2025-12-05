package com.example.project_api_car.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.project_api_car.entity.DB_BOOKING_APPOINTMENT;

public interface BookingAppointmentRepository extends  JpaRepository<DB_BOOKING_APPOINTMENT, Long> ,JpaSpecificationExecutor<DB_BOOKING_APPOINTMENT>{
}

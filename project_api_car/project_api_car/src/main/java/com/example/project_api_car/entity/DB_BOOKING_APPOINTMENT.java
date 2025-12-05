package com.example.project_api_car.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
@Entity
@Setter
@Getter
public class DB_BOOKING_APPOINTMENT {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long ID;
    @Column(length=50)
    private String FULL_NAME;
    @Column(length=255)
    private String EMAIL;
    @Column(length=20,nullable=false)
    private String PHONE;
    @Column(nullable=false)
    private Long SERVICE_ID;
    @Column(length=1000,nullable=false)
    private String PROBLEM;
    @Column(nullable=false)
    private Long CAR_ID;
    private String YEAR;
    @Column(nullable = false)
    private Boolean IS_COMPLETE;
    @Column(length=100,name="CREATED_BY",nullable = false)
    private String CREATED_BY;
    @Column(name="CREATED_DATE",nullable = false )
    private Date CREATED_DATE;
    @Column(length=50,name="DB_CODE")
    private String DB_CODE;
    @Column(name="UPDATED_BY",nullable = true )
    private String UPDATED_BY;
    @Column(name="UPDATED_DATE",nullable = true )
    private Date UPDATED_DATE;
}

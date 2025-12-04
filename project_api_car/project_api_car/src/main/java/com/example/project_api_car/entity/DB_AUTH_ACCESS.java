package com.example.project_api_car.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class DB_AUTH_ACCESS {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    @Column(length=1,nullable = false)
    private String TYPE; //A(Admin) || O(Other)
    private Long USER_ID;
    @Column(length=30,nullable = false,unique = true)
    private String USERNAME;
    @Column(length=500,nullable = false)
    private String PASSWORD;
    @Column(length=100,name="CREATED_BY",nullable = false)
    private String CREATED_BY;
    @Column(name="CREATED_DATE",nullable = false )
    private Date CREATED_DATE;
    @Column(length=50,name="DB_CODE",nullable = false)
    private String DB_CODE;
     @Column(name="UPDATED_BY",nullable = true )
    private String UPDATED_BY;
    @Column(name="UPDATED_DATE",nullable = true )
    private Date UPDATED_DATE;

}

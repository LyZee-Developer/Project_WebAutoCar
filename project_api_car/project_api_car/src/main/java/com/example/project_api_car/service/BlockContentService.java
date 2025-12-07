package com.example.project_api_car.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.project_api_car.data_model.car.CarDataModel;
import com.example.project_api_car.data_model.car.CarFilterDataModel;
import com.example.project_api_car.dto.BlockContentDto;

@Service
public interface BlockContentService {
    List<BlockContentDto> List(CarFilterDataModel filter);
    BlockContentDto Create(CarDataModel model);
    BlockContentDto Update(CarDataModel model);
    Boolean Delete(Long Id);
    Boolean IsExistedCar(Long CarId);
}

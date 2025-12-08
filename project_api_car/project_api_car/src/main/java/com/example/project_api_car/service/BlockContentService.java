package com.example.project_api_car.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.project_api_car.data_model.block_content.BlockContentDataModel;
import com.example.project_api_car.data_model.block_content.BlockContentFilterDataModel;
import com.example.project_api_car.dto.BlockContentDto;

@Service
public interface BlockContentService {
    List<BlockContentDto> List(BlockContentFilterDataModel filter);
    BlockContentDto Create(BlockContentDataModel model);
    BlockContentDto Update(BlockContentDataModel model);
    Boolean Delete(Long Id);
    Boolean IsExistedCar(Long CarId);
}

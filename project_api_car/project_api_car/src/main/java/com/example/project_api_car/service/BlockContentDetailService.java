package com.example.project_api_car.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.project_api_car.data_model.block_content_detail.BlockContentDetailDataModel;
import com.example.project_api_car.data_model.block_content_detail.BlockContentDetailFilterDataModel;
import com.example.project_api_car.dto.BlockContentDetailDto;

@Service
public interface BlockContentDetailService {
    List<BlockContentDetailDto> List(BlockContentDetailFilterDataModel filter);
    BlockContentDetailDto Create(BlockContentDetailDataModel model);
    BlockContentDetailDto Update(BlockContentDetailDataModel model);
    Boolean Delete(Long Id);
}

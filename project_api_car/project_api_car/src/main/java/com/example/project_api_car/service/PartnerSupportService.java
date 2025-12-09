package com.example.project_api_car.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.project_api_car.data_model.partner_support.PartnerSupportDataModel;
import com.example.project_api_car.data_model.partner_support.PartnerSupportFilterDataModel;
import com.example.project_api_car.dto.PartnerSupportDto;

@Service
public interface PartnerSupportService {
    List<PartnerSupportDto> List(PartnerSupportFilterDataModel filter);
    PartnerSupportDto Create(PartnerSupportDataModel model);
    PartnerSupportDto Update(PartnerSupportDataModel model);
    Boolean Delete(Long Id);
    Boolean DeleteImage(Long Id);
}

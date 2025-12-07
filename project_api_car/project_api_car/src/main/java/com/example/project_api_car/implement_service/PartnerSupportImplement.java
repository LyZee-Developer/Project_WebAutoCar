package com.example.project_api_car.implement_service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.project_api_car.data_model.partner_support.PartnerSupportDataModel;
import com.example.project_api_car.data_model.partner_support.PartnerSupportFilterDataModel;
import com.example.project_api_car.dto.PartnerSupportDto;
import com.example.project_api_car.helper.GlobalHelper;
import com.example.project_api_car.mapper.PartnerSupportMapper;
import com.example.project_api_car.repository.PartnerSupportRepository;
import com.example.project_api_car.service.PartnerSupportService;
import com.example.project_api_car.specification.PartnerSupportSpec;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class PartnerSupportImplement implements  PartnerSupportService {
    private final PartnerSupportRepository  partnerSupportRepository;
    @Override
    public List<PartnerSupportDto> List(PartnerSupportFilterDataModel filter){
        var list = partnerSupportRepository.findAll(PartnerSupportSpec.Search(filter.getSearch()).and(PartnerSupportSpec.OrderDir(filter.getOrderDir(),filter.getOrderBy())));
        if (filter.getStatus() != null) {
                list = list.stream()
                        .filter(s -> s.getSTATUS().equals(filter.getStatus()))
                        .collect(Collectors.toList());
        }
        if(filter.getId() != null && filter.getId()>0) list = list.stream().filter(s->s.getID().equals(filter.getId())).collect(Collectors.toList());
        var totalRecord = list.size();
         if(filter.getPage() !=null && filter.getRecord()!=null && filter.getPage()>0 && filter.getRecord()>0){
            list = list.stream().skip(filter.getPage()-1).limit(filter.getRecord()*filter.getPage()).collect(Collectors.toList());
        }
        return list.stream().map(s->PartnerSupportMapper.MaptoDto(s,totalRecord)).collect(Collectors.toList());
    }

    @Override
    public  PartnerSupportDto  Create(PartnerSupportDataModel model){
        var mapData = PartnerSupportMapper.MaptoEntity(model);
        var data = partnerSupportRepository.save(mapData);
        var result = PartnerSupportMapper.MaptoDto(data,1);
        return result;
    }

    @Override
    public PartnerSupportDto Update(PartnerSupportDataModel model){
        var data = partnerSupportRepository.findById(model.getId()).get();
        data.setNAME(model.getName());
        data.setNAME_EN(model.getEnglishName());
        data.setUPDATED_BY(GlobalHelper.Str.ADMIN);
        data.setSTATUS(model.getStatus());
        data.setUPDATED_DATE(new Date());
        data.setDB_CODE(GlobalHelper.Str.GlobalDatabase);
        partnerSupportRepository.save(data);
        var result = PartnerSupportMapper.MaptoDto(data,1);
        return result;
    }

    @Override
    public Boolean Delete(Long Id){
        partnerSupportRepository.deleteById(Id);
        return true;
    }
    
}

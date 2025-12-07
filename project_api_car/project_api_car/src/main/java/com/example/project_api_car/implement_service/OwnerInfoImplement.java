package com.example.project_api_car.implement_service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.project_api_car.data_model.owner_info.OwnerInfoDataModel;
import com.example.project_api_car.data_model.owner_info.OwnerInfoFilterDataModel;
import com.example.project_api_car.dto.OwnerInfoDto;
import com.example.project_api_car.helper.GlobalHelper;
import com.example.project_api_car.mapper.OwnerInfoMapper;
import com.example.project_api_car.repository.OwnerInfoRepository;
import com.example.project_api_car.service.OwnerInfoService;
import com.example.project_api_car.specification.OwnerInfoSpec;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class OwnerInfoImplement implements  OwnerInfoService {
    private final OwnerInfoRepository  ownerInfoRepository;
    @Override
    public List<OwnerInfoDto> List(OwnerInfoFilterDataModel filter){
        // var list = ownerInfoRepository.findAll(OwnerInfoSpec.Search(filter.getSearch()).and(OwnerInfoSpec.OrderDir(filter.getOrderDir(),filter.getOrderBy())));
        var list = ownerInfoRepository.findAll(OwnerInfoSpec.Search(filter.getSearch()).and(OwnerInfoSpec.OrderDir(filter.getOrderDir(),filter.getOrderBy())));
        if(filter.getId() != null && filter.getId()>0) list = list.stream().filter(s->s.getID().equals(filter.getId())).collect(Collectors.toList());
        var totalRecord = list.size();
         if(filter.getPage() !=null && filter.getRecord()!=null && filter.getPage()>0 && filter.getRecord()>0){
            list = list.stream().skip(filter.getPage()-1).limit(filter.getRecord()*filter.getPage()).collect(Collectors.toList());
        }
        return list.stream().map(s->OwnerInfoMapper.MaptoDto(s,totalRecord)).collect(Collectors.toList());
    }

    @Override
    public  OwnerInfoDto  Create(OwnerInfoDataModel model){
        var mapData = OwnerInfoMapper.MaptoEntity(model);
        var data = ownerInfoRepository.save(mapData);
        var result = OwnerInfoMapper.MaptoDto(data,1);
        return result;
    }

    @Override
    public OwnerInfoDto Update(OwnerInfoDataModel model){
        var data = ownerInfoRepository.findById(model.getId()).get();
        data.setNAME(model.getName());
        data.setNAME_EN(model.getEnglishName());
        data.setUPDATED_BY(GlobalHelper.Str.ADMIN);
        data.setUPDATED_DATE(new Date());
        data.setDB_CODE(GlobalHelper.Str.GlobalDatabase);
        data.setEMAIL(model.getEmail());
        data.setPHONE(model.getPhone());
        data.setPHONE1(model.getPhone1());
        data.setDESCRIPTION(model.getDescription());
        data.setFACEBOOK_URL(model.getFacebookURL());
        data.setIN_URL(model.getInURL());
        data.setINSTAGRAM_URL(model.getInstagramURL());
        data.setTELEGRAM_URL(model.getTelegramURL());
        data.setYOUTUBE_URL(model.getYoutubeURL());
        data.setWORKING_INFO(model.getWorkingInfo());
        ownerInfoRepository.save(data);
        var result = OwnerInfoMapper.MaptoDto(data,1);
        return result;
    }

    @Override
    public Boolean Delete(Long Id){
        ownerInfoRepository.deleteById(Id);
        return true;
    }
    
    @Override
    public Boolean IsExistedCar(Long CarId){
        var getCar = ownerInfoRepository.findById(CarId);
        return getCar.isPresent();
    }
    
}

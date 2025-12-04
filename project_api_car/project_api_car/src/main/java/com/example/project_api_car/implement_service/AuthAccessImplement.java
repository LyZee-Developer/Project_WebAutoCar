package com.example.project_api_car.implement_service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.project_api_car.data_model.auth_access.AuthAccessDataModel;
import com.example.project_api_car.data_model.auth_access.AuthAccessFilterDataModel;
import com.example.project_api_car.dto.AuthAccessDto;
import com.example.project_api_car.mapper.AuthAccessMapper;
import com.example.project_api_car.repository.AuthAccessRepository;
import com.example.project_api_car.service.AuthAccessService;
import com.example.project_api_car.specification.AuthAccessSpec;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class AuthAccessImplement implements  AuthAccessService {
    private final AuthAccessRepository  authAccessRepository;
    @Override
    public List<AuthAccessDto> List(AuthAccessFilterDataModel filter){
        var list = authAccessRepository.findAll(AuthAccessSpec.Search(filter.getSearch()).and(AuthAccessSpec.OrderDir(filter.getOrderDir(),filter.getOrderBy())));
        if(filter.getPage() !=null && filter.getRecord()!=null && filter.getPage()>0 && filter.getRecord()>0){
            list = list.stream().skip(filter.getPage()-1).limit(filter.getRecord()*filter.getPage()).collect(Collectors.toList());
        }
        if(filter.getId() != null && filter.getId()>0) list = list.stream().filter(s->s.getID().equals(filter.getId())).collect(Collectors.toList());
        var total = list.size();
        return list.stream().map(s->AuthAccessMapper.MaptoDto(s,total)).collect(Collectors.toList());
    }

    @Override
    public  AuthAccessDto  Create(AuthAccessDataModel model){
        var mapData = AuthAccessMapper.MaptoEntity(model);
        var data = authAccessRepository.save(mapData);
        var result = AuthAccessMapper.MaptoDto(data,1);
        return result;
    }

    @Override
    public AuthAccessDto Update(AuthAccessDataModel model){
        var data = authAccessRepository.findById(model.getId()).get();
        data.setPASSWORD(model.getPassword());
        data.setUSER_ID(model.getUserId());
        data.setUSERNAME(model.getUserName());
        data.setTYPE(model.getType());
        data.setUPDATED_DATE(new Date());
        authAccessRepository.save(data);
        var result = AuthAccessMapper.MaptoDto(data,1);
        return result;
    }

    @Override
    public Boolean Delete(Long Id){
        authAccessRepository.deleteById(Id);
        return true;
    }

    @Override
    public Boolean CheckCode(String code,Long Id){
        // var codes = authAccessRepository.findAll().stream().filter(s->s.getUSER_CODE().equals(code)).collect(Collectors.toList());
        // if(Id>0){
        //     var lists = codes.stream().filter(s->!s.getID().equals(Id)).collect(Collectors.toList());
        //     return !lists.isEmpty();
        // } 
        return  true;
    }
    
}

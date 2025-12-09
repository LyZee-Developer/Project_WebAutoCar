package com.example.project_api_car.implement_service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.project_api_car.data_model.block_content_detail.BlockContentDetailDataModel;
import com.example.project_api_car.data_model.block_content_detail.BlockContentDetailFilterDataModel;
import com.example.project_api_car.dto.BlockContentDetailDto;
import com.example.project_api_car.helper.GlobalHelper;
import com.example.project_api_car.mapper.BlockContentDetailMapper;
import com.example.project_api_car.repository.BlockContentDetailRepository;
import com.example.project_api_car.service.BlockContentDetailService;
import com.example.project_api_car.specification.BlockContentDetailSpec;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class BlockContentDetailImplement implements  BlockContentDetailService {
    private final BlockContentDetailRepository  blockContentDetailRepository;
    @Override
    public List<BlockContentDetailDto> List(BlockContentDetailFilterDataModel filter){
        var list = blockContentDetailRepository.findAll(BlockContentDetailSpec.Search(filter.getSearch()).and(BlockContentDetailSpec.OrderDir(filter.getOrderDir(),filter.getOrderBy())));
        if (filter.getStatus() != null) {
                list = list.stream()
                        .filter(s -> s.getStatus().equals(filter.getStatus()))
                        .collect(Collectors.toList());
        }
        list = list.stream().filter(s->s.getId().equals(filter.getId())).collect(Collectors.toList());
        var totalRecord = list.size();
         if(filter.getPage() !=null && filter.getRecord()!=null && filter.getPage()>0 && filter.getRecord()>0){
            list = list.stream().skip(filter.getPage()-1).limit(filter.getRecord()*filter.getPage()).collect(Collectors.toList());
        }
        return list.stream().map(s->BlockContentDetailMapper.MaptoDto(s,totalRecord)).collect(Collectors.toList());
    }

    @Override
    public  BlockContentDetailDto  Create(BlockContentDetailDataModel model){
        var mapData = BlockContentDetailMapper.MaptoEntity(model);
        var data = blockContentDetailRepository.save(mapData);
        var result = BlockContentDetailMapper.MaptoDto(data,1);
        return result;
    }

    @Override
    public BlockContentDetailDto Update(BlockContentDetailDataModel model){
        var data = blockContentDetailRepository.findById(model.getId()).get();
        data.setUpdatedBy(GlobalHelper.Str.ADMIN);
        data.setTitle(model.getTitle());
        data.setTitleEnglish(model.getTitleEnglish());
        data.setDescription(model.getDescription());
        data.setDescriptionEnglish(model.getDescriptionEnglish());
        data.setStatus(model.getStatus());
        data.setUpdatedDate(new Date());
        blockContentDetailRepository.save(data);
        var result = BlockContentDetailMapper.MaptoDto(data,1);
        return result;
    }

    @Override
    public Boolean Delete(Long Id){
        blockContentDetailRepository.deleteById(Id);
        return true;
    }
    
}

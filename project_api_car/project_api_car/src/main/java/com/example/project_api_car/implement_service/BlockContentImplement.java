package com.example.project_api_car.implement_service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.project_api_car.data_model.block_content.BlockContentDataModel;
import com.example.project_api_car.data_model.block_content.BlockContentFilterDataModel;
import com.example.project_api_car.dto.BlockContentDto;
import com.example.project_api_car.helper.GlobalHelper;
import com.example.project_api_car.mapper.BlockContentMapper;
import com.example.project_api_car.repository.BlockContentRepository;
import com.example.project_api_car.service.BlockContentService;
import com.example.project_api_car.specification.BlockContentSpec;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class BlockContentImplement implements  BlockContentService {
    private final BlockContentRepository  blockContentRepository;
    @Override
    public List<BlockContentDto> List(BlockContentFilterDataModel filter){
        var list = blockContentRepository.findAll(BlockContentSpec.Search(filter.getSearch()).and(BlockContentSpec.OrderDir(filter.getOrderDir(),filter.getOrderBy())));
       
        if (filter.getStatus() != null) {
                list = list.stream()
                        .filter(s -> s.getStatus().equals(filter.getStatus()))
                        .collect(Collectors.toList());
        }
        if(filter.getId() != null && filter.getId()>0) list = list.stream().filter(s->s.getId().equals(filter.getId())).collect(Collectors.toList());
        var totalRecord = list.size();
         if(filter.getPage() !=null && filter.getRecord()!=null && filter.getPage()>0 && filter.getRecord()>0){
            list = list.stream().skip(filter.getPage()-1).limit(filter.getRecord()*filter.getPage()).collect(Collectors.toList());
        }
        return list.stream().map(s->BlockContentMapper.MaptoDto(s,totalRecord)).collect(Collectors.toList());
    }

    @Override
    public  BlockContentDto  Create(BlockContentDataModel model){
        var mapData = BlockContentMapper.MaptoEntity(model);
        var data = blockContentRepository.save(mapData);
        var result = BlockContentMapper.MaptoDto(data,1);
        return result;
    }

    @Override
    public BlockContentDto Update(BlockContentDataModel model){
        var data = blockContentRepository.findById(model.getId()).get();
        data.setUpdatedBy(GlobalHelper.Str.ADMIN);
        data.setTitle(model.getTitle());
        data.setTitleEnglish(model.getTitleEnglish());
        data.setSubTitle(model.getSubTitle());
        data.setSubTitleEnglish(model.getSubTitleEnglish());
        data.setDescription(model.getDescription());
        data.setDescriptionEnglish(model.getDescriptionEnglish());
        data.setType(model.getType());
        data.setStatus(model.getStatus());
        data.setUpdatedDate(new Date());
        blockContentRepository.save(data);
        var result = BlockContentMapper.MaptoDto(data,1);
        return result;
    }

    @Override
    public Boolean Delete(Long Id){
        blockContentRepository.deleteById(Id);
        return true;
    }
    
    @Override
    public Boolean IsExistedCar(Long CarId){
        var getCar = blockContentRepository.findById(CarId);
        return getCar.isPresent();
    }
    
}

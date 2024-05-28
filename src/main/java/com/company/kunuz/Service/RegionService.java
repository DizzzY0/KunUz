package com.company.kunuz.Service;

import com.company.kunuz.DTO.Region.RegionCreateDTO;
import com.company.kunuz.DTO.Region.RegionDTO;
import com.company.kunuz.Entity.RegionEntity;
import com.company.kunuz.Enums.Language;
import com.company.kunuz.Exception.AppBadException;
import com.company.kunuz.Mapper.RegionMapper;
import com.company.kunuz.Repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class RegionService {
    @Autowired
    private RegionRepository regionRepository;

    /////////////////////////////////////////////////////////////////////////////////////////////
    public RegionDTO create(RegionCreateDTO dto) {
        RegionEntity entity = new RegionEntity();
        entity.setNameEn(dto.getNameEn());
        entity.setNameRu(dto.getNameRu());
        entity.setNameUz(dto.getNameUz());
        entity.setOrderNumber(dto.getOrderNumber());

        regionRepository.save(entity);

        return toDto(entity);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    public List<RegionDTO> getAll() {
        Iterable<RegionEntity> regions = regionRepository.findAll();
        List<RegionDTO> list = new ArrayList<>();
        for (RegionEntity entity : regions) {
            RegionDTO dto = new RegionDTO();
            list.add(this.toDto(entity));
        }
        return list;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    public List<RegionDTO> getAllByLang(Language lang) {
        Iterable<RegionEntity> iterable = regionRepository.findAllByVisibleTrueOrderByOrderNumberDesc();
        List<RegionDTO> dtoList = new LinkedList<>();
        for (RegionEntity entity : iterable) {
            RegionDTO dto = new RegionDTO();
            dto.setId(entity.getId());
            switch (lang) {
                case en -> dto.setName(entity.getNameEn());
                case uz -> dto.setName(entity.getNameUz());
                case ru -> dto.setName(entity.getNameRu());
            }
            dtoList.add(dto);
        }
        return dtoList;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public List<RegionDTO> getAllByLang2(Language lang) {
        List<RegionMapper> mapperList = regionRepository.findAll(lang.name());
        List<RegionDTO> dtoList = new LinkedList<>();
        for (RegionMapper entity : mapperList) {
            RegionDTO dto = new RegionDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dtoList.add(dto);
        }
        return dtoList;
    }


    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    public RegionDTO getById(Integer id) {
        RegionEntity entity = get(id);

        RegionDTO dto = new RegionDTO();
        dto.setId(entity.getId());
        dto.setNameEn(entity.getNameEn());
        dto.setNameUz(entity.getNameUz());
        dto.setNameRu(entity.getNameRu());
        dto.setVisible(entity.getVisible());
        return dto;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////


    //////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Boolean update(Integer id, RegionCreateDTO dto) {
        RegionEntity entity = get(id);
        entity.setOrderNumber(dto.getOrderNumber());
        entity.setNameUz(dto.getNameUz());
        entity.setNameRu(dto.getNameRu());
        entity.setNameEn(dto.getNameEn());
        regionRepository.save(entity);
        return true;
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Boolean delete(Integer id) {
        regionRepository.deleteById(id);
        return true;
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public RegionEntity get(Integer id) {
        return regionRepository.findById(id).orElseThrow(() -> {
            throw new AppBadException("Region not found");
        });
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public RegionDTO toDto(RegionEntity entity) {
        RegionDTO dto = new RegionDTO();
        dto.setId(entity.getId());
        dto.setNameEn(entity.getNameEn());
        dto.setNameUz(entity.getNameUz());
        dto.setNameRu(entity.getNameRu());
        dto.setOrderNumber(entity.getOrderNumber());
        dto.setCreatedDate(entity.getCreatedDate());
        return dto;
    }


}

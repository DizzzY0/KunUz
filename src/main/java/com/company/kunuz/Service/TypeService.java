package com.company.kunuz.Service;

import com.company.kunuz.DTO.Category.CategoryCreateDTO;
import com.company.kunuz.DTO.Category.CategoryDTO;
import com.company.kunuz.DTO.Type.TypeCreateDTO;
import com.company.kunuz.DTO.Type.TypeDTO;
import com.company.kunuz.Entity.CategoryEntity;
import com.company.kunuz.Entity.TypeEntity;
import com.company.kunuz.Enums.Language;
import com.company.kunuz.Exception.AppBadException;
import com.company.kunuz.Mapper.CategoryMapper;
import com.company.kunuz.Mapper.TypeMapper;
import com.company.kunuz.Repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class TypeService {
    @Autowired
    private TypeRepository typeRepository;


    //////////////////////////CREATE/////////////////////////
    public TypeDTO create(TypeCreateDTO dto) {
        TypeEntity entity = new TypeEntity();
        entity.setNameEn(dto.getNameEn());
        entity.setNameRu(dto.getNameRu());
        entity.setNameUz(dto.getNameUz());
        entity.setOrderNumber(dto.getOrderNumber());

        typeRepository.save(entity);

        return toDto(entity);
    }



    //////////////////////////GET ALL/////////////////////////
    public List<TypeDTO> getAll() {
        Iterable<TypeEntity> categories = typeRepository.findAll();
        List<TypeDTO> list = new ArrayList<>();
        for (TypeEntity entity : categories) {
            TypeDTO dto = new TypeDTO();
            list.add(this.toDto(entity));
        }
        return list;
    }




    //////////////////////////GET ALL BY LANG/////////////////////////
    public List<TypeDTO> getAllByLang(Language lang) {
        Iterable<TypeEntity> iterable = typeRepository.findAllByVisibleTrueOrderByOrderNumberDesc();
        List<TypeDTO> dtoList = new LinkedList<>();
        for (TypeEntity entity : iterable) {
            TypeDTO dto = new TypeDTO();
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






    //////////////////////////GET ALL BY LANG 2/////////////////////////
    public List<TypeDTO> getAllByLang2(Language lang) {
        List<TypeMapper> mapperList = typeRepository.findAll(lang.name());
        List<TypeDTO> dtoList = new LinkedList<>();
        for (TypeMapper entity : mapperList) {
            TypeDTO dto = new TypeDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dtoList.add(dto);
        }
        return dtoList;
    }




    //////////////////////////GET BY ID/////////////////////////
    public TypeDTO getById(Integer id) {
        TypeEntity entity = get(id);

        TypeDTO dto = new TypeDTO();
        dto.setId(entity.getId());
        dto.setNameEn(entity.getNameEn());
        dto.setNameUz(entity.getNameUz());
        dto.setNameRu(entity.getNameRu());
        dto.setVisible(entity.getVisible());
        return dto;
    }



    //////////////////////////UPDATE/////////////////////////
    public Boolean update(Integer id, TypeCreateDTO dto) {
        TypeEntity entity = get(id);
        entity.setOrderNumber(dto.getOrderNumber());
        entity.setNameUz(dto.getNameUz());
        entity.setNameRu(dto.getNameRu());
        entity.setNameEn(dto.getNameEn());
        typeRepository.save(entity);
        return true;
    }






    //////////////////////////DELETE/////////////////////////
    public Boolean delete(Integer id) {
        typeRepository.deleteById(id);
        return true;
    }





    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private TypeDTO toDto(TypeEntity entity) {
        TypeDTO dto = new TypeDTO();
        dto.setId(entity.getId());
        dto.setNameEn(entity.getNameEn());
        dto.setNameUz(entity.getNameUz());
        dto.setNameRu(entity.getNameRu());
        dto.setOrderNumber(entity.getOrderNumber());
        dto.setCreatedDate(entity.getCreatedDate());
        return dto;
    }



    public TypeEntity get(Integer id) {
        return typeRepository.findById(id).orElseThrow(() -> new AppBadException("Category not found"));
    }
}

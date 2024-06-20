package com.company.kunuz.Service;

import com.company.kunuz.DTO.Category.CategoryCreateDTO;
import com.company.kunuz.DTO.Category.CategoryDTO;
import com.company.kunuz.Entity.CategoryEntity;
import com.company.kunuz.Enums.Language;
import com.company.kunuz.Exception.AppBadException;
import com.company.kunuz.Mapper.CategoryMapper;
import com.company.kunuz.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;


    //////////////////////////CREATE/////////////////////////
    public CategoryDTO create(CategoryCreateDTO dto) {
        CategoryEntity entity = new CategoryEntity();
        entity.setNameEn(dto.getNameEn());
        entity.setNameRu(dto.getNameRu());
        entity.setNameUz(dto.getNameUz());
        entity.setOrderNumber(dto.getOrderNumber());

        categoryRepository.save(entity);

        return toDto(entity);
    }


    //////////////////////////GET ALL/////////////////////////
    public List<CategoryDTO> getAll() {
        Iterable<CategoryEntity> categories = categoryRepository.findAll();
        List<CategoryDTO> list = new ArrayList<>();
        for (CategoryEntity entity : categories) {
            CategoryDTO dto = new CategoryDTO();
            list.add(this.toDto(entity));
        }
        return list;
    }


    //////////////////////////GET ALL BY LANG/////////////////////////
    public List<CategoryDTO> getAllByLang(Language lang) {
        Iterable<CategoryEntity> iterable = categoryRepository.findAllByVisibleTrueOrderByOrderNumberDesc();
        List<CategoryDTO> dtoList = new LinkedList<>();
        for (CategoryEntity entity : iterable) {
            CategoryDTO dto = new CategoryDTO();
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
    public List<CategoryDTO> getAllByLang2(Language lang) {
        List<CategoryMapper> mapperList = categoryRepository.findAll(lang.name());
        List<CategoryDTO> dtoList = new LinkedList<>();
        for (CategoryMapper entity : mapperList) {
            CategoryDTO dto = new CategoryDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dtoList.add(dto);
        }
        return dtoList;
    }


    //////////////////////////GET BY ID/////////////////////////
    public CategoryDTO getById(Integer id) {
        CategoryEntity entity = get(id);

        CategoryDTO dto = new CategoryDTO();
        dto.setId(entity.getId());
        dto.setNameEn(entity.getNameEn());
        dto.setNameUz(entity.getNameUz());
        dto.setNameRu(entity.getNameRu());
        dto.setVisible(entity.getVisible());
        return dto;
    }


    //////////////////////////UPDATE/////////////////////////
    public Boolean update(Integer id, CategoryCreateDTO dto) {
        CategoryEntity entity = get(id);
        entity.setOrderNumber(dto.getOrderNumber());
        entity.setNameUz(dto.getNameUz());
        entity.setNameRu(dto.getNameRu());
        entity.setNameEn(dto.getNameEn());
        categoryRepository.save(entity);
        return true;
    }


    //////////////////////////DELETE/////////////////////////
    public Boolean delete(Integer id) {
        categoryRepository.deleteById(id);
        return true;
    }


    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private CategoryDTO toDto(CategoryEntity entity) {
        CategoryDTO dto = new CategoryDTO();
        dto.setId(entity.getId());
        dto.setNameEn(entity.getNameEn());
        dto.setNameUz(entity.getNameUz());
        dto.setNameRu(entity.getNameRu());
        dto.setOrderNumber(entity.getOrderNumber());
        dto.setCreatedDate(entity.getCreatedDate());
        return dto;
    }


    public CategoryEntity get(Integer id) {
        return categoryRepository.findById(id).orElseThrow(() -> new AppBadException("Category not found"));
    }


    public CategoryDTO getCategory(Integer id, Language lang) {
        CategoryEntity entity = get(id);
        CategoryDTO dto = new CategoryDTO();
        dto.setId(entity.getId());
        switch (lang) {
            case uz -> dto.setName(entity.getNameUz());
            case ru -> dto.setName(entity.getNameRu());
            default -> dto.setName(entity.getNameEn());
        }
        return dto;
    }

}

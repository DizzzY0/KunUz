package com.company.kunuz.DTO.Category;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryCreateDTO {
    private Integer orderNumber;
    private String nameUz;
    private String nameRu;
    private String nameEn;
}
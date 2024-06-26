package com.company.kunuz.DTO.Category;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryCreateDTO {
    private Integer orderNumber;
    private String nameUz;
    private String nameRu;
    private String nameEn;
}

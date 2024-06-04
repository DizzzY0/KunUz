package com.company.kunuz.DTO.Article;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleCreateDTO {
    @NotBlank(message = "title required")
    private String title;
    @NotBlank(message = "description required")
    private String description;
    @NotBlank(message = "content required")
    private String content;
    @NotBlank(message = "imageId required")
    private Integer imageId;
    @NotBlank(message = "regionId required")
    private Integer regionId;
    @NotBlank(message = "category required")
    private Integer categoryId;
    @NotBlank(message = "articleTypeId required")
    private Integer[] articleTypes;
}

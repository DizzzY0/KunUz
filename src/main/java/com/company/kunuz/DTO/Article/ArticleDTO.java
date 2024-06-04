package com.company.kunuz.DTO.Article;

import com.company.kunuz.Enums.ArticleStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleDTO {
    //title,description,content,image_id, region_id,category_id, articleType(array)
    private Integer id;
    private String title;
    private String description;
    private String content;
    private Integer imageId;
    private Integer regionId;
    private Integer categoryId;
    private Integer[] articleTypes;
    private ArticleStatus status;
}

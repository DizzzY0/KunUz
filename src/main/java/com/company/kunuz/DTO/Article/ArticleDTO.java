package com.company.kunuz.DTO.Article;

import com.company.kunuz.DTO.AttachDTO;
import com.company.kunuz.DTO.Category.CategoryDTO;
import com.company.kunuz.DTO.Region.RegionDTO;
import com.company.kunuz.Entity.ArticleTypeEntity;
import com.company.kunuz.Enums.ArticleStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ArticleDTO {

    private String id;

    private String title;

    private String description;

    private String content;

    private Integer imageId;

    private Integer regionId;

    private RegionDTO region;

    private CategoryDTO category;

    private Integer categoryId;

    private List<ArticleTypeEntity> articleTypes;

    private ArticleStatus status;

    private LocalDate createdDate;

    private AttachDTO image;

    private int sharedCount;

    private int likeCount;
}

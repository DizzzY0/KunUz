package com.company.kunuz.Entity;

import com.company.kunuz.Enums.ArticleStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "article")
@Getter
@Setter

public class ArticleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "content")
    private String content;
    @Column(name = "image_id")
    private Integer imageId;
    @Column(name = "region_id")
    private Integer regionId;
    @Column(name = "category_id")
    private Integer categoryId;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private ArticleStatus status;
}

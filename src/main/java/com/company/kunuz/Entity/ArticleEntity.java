package com.company.kunuz.Entity;

import com.company.kunuz.Enums.ArticleStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "article")
@Getter
@Setter

public class ArticleEntity {
    @Id
    @GeneratedValue(generator = "uuid-hibernate-generator")
    @GenericGenerator(name = "uuid-hibernate-generator", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;


    @Column(name = "title")
    private String title;


    @Column(name = "description")
    private String description;


    @Column(name = "content")
    private String content;


    @Column(name = "image_id")
    private Integer imageId;


    @Column(name = "moderator_id")
    private Integer moderatorId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "moderator_id", insertable = false, updatable = false)
    private ProfileEntity moderator;


    @Column(name = "region_id")
    private Integer regionId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id", insertable = false, updatable = false)
    private RegionEntity region;


    @Column(name = "category_id")
    private Integer categoryId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    private CategoryEntity category;


    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private ArticleStatus status = ArticleStatus.NOT_PUBLISHED;


    @OneToMany(mappedBy = "article")
    private List<ArticleTypeEntity> articleTypes;


    @Column(name = "visible")
    private Boolean visible = Boolean.TRUE;


    @Column(name = "created_date")
    private LocalDate createdDate = LocalDate.now();
}

package com.company.kunuz.Entity;

import com.company.kunuz.Enums.EmotionStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "article_like")
public class ArticleLikeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "profile_id")
    private Integer profileId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id", insertable = false, updatable = false)
    private ProfileEntity profile;

    @Column(name = "article_id")
    private String articleId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id", insertable = false, updatable = false)
    private ArticleEntity article;

    @Column(name = "created_date")
    private LocalDateTime createdDate = LocalDateTime.now();

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private EmotionStatus status;

    @Column(name = "like_count")
    private int likeCount;

    @Column(name = "dislike_count")
    private int dislikeCount;

    @Column(name = "view_count")
    private int viewCount;

}

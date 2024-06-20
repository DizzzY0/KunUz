package com.company.kunuz.Mapper;

import java.time.LocalDate;

public interface ArticleShortInfoMapper {
    String getId();

    String getTitle();

    String getDescription();

    String getImageId();

    LocalDate getPublishedDate();
}


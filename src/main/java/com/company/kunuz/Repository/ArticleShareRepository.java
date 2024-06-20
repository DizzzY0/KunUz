package com.company.kunuz.Repository;

import com.company.kunuz.Entity.ArticleShareEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ArticleShareRepository extends CrudRepository<ArticleShareEntity, Integer> {

    @Query(value = "select count(a) from  ArticleShareEntity a where a.articleId =?1 ")
    int getSharedCount(String articleId);

}

package com.company.kunuz.Repository;

import com.company.kunuz.Entity.ArticleLikeEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ArticleLikeRepository extends CrudRepository<ArticleLikeEntity, Integer> {

    @Query("select count(a) from ArticleLikeEntity as a where a.articleId =?1 and a.status ='LIKE' ")
    int getArticleLikeCount(String articleId);

}

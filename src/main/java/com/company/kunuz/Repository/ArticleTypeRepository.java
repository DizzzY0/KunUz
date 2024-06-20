package com.company.kunuz.Repository;

import com.company.kunuz.Entity.ArticleTypeEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ArticleTypeRepository extends CrudRepository<ArticleTypeEntity, Integer> {



    @Modifying
    @Transactional
    void deleteAllByArticleId(String articleId);

    @Query("Select a.typesId from ArticleTypeEntity as a where a.articleId =?1 ")
    List<Integer> findAllTypesIdByArticleId(String articleId);

    @Modifying
    @Transactional
    @Query("delete from ArticleTypeEntity  where articleId =?1 and typesId =?2")
    void deleteByArticleIdAndTypesId(String articleId, Integer typesId);


}

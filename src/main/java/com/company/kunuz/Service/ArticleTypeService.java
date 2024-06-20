package com.company.kunuz.Service;

import com.company.kunuz.Entity.ArticleTypeEntity;
import com.company.kunuz.Repository.ArticleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ArticleTypeService {
    @Autowired
    private ArticleTypeRepository articleTypeRepository;

    public void create(String articleId, Integer[] types) {
        for (Integer typesId : types) {
            create(articleId, typesId);
        }
    }

    public void create(String articleId, Integer typesId) {
        ArticleTypeEntity entity = new ArticleTypeEntity();
        entity.setArticleId(articleId);
        entity.setTypesId(typesId);
        articleTypeRepository.save(entity);
    }


    public void merge(String articleId, List<Integer> newList) {
        // newList  3,4,5
        // oldList  1,2,3,4
        /*articleTypesRepository.deleteAllByArticleId(articleId);
        create(articleId, newList);*/
        Objects.requireNonNull(newList);
        List<Integer> oldLists = articleTypeRepository.findAllTypesIdByArticleId(articleId);
        oldLists.forEach(oldId -> {
            if (!newList.contains(oldId)) {
                articleTypeRepository.deleteByArticleIdAndTypesId(articleId, oldId);
            }
        });
        newList.forEach(newId -> {
            if (!oldLists.contains(newId)) {
                create(articleId, newId);
            }
        });
    }

}

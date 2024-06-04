package com.company.kunuz.Service;

import com.company.kunuz.DTO.Article.ArticleCreateDTO;
import com.company.kunuz.DTO.Article.ArticleDTO;
import com.company.kunuz.Entity.ArticleEntity;
import com.company.kunuz.Entity.ArticleTypeEntity;
import com.company.kunuz.Repository.ArticleRepository;
import com.company.kunuz.Repository.ArticleTypeRepository;
import com.company.kunuz.Repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ArticleTypeRepository articleTypeRepository;

    @Autowired
    private TypeRepository typeRepository;

//    public ArticleDTO create(ArticleCreateDTO article) {
//        ArticleEntity entity = new ArticleEntity();
//        ArticleTypeEntity  entityType = new ArticleTypeEntity();
//
//
//        entity.setTitle(article.getTitle());
//        entity.setDescription(article.getDescription());
//        entity.setContent(article.getContent());
//        entity.setCategoryId(article.getCategoryId());
//        entity.setRegionId(article.getRegionId());
//        entity.setImageId(article.getImageId());
//
//        articleRepository.save(entity);
//
//        for (int i = 0; i < article.getArticleTypes().length; i++) {
//            entityType.setArticle(entity);
//            entityType.setType(typeRepository.findById(article.getArticleTypes()[i]).get());
//            articleypeRepository.save(entityType);
//        }
//        return toDTO(entity, article.getArticleTypes());
//    }


    public ArticleDTO toDTO(ArticleEntity articleEntity, Integer[] articleType) {
       ArticleDTO dto = new ArticleDTO();
       dto.setId(articleEntity.getId());
       dto.setTitle(articleEntity.getTitle());
       dto.setDescription(articleEntity.getDescription());
       dto.setContent(articleEntity.getContent());
       dto.setCategoryId(articleEntity.getCategoryId());
       dto.setRegionId(articleEntity.getRegionId());
       dto.setImageId(articleEntity.getImageId());
       dto.setArticleTypes(articleType);
       return dto;


    }
}

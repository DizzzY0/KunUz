package com.company.kunuz.Service;

import com.company.kunuz.DTO.Article.ArticleCreateDTO;
import com.company.kunuz.DTO.Article.ArticleDTO;
import com.company.kunuz.Entity.ArticleEntity;
import com.company.kunuz.Entity.ArticleShareEntity;
import com.company.kunuz.Entity.ArticleTypeEntity;
import com.company.kunuz.Entity.ProfileEntity;
import com.company.kunuz.Enums.ArticleStatus;
import com.company.kunuz.Enums.Language;
import com.company.kunuz.Exception.AppBadException;
import com.company.kunuz.Mapper.ArticleShortInfoMapper;
import com.company.kunuz.Repository.*;
import com.company.kunuz.Util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ArticleTypeRepository articleTypeRepository;

    @Autowired
    private TypeRepository typeRepository;

    @Autowired
    private ArticleTypeService articleTypeService;

    @Autowired
    private AttachService attachService;

    @Autowired
    private RegionService regionService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ArticleLikeRepository articleLikeRepository;

    @Autowired
    private ArticleShareRepository articleShareRepository;


    public ArticleDTO create(ArticleCreateDTO article) {
        ArticleEntity entity = new ArticleEntity();
        ProfileEntity moderator = SecurityUtil.getProfile();

        entity.setTitle(article.getTitle());
        entity.setDescription(article.getDescription());
        entity.setContent(article.getContent());
        entity.setCategoryId(article.getCategoryId());
        entity.setRegionId(article.getRegionId());
        entity.setImageId(article.getImageId());
        entity.setModeratorId(moderator.getId());
        articleTypeService.create(entity.getId(), article.getArticleTypes());
        articleRepository.save(entity);

        return toDTO(entity);
    }//////


    public ArticleDTO toDTO(ArticleEntity entity) {
        ArticleDTO dto = new ArticleDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setContent(entity.getContent());
        dto.setCategoryId(entity.getCategoryId());
        dto.setRegionId(entity.getRegionId());
        dto.setImageId(entity.getImageId());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setStatus(entity.getStatus());
        dto.setArticleTypes(entity.getArticleTypes());

        return dto;

    }


    public ArticleDTO update(String articleId, ArticleCreateDTO dto) {
        ArticleEntity entity = get(articleId);
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setContent(dto.getContent());
        entity.setImageId(dto.getImageId());
        entity.setRegionId(dto.getRegionId());
        entity.setCategoryId(dto.getCategoryId());
        entity.setStatus(ArticleStatus.NOT_PUBLISHED);
        articleRepository.save(entity);

        articleTypeService.merge(articleId, Arrays.asList(dto.getArticleTypes()));
        return toDTO(entity);
    }


    public ArticleEntity get(String id) {
        return articleRepository.findByIdAndVisibleTrue(id).orElseThrow(() -> new AppBadException("Article not found"));
    }


    public List<ArticleDTO> getLast5ByTypes(Integer typesId) {
        // id(uuid),title,description,image(id,url),published_date
        List<ArticleShortInfoMapper> mapperList = articleRepository.getLastNByTypesId(typesId, 5);
        List<ArticleDTO> dtoList = new LinkedList<>();
        for (ArticleShortInfoMapper mapper : mapperList) {
            ArticleDTO dto = new ArticleDTO();
            dto.setId(mapper.getId());
            dto.setTitle(mapper.getTitle());
            dto.setDescription(mapper.getDescription());
            dto.setCreatedDate(mapper.getPublishedDate());
            dto.setImage(attachService.getDTOWithURL(mapper.getImageId()));
            dtoList.add(dto);
        }
        return dtoList;
    }


    public List<ArticleDTO> getLast3ByTypes(Integer typesId) {
        List<ArticleShortInfoMapper> mapperList = articleRepository.getLastNByTypesId(typesId, 3);
        return mapperList.stream()
                .map(mapper -> toDTO(mapper))
                .collect(Collectors.toList());
    }


    public ArticleDTO toDTO(ArticleShortInfoMapper mapper) {
        ArticleDTO dto = new ArticleDTO();
        dto.setId(mapper.getId());
        dto.setTitle(mapper.getTitle());
        dto.setDescription(mapper.getDescription());
        dto.setCreatedDate(mapper.getPublishedDate());
        dto.setImage(attachService.getDTOWithURL(mapper.getImageId()));
        return dto;
    }


    public List<ArticleDTO> getLast8Article(List<String> idList) {
        List<ArticleShortInfoMapper> mapperList = articleRepository.getLast8(idList);
        return mapperList.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }


    public ArticleDTO getById(String id, Language lang) {
        ArticleEntity entity = get(id);
        if (!entity.getStatus().equals(ArticleStatus.PUBLISHED)) {
            throw new AppBadException("Article not found");
        }
        ArticleDTO dto = new ArticleDTO();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setContent(entity.getContent());
        dto.setSharedCount(articleShareRepository.getSharedCount(id)); //----------------------------------------------
        dto.setRegion(regionService.getRegion(entity.getRegionId(), lang));
        dto.setCategory(categoryService.getCategory(entity.getCategoryId(), lang));
//        dto.setLikeCount(articleLikeRepository.getArticleLikeCount(id));

        dto.setCreatedDate(entity.getCreatedDate());
        // id(uuid),title,description,content,shared_count,
        // region(id,name),category(key,name),published_date,view_count,like_count,
        // tagList(name)


        return dto;
    }

    public Boolean delete(Integer id) {
        articleRepository.deleteById(id);
        return true;
    }

//    public Boolean changeStatus(Integer id, ArticleStatus status) {
//        articleRepository.changeStatus(id, status.toString());
//        return true;
//    }
}




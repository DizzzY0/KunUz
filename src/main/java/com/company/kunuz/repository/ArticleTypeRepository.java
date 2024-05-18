package com.company.kunuz.repository;

import com.company.kunuz.Entity.ArticleTypeEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.repository.CrudRepository;

public interface ArticleTypeRepository extends CrudRepository<ArticleTypeEntity, Integer> {
}

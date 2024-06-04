package com.company.kunuz.Repository;

import com.company.kunuz.Entity.ArticleEntity;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<ArticleEntity, Integer> {

}

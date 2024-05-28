package com.company.kunuz.Repository;

import com.company.kunuz.Entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<CategoryEntity, Integer> {
}

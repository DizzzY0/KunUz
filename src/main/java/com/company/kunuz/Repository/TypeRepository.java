package com.company.kunuz.Repository;

import com.company.kunuz.Entity.CategoryEntity;
import com.company.kunuz.Entity.TypeEntity;
import com.company.kunuz.Mapper.CategoryMapper;
import com.company.kunuz.Mapper.TypeMapper;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TypeRepository extends CrudRepository<TypeEntity, Integer> {
//    @NotNull
//    Optional<TypeEntity> findById(Integer id);

    List<TypeEntity> findAllByVisibleTrueOrderByOrderNumberDesc();


    @Query("from TypeEntity where visible = true order by orderNumber desc")
    List<TypeEntity> findAllVisible();



    @Query(value = " select id, " +
            " CASE :lang " +
            "   WHEN 'UZ' THEN name_uz " +
            "   WHEN 'EN' THEN name_en " +
            "   WHEN 'RU' THEN name_ru " +
            "  END as name " +
            "from types order by order_number desc; ", nativeQuery = true)
    List<TypeMapper> findAll(@Param("lang") String lang);


}

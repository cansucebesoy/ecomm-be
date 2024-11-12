package com.workintech.ecomm.repository;

import com.workintech.ecomm.entity.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SubcategoryRepository extends JpaRepository<Subcategory, Long> {

    Optional<Subcategory> findBySubcategoryId(long subcategoryId);
    List<Subcategory> findByParentCategoryId(long parentCategoryId);
}

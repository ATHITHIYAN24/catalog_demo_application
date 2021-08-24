package com.omnirio.catalog.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.omnirio.catalog.model.Category;
import com.omnirio.catalog.model.CategoryAttribute;

@Repository
public interface CategoryAttributeRepository extends JpaRepository<CategoryAttribute, Long> {
	
	List<CategoryAttribute> findByCategory(Category category);
}

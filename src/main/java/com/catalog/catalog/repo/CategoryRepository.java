package com.catalog.catalog.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.catalog.catalog.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	
}

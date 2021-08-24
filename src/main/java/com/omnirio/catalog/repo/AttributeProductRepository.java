package com.omnirio.catalog.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.omnirio.catalog.model.ProductAttribute;

@Repository
public interface AttributeProductRepository extends JpaRepository<ProductAttribute,Long> {
	
	@Query("select pa from ProductAttribute pa where pa.product.id=:productId")
	public List<ProductAttribute> findByProductId(@Param("productId") Long productId);
}

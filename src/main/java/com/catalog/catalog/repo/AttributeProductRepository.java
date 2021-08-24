package com.catalog.catalog.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.catalog.catalog.model.Attribute;
import com.catalog.catalog.model.ProductAttribute;

@Repository
public interface AttributeProductRepository extends JpaRepository<ProductAttribute,Long> {
	
	@Query("select pa.attribute from ProductAttribute pa where pa.product.id=:productId")
	public List<Attribute> findByProduct(@Param("productId") Long productId);
	
	@Query("select pa from ProductAttribute pa where pa.product.id=:productId and pa.attribute.id=:attributeId")
	public ProductAttribute findByProductIdAndAttributeId(@Param("productId") Long productId,@Param("attributeId") Long attributeId);
}

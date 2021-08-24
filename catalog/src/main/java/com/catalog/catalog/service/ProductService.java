package com.catalog.catalog.service;

import java.util.List;

import com.catalog.catalog.model.Attribute;
import com.catalog.catalog.model.Product;
import com.catalog.catalog.wapper.ProductResponse;

public interface ProductService {

	String insertProduct(Product product);

	ProductResponse getProduct(Long productId);

	ProductResponse addAttributesToProduct(Long productId, List<Attribute> attributes);

}

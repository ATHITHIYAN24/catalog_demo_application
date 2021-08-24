package com.catalog.catalog.service;

import java.util.List;

import com.catalog.catalog.model.Product;
import com.catalog.catalog.wapper.ProductResponse;
import com.catalog.catalog.wapper.ProdutAttributeRequest;

public interface ProductService {

	Product insertProduct(Product product);

	ProductResponse getProduct(Long productId);

	ProductResponse addAttributesToProduct(Long productId, List<ProdutAttributeRequest> produtAttributeRequests);

}

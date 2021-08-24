package com.omnirio.catalog.service;

import java.util.List;

import com.omnirio.catalog.model.Product;
import com.omnirio.catalog.wapper.ProductRequest;
import com.omnirio.catalog.wapper.ProductResponse;
import com.omnirio.catalog.wapper.ProdutAttributeRequest;

public interface ProductService {

	ProductResponse insertProduct(ProductRequest productRequest);

	ProductResponse getProduct(Long productId);
}

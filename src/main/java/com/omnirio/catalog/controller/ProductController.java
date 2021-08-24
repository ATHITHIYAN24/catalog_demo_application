package com.omnirio.catalog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.omnirio.catalog.model.Product;
import com.omnirio.catalog.service.ProductService;
import com.omnirio.catalog.wapper.ProductRequest;
import com.omnirio.catalog.wapper.ProductResponse;
import com.omnirio.catalog.wapper.ProdutAttributeRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//This controller having two api for insert and get product.
//And one api for adding attributes to product
@RestController
@Api(value="Product" , description="Operations Product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="product",method=RequestMethod.POST)
	@ApiOperation(value="Add Product", response=Product.class)
	public ProductResponse addProduct(@RequestBody ProductRequest productRequest){
		return productService.insertProduct(productRequest);
	}
	
	@RequestMapping(value="product/{productId}",method=RequestMethod.GET)
	@ApiOperation(value="Get Product", response=ProductResponse.class)
	public ProductResponse getProduct(@PathVariable("productId") Long productId){
		return productService.getProduct(productId);
	}
	
}

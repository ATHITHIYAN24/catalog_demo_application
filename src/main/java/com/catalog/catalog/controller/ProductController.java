package com.catalog.catalog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.catalog.catalog.model.Product;
import com.catalog.catalog.service.ProductService;
import com.catalog.catalog.wapper.ProductResponse;
import com.catalog.catalog.wapper.ProdutAttributeRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="Product" , description="Operations Product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="product",method=RequestMethod.POST)
	@ApiOperation(value="Add Product", response=Product.class)
	public Product addProduct(@RequestBody Product product){
		return productService.insertProduct(product);
	}
	
	@RequestMapping(value="product/{productId}",method=RequestMethod.GET)
	@ApiOperation(value="Get Product", response=ProductResponse.class)
	public ProductResponse getProduct(@PathVariable("productId") Long productId){
		return productService.getProduct(productId);
	}
	
	@RequestMapping(value="product/{productId}",method=RequestMethod.PUT)
	@ApiOperation(value="Add Attribute to Product", response=ProductResponse.class)
	public ProductResponse setAttributeToProduct(@PathVariable("productId") Long productId,@RequestBody List<ProdutAttributeRequest> produtAttributeRequest){
		return productService.addAttributesToProduct(productId,produtAttributeRequest);			
	}
	
	
	
	
}

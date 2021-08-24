package com.catalog.catalog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.catalog.catalog.model.Attribute;
import com.catalog.catalog.model.Product;
import com.catalog.catalog.service.ProductService;
import com.catalog.catalog.wapper.ProductResponse;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="product",method=RequestMethod.POST)
	public String addProduct(@RequestBody Product product){
		return productService.insertProduct(product);
	}
	
	@RequestMapping(value="product/{productId}",method=RequestMethod.GET)
	public ProductResponse getProduct(@PathVariable("productId") Long productId){
		
		return productService.getProduct(productId);
	}
	
	@RequestMapping(value="product/{productId}",method=RequestMethod.PUT)
	public ProductResponse setAttributeToProduct(@PathVariable("productId") Long productId,@RequestBody List<Attribute> attributes){
		
		return productService.addAttributesToProduct(productId,attributes);			
	}
	
	
	
	
}

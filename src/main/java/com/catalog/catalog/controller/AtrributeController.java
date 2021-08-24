package com.catalog.catalog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.catalog.catalog.model.Attribute;
import com.catalog.catalog.service.AttributeService;

import io.swagger.annotations.ApiOperation;

@RestController
public class AtrributeController {
	
	@Autowired
	private AttributeService attributeService;
	
	@RequestMapping(value="attribute",method=RequestMethod.POST)
	@ApiOperation(value="Add Attribute", response=Attribute.class)
	public Attribute addAttribute(@RequestBody Attribute attribute){
		return attributeService.insertAttribute(attribute);
	}
	
	@RequestMapping(value="attribute/{attributeId}",method=RequestMethod.GET)
	@ApiOperation(value="Get Attribute", response=Attribute.class)
	public Attribute getAttribute(@PathVariable("attributeId") Long attributeID){
		return attributeService.getAttribute(attributeID);
	}
	
}

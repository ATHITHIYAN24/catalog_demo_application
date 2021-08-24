package com.catalog.catalog.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catalog.catalog.model.Attribute;
import com.catalog.catalog.repo.AttributeRepository;

@Service
public class AttributeServiceImpl implements AttributeService {
	
	@Autowired
	private AttributeRepository attributeRepository;
	
	
	public String insertAttribute(Attribute attribute){
		attributeRepository.save(attribute);
		return "success";
	}
	
	public Attribute getAttribute(Long attributeID){
		Optional<Attribute> attributeOptional=attributeRepository.findById(attributeID);
		if(attributeOptional.isPresent()){
			return attributeOptional.get();
		}
		else{
			return null;
		}
	}
}

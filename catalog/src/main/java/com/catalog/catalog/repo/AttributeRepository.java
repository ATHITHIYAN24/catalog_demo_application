package com.catalog.catalog.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.catalog.catalog.model.Attribute;

@Repository
public interface AttributeRepository extends JpaRepository<Attribute, Long> {

}

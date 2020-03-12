package com.mycart.admin.repository;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import com.mycart.admin.entity.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>{
    
    Optional<Category> findOneByName(String name);
    Optional<Category> findOneById(Long Id);
    
    Set<Category> findAllByIdIn(Set<Long> ids);
    
    Collection<Category> findAll();
	Collection<Category> findByParentIsNull();

   // Collection<Category> findAllByBrandId(Long id);
}

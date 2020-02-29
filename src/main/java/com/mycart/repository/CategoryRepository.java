package com.mycart.repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.mycart.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>{
    
    Optional<Category> findOneByName(String name);
    Optional<Category> findOneByCategoryId(Long categoryId);
    
    Collection<Category> findAll();

}

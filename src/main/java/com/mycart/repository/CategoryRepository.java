package com.mycart.repository;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import com.mycart.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>{
    
    Optional<Category> findOneByName(String name);
    Optional<Category> findOneById(Long Id);
    
    Set<Category> findAllByIdIn(Set<Long> ids);
    
    Collection<Category> findAll();

}

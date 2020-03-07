package com.mycart.repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.mycart.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Long>, JpaSpecificationExecutor<Product>{
    
    Optional<Product> findById(Long id);
    
    Collection<Product> findAllByBrandId(Long brandId);
    
    Collection<Product> findAll();
    
    Collection<Product> findAllByColor(String color);
    
    

}

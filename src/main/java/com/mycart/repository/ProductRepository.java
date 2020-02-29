package com.mycart.repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.mycart.domain.Product;

public interface ProductRepository extends CrudRepository<Product, Long>, JpaSpecificationExecutor<Product>{
    
    Collection<Product> findAllByProductId(Long productId);
    
    Optional<Product> findByProductId(Long productId);
    
    Collection<Product> findAll();
    
    

}


package com.mycart.admin.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import com.mycart.admin.entity.Brand;

public interface BrandRepository extends CrudRepository<Brand, Long> {

    Optional<Brand> findOneByName(String name);
    Optional<Brand> findOneById(Long id);
    Set<Brand> findAll();
    
    Set<Brand> findAllByIdIn(Set<Long> ids);
    void deleteById(Long id);

}

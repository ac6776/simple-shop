package com.mysimpleshop.simpleshop.repositories;

import com.mysimpleshop.simpleshop.entities.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
}

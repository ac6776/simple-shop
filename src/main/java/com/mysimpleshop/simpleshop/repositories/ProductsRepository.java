package com.mysimpleshop.simpleshop.repositories;

import com.mysimpleshop.simpleshop.entities.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends PagingAndSortingRepository<Product, Long> {
}

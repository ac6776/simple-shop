package com.mysimpleshop.simpleshop.repositories;

import com.mysimpleshop.simpleshop.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepository extends PagingAndSortingRepository<Product, Long> {
//    @Query("SELECT p FROM Product p WHERE id = 1;")
//    Product findWithIdOne();
}

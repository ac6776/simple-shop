package com.mysimpleshop.simpleshop.repositories;

import com.mysimpleshop.simpleshop.entities.Product;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends PagingAndSortingRepository<Product, Long>, JpaSpecificationExecutor<Product> {
//    @Query("SELECT p FROM Product p WHERE id = 1;")
//    Product findWithIdOne();
//    List<Product> findByCostBetween(Double min, Double max);
    Product findOneByTitle(String title);
}

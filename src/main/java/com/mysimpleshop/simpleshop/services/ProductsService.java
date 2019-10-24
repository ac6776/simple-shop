package com.mysimpleshop.simpleshop.services;

import com.mysimpleshop.simpleshop.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductsService {
    private ProductsRepository productsRepository;

    @Autowired
    public void setProductsRepository(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }
}

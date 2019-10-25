package com.mysimpleshop.simpleshop.services;

import com.mysimpleshop.simpleshop.entities.Product;
import com.mysimpleshop.simpleshop.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {
    private ProductsRepository productsRepository;

    @Autowired
    public void setProductsRepository(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public List<Product> findAllProducts(){
        return (List<Product>) productsRepository.findAll();
    }
}

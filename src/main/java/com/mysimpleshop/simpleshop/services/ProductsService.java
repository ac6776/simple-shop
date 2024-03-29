package com.mysimpleshop.simpleshop.services;

import com.mysimpleshop.simpleshop.entities.Product;
import com.mysimpleshop.simpleshop.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
        return (List<Product>) productsRepository.findAll(Sort.by("cost"));
    }

    public List<Product> findAllProductsPaged(int curPage){
        return productsRepository.findAll(PageRequest.of(curPage, 3)).getContent();
    }

    public int countPages(){
        return productsRepository.findAll(PageRequest.of(0, 3)).getTotalPages();
    }

    public Product saveOrUpdate(Product product){
//        if(productsRepository.existsById(product.getId())){
//            Product existedProduct = productsRepository.findById(product.getId()).get();
//            existedProduct.setCost(product.getCost());
//            System.out.println(existedProduct.getTitle());
//            existedProduct.setTitle(product.getTitle());
//            System.out.println(existedProduct.getCost());
//            return productsRepository.findById(product.getId()).get();
//        }
       return productsRepository.save(product);
    }

    public Product findById(Long id){
        return productsRepository.findById(id).get();
    }

    public List<Product> findProductsBetweenMinAndMax(Double min, Double max){
        return productsRepository.findByCostBetween(min, max);
    }

    public void remove(Product product){
        productsRepository.delete(product);
    }
}

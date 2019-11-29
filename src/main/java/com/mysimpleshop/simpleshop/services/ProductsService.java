package com.mysimpleshop.simpleshop.services;

import com.mysimpleshop.simpleshop.entities.Product;
import com.mysimpleshop.simpleshop.repositories.ProductsRepository;
import com.mysimpleshop.simpleshop.utils.ProductErrorResponse;
import com.mysimpleshop.simpleshop.utils.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
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

    public List<Product> getAllProductsWithFilter(Specification<Product> productSpecs) {
        return (List<Product>)(productsRepository.findAll(productSpecs));
    }

    public Product getProductById(Long id) {
        return productsRepository.findById(id).orElse(null);
    }

    public Page<Product> getAllProductsByPage(int pageNumber, int pageSize) {
        return productsRepository.findAll(PageRequest.of(pageNumber, pageSize));
    }

    public Page<Product> getProductsWithPagingAndFiltering(int pageNumber, int pageSize, Specification<Product> productSpecification) {
        return productsRepository.findAll(productSpecification, PageRequest.of(pageNumber, pageSize));
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
        return productsRepository.findById(id).orElse(null);
    }

    public int remove(Long id){
        productsRepository.deleteById(id);
        return HttpStatus.OK.value();
    }

    public boolean isProductWithTitleExists(String productTitle) {
        return productsRepository.findOneByTitle(productTitle) != null;
    }

    public Product findProductByTitle(String title){
        return productsRepository.findOneByTitle(title);
    }
}

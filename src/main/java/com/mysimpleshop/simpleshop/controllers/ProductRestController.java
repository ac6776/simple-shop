package com.mysimpleshop.simpleshop.controllers;

import com.mysimpleshop.simpleshop.entities.Product;
import com.mysimpleshop.simpleshop.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductRestController {
    public ProductsService productsService;

    @Autowired
    public void setProductsService(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productsService.findAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product getOneProduct(@PathVariable Long id){
        return productsService.findById(id);
    }

    @PostMapping("/products")
    public Product addNewProduct(@RequestBody Product product){
        return productsService.saveOrUpdate(product);
    }

    @PutMapping("/products")
    public Product updateProduct(@RequestBody Product product){
        return productsService.saveOrUpdate(product);
    }

    @DeleteMapping("/products")
    public int deleteProduct(@RequestBody Product product){
        return productsService.remove(product);
    }
}

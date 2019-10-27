package com.mysimpleshop.simpleshop.controllers;

import com.mysimpleshop.simpleshop.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    private ProductsService productsService;

    @Autowired
    public void setProductsService(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping("/")
    public String showHomePage(){
        return "index";
    }

    @GetMapping("/products")
    public String showProductsPage(Model model){
        model.addAttribute("products", productsService.findAllProducts());
        return "products";
    }
    @GetMapping("/add")
    public String showAddProductPage(){
//        model.addAttribute("products", productsService.findAllProducts());
        return "add-product";
    }
}

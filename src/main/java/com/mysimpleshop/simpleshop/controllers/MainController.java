package com.mysimpleshop.simpleshop.controllers;

import com.mysimpleshop.simpleshop.entities.Product;
import com.mysimpleshop.simpleshop.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String showProductsByStartPage(Model model){
        model.addAttribute("products", productsService.findAllProductsPaged(0));
        model.addAttribute("pages", productsService.countPages());
        System.out.println(productsService.countPages());
        return "redirect:/products/1";
    }

    @GetMapping("/products/{sid}")
    public String showProductsByPage(Model model, @PathVariable("sid") int curPage){
        model.addAttribute("products", productsService.findAllProductsPaged(curPage - 1));
        model.addAttribute("pages", productsService.countPages());
        System.out.println(productsService.countPages());
        return "products";
    }

    @GetMapping("/products/all")
    public String showAllProductsPage(Model model){
        model.addAttribute("products", productsService.findAllProducts());
        return "all-products";
    }
    @GetMapping("/add")
    public String addProductPage(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        return "add-product";
    }

    @PostMapping("/add")
    public String addProduct(Model model, @ModelAttribute("product") Product product){
        productsService.saveOrUpdate(product);
        return "redirect:/products/all";
    }

    @GetMapping("/about/{sid}")
    public String showInfoPage(Model model, @PathVariable("sid") Long id){
        model.addAttribute("product", productsService.findById(id));
        return "about";
    }
}

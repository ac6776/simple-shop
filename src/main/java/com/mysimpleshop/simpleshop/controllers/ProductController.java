package com.mysimpleshop.simpleshop.controllers;

import com.mysimpleshop.simpleshop.entities.Product;
import com.mysimpleshop.simpleshop.entities.ProductImage;
import com.mysimpleshop.simpleshop.services.CategoryService;
import com.mysimpleshop.simpleshop.services.ImageSaverService;
import com.mysimpleshop.simpleshop.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductsService productsService;
    private CategoryService categoryService;
    private ImageSaverService imageSaverService;

    @Autowired
    public void setProductService(ProductsService productService) {
        this.productsService = productService;
    }

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Autowired
    public void setImageSaverService(ImageSaverService imageSaverService) {
        this.imageSaverService = imageSaverService;
    }

    @GetMapping("/all")
    public String showAllProductsPage(Model model){
        model.addAttribute("products", productsService.findAllProducts());
        return "all-products";
    }

    @GetMapping("/about/{sid}")
    public String showInfoPage(Model model, @PathVariable("sid") Long id){
        model.addAttribute("product", productsService.findById(id));
        return "product";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/add")
    public String addProductPage(Model model){
        Product product = new Product();
//        System.out.println(product.getId());
        model.addAttribute("product", product);
        return "add-product";
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/add")
    public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult br, Model model){
        if (br.hasErrors()){
            return "add-product";
        }
        Product existing = productsService.findProductByTitle(product.getTitle());
//        if (existing != null){
        if (existing != null && product.getId() == null){
            model.addAttribute("product", product);
            model.addAttribute("productCreationError", "Product title already existed");
            return "add-product";
        }
        productsService.saveOrUpdate(product);
        return "redirect:/products/all";
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable(name = "id") Long id) {
        Product product = productsService.findById(id);
        if (product == null) {
            product = new Product();
            product.setId(0L);
        }
        model.addAttribute("product", product);
        model.addAttribute("categories", categoryService.getAllCategories());
//        return "/edit-product";
        return "/add-product";
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/edit")
    public String processProductAddForm(@Valid @ModelAttribute("product") Product product, BindingResult theBindingResult, Model model, @RequestParam("file") MultipartFile file) {
        if (product.getId() == 0 && productsService.isProductWithTitleExists(product.getTitle())) {
            theBindingResult.addError(new ObjectError("product.title", "Товар с таким названием уже существует")); // todo не отображает сообщение
        }

        if (theBindingResult.hasErrors()) {
            model.addAttribute("categories", categoryService.getAllCategories());
//            return "edit-product";
            return "add-product";
        }

        if (!file.isEmpty()) {
            String pathToSavedImage = imageSaverService.saveFile(file);
            ProductImage productImage = new ProductImage();
            productImage.setPath(pathToSavedImage);
            productImage.setProduct(product);
            product.addImage(productImage);
        }

        productsService.saveOrUpdate(product);
        return "redirect:/";
    }
}

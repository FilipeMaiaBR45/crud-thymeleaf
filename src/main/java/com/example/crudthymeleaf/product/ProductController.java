package com.example.crudthymeleaf.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductServiceImpl service;


    @GetMapping("/")
    public String listProducts(Model model) {
        List<ProductModel> products = service.getAllProducts();
        model.addAttribute("products", products);
        return "list";
    }

    @GetMapping("/add")
    public String addProductForm(Model model) {
        model.addAttribute("product", new ProductModel());
        return "add";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute("product") ProductModel product) {
        service.addProduct(product);
        return "redirect:/products/";
    }

    @GetMapping("/edit/{id}")
    public String editProductForm(@PathVariable Long id, Model model) {
        ProductModel product = service.getProdutcById(id).orElse(null);
        model.addAttribute("product", product);
        return "product/edit";
    }

    @PostMapping("/edit/{id}")
    public String editProduct(@PathVariable Long id, @ModelAttribute("product") ProductModel product) {
        service.updateProduct(product);
        return "redirect:/products/";
    }

    @PostMapping("/delete")
    public String deleteProduct(@RequestParam("productId") Long productId) {
        service.deleteProduct(productId);
        return "redirect:/products/";
    }
}
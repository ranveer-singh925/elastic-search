package com.example.springbootelasticsearchexample.controller;

import com.example.springbootelasticsearchexample.entity.Product;
import com.example.springbootelasticsearchexample.repo.ProductRepo;
import com.example.springbootelasticsearchexample.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apis")
public class ProductController {

    @Autowired
    private ProductService  productService;

    @Autowired
    private ProductRepo productRepo;

    @GetMapping("/findAll")
    Iterable<Product> findAll(){
       return productService.getProducts();

    }

    @GetMapping("/findByName/{name}")
    public List<Product> findByName(@PathVariable String name){
        List<Product> productList = productRepo.findByName(name);
        return productList;
    }
    @PostMapping("/insert")
    public Product insertProduct(@RequestBody  Product product){
       return productService.insertProduct(product);
    }

}

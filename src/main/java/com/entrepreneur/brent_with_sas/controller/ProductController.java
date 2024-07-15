package com.entrepreneur.brent_with_sas.controller;

import com.entrepreneur.brent_with_sas.model.Product;
import com.entrepreneur.brent_with_sas.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@ComponentScan
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping
    public List<Product> getAll()   {return productService.getAll();}

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Integer id){
        return productService.getProductById(id);
    }

    @PostMapping
    public void create(@RequestBody Product product){
        productService.create(product);
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable Integer id,@RequestBody Product product){
        productService.updateProduct(id,product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){productService.delete(id);}

}



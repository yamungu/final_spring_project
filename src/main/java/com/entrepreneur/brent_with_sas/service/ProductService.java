package com.entrepreneur.brent_with_sas.service;

import com.entrepreneur.brent_with_sas.model.Product;
import com.entrepreneur.brent_with_sas.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;
    public List<Product> getAll() {return productRepo.findAll();}

    public Product getProductById(int id){return productRepo.findById(id).orElse(null);}

    public void create(Product product){ productRepo.save(product); }

    public void updateProduct(Integer id, Product product){
        Product existingProduct = productRepo.findById(id).orElse(null);

        if (existingProduct !=null){
            existingProduct.setProduct_id(product.getProduct_id());
            existingProduct.setProduct_name(product.getProduct_name());
            existingProduct.setPrice(product.getPrice());
            productRepo.save(existingProduct);
        }
    }
    public void delete(Integer id){productRepo.deleteById(id);}

}

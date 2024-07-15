package com.entrepreneur.brent_with_sas.controller;

import com.entrepreneur.brent_with_sas.model.Customer_order;
import com.entrepreneur.brent_with_sas.service.Customer_orderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@ComponentScan
@RestController
@RequestMapping("/api/v1/customer_order")
public class Customer_orderController {
    @Autowired
    private Customer_orderService customer_orderService;

    @GetMapping
    public List<Customer_order> getAll(){
        return customer_orderService.getAll();}

    @GetMapping("/{id}")
    public Customer_order getCustomer_orderById(@PathVariable Integer id){
        return customer_orderService.getCustomer_orderById(id);
    }

    @PostMapping
    public void create(@RequestBody Customer_order customer_order){
        customer_orderService.create(customer_order);
    }

    @PutMapping("/{id}")
    public void updateCustomer_order(@PathVariable Integer id,@RequestBody Customer_order customer_order){
        customer_orderService.updateCustomer_order(id,customer_order);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){customer_orderService.delete(id);}

}


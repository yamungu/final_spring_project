package com.entrepreneur.brent_with_sas.controller;

import com.entrepreneur.brent_with_sas.model.Supplier;
import com.entrepreneur.brent_with_sas.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@ComponentScan
@RestController
@RequestMapping("/api/v1/supplier")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @GetMapping
    public List<Supplier> getAll(){return supplierService.getAll();}

    @GetMapping("/{id}")
    public Supplier getSupplierById(@PathVariable Integer id){
        return supplierService.getSupplierById(id);
    }

    @PostMapping
    public void create(@RequestBody Supplier supplier){
        supplierService.create(supplier);
    }

    @PutMapping("/{id}")
    public void updateSupplier(@PathVariable Integer id,@RequestBody Supplier supplier){
        supplierService.updateSupplier(id,supplier);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){supplierService.delete(id);}

}






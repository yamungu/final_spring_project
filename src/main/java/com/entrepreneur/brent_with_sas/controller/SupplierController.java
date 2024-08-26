package com.entrepreneur.brent_with_sas.controller;

import com.entrepreneur.brent_with_sas.Exception.ResourceNotFoundException;
import com.entrepreneur.brent_with_sas.model.Supplier;
import com.entrepreneur.brent_with_sas.repository.SupplierRepo;
import com.entrepreneur.brent_with_sas.repository.UserRepo;
import com.entrepreneur.brent_with_sas.service.SupplierService;
import com.entrepreneur.brent_with_sas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@ComponentScan
@RestController
@RequestMapping("/api/v1/supplier")
public class SupplierController {

    @Autowired
    private SupplierRepo supplierRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserService userService;

    @Autowired
    private SupplierService supplierService;

    @GetMapping
    public List<Supplier> getAll(){return supplierService.getAll();}

    @GetMapping("/{id}")
    public Supplier getSupplierById(@PathVariable Long id){
        return supplierService.getSupplierById(id);
    }

    @PostMapping({"/supplier"})
    public Supplier createNewSupplier(@RequestBody Supplier supplier){
        return userService.registerNewSupplier(supplier);
    }

    @PutMapping("/supplier/{id}")
   public ResponseEntity<Supplier> editSupplierById(@PathVariable Long id, @RequestBody Supplier supplier) {
        Supplier supplier1 = (Supplier) supplierRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Supplier does not exist" + id));
        supplier1.setUserPassword(supplier.getUserPassword());
        supplier1.setRole(supplier.getRole());
        supplier1.setEmail(supplier.getEmail());
        supplier1.setUserName(supplier.getUserName());
        supplier1.setPhoneNumber(supplier.getPhoneNumber());
        supplier1.setCountry(supplier.getCountry());
        supplier1.setCompany(supplier.getCompany());
        supplier1.setUserFirstName(supplier.getUserFirstName());
        supplier1.setUserLastName(supplier.getUserLastName());
        Supplier updatedSupplier = supplierRepo.save(supplier);
        return ResponseEntity.ok(updatedSupplier);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){supplierService.delete(id);}

}






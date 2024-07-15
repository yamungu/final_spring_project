package com.entrepreneur.brent_with_sas.service;

import com.entrepreneur.brent_with_sas.model.Supplier;
import com.entrepreneur.brent_with_sas.repository.SupplierRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {
    @Autowired
    private SupplierRepo supplierRepo;
    public List<Supplier> getAll() {return supplierRepo.findAll();}

    public Supplier getSupplierById(int id){return supplierRepo.findById(id).orElse(null);}

    public void create(Supplier supplier){ supplierRepo.save(supplier); }

    public void updateSupplier(Integer id, Supplier supplier){
        Supplier existingSupplier = supplierRepo.findById(id).orElse(null);

        if (existingSupplier !=null){
            existingSupplier.setFirst_name(supplier.getFirst_name());
            existingSupplier.setLast_name(supplier.getLast_name());
            existingSupplier.setEmail(supplier.getEmail());
            existingSupplier.setPhone(supplier.getPhone());
            existingSupplier.setCompany(supplier.getCompany());
            existingSupplier.setCountry(supplier.getCountry());
            existingSupplier.setPassword(supplier.getPassword());
            existingSupplier.setUsername(supplier.getUsername());
            supplierRepo.save(existingSupplier);
        }
    }
    public void delete(Integer id){supplierRepo.deleteById(id);}

}

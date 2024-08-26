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

    public Supplier getSupplierById(long id){return supplierRepo.findById(id).orElse(null);}




    public void delete(Long id){supplierRepo.deleteById(id);}

}

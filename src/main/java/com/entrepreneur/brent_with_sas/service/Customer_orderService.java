package com.entrepreneur.brent_with_sas.service;

import com.entrepreneur.brent_with_sas.model.Customer_order;
import com.entrepreneur.brent_with_sas.repository.Customer_orderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Customer_orderService {
    @Autowired
    private Customer_orderRepo customer_orderRepo;

    public List<Customer_order> getAll() {return customer_orderRepo.findAll();}

    public Customer_order getCustomer_orderById(int id){return customer_orderRepo.findById(id).orElse(null);}

    public void create(Customer_order customer_order){customer_orderRepo.save(customer_order); }

    public void updateCustomer_order(Integer id, Customer_order customer_order){
        Customer_order existingCustomer_order = customer_orderRepo.findById(id).orElse(null);

        if (existingCustomer_order !=null){
            existingCustomer_order.setOrder_date((customer_order.getOrder_date()));
            existingCustomer_order.setQuantity(customer_order.getQuantity());
            existingCustomer_order.setStatus(customer_order.getStatus());
            customer_orderRepo.save(existingCustomer_order);
        }
    }
    public void delete(Integer id){customer_orderRepo.deleteById(id);}

}

package com.entrepreneur.brent_with_sas.repository;

import com.entrepreneur.brent_with_sas.model.Customer_order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Customer_orderRepo extends JpaRepository<Customer_order,Integer> {
}

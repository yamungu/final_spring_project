package com.entrepreneur.brent_with_sas.repository;

import com.entrepreneur.brent_with_sas.model.Entrepreneur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrepreneurRepo extends JpaRepository<Entrepreneur, Integer> {

}

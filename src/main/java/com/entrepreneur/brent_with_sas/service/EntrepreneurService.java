package com.entrepreneur.brent_with_sas.service;

import com.entrepreneur.brent_with_sas.model.Entrepreneur;
import com.entrepreneur.brent_with_sas.repository.EntrepreneurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntrepreneurService {

  @Autowired
  private EntrepreneurRepo entrepreneurRepo;

    public List<Entrepreneur> getAll() {return entrepreneurRepo.findAll();}

    public Entrepreneur getEntrepreneurById(long id){return entrepreneurRepo.findById(id).orElse(null);}


    public void delete(Long id){entrepreneurRepo.deleteById(id);}

}






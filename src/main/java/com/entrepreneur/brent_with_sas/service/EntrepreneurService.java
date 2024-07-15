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

    public Entrepreneur getEntrepreneurById(int id){return entrepreneurRepo.findById(id).orElse(null);}

    public void create(Entrepreneur entrepreneur){entrepreneurRepo.save(entrepreneur); }

    public void updateEntrepreneur(Integer id, Entrepreneur entrepreneur){
        Entrepreneur existingEntrepreneur = entrepreneurRepo.findById(id).orElse(null);

        if (existingEntrepreneur !=null){
  existingEntrepreneur.setFirst_name((entrepreneur.getFirst_name()));
           existingEntrepreneur.setLast_name(entrepreneur.getLast_name());
            existingEntrepreneur.setEmail(entrepreneur.getEmail());
            existingEntrepreneur.setPhone(entrepreneur.getPhone());
            existingEntrepreneur.setPassword(entrepreneur.getPassword());
            existingEntrepreneur.setUsername(entrepreneur.getUsername());
            entrepreneurRepo.save(existingEntrepreneur);
        }
    }
    public void delete(Integer id){entrepreneurRepo.deleteById(id);}

}






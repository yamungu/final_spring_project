package com.entrepreneur.brent_with_sas.controller;

import com.entrepreneur.brent_with_sas.model.Entrepreneur;
import com.entrepreneur.brent_with_sas.service.EntrepreneurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@ComponentScan
@RestController
@RequestMapping("/api/v1/entrepreneur")

public class EntrepreneurController {
  @Autowired
    private EntrepreneurService entrepreneurService;

  @GetMapping
  public List<Entrepreneur> getAll(){
    return entrepreneurService.getAll();}

  @GetMapping("/{id}")
  public Entrepreneur getEntrepreneurById(@PathVariable Integer id){
    return entrepreneurService.getEntrepreneurById(id);
  }

  @PostMapping
  public void create(@RequestBody Entrepreneur entrepreneur){
    entrepreneurService.create(entrepreneur);
  }




  public void updateEntrepreneur(@PathVariable Integer id,@RequestBody Entrepreneur entrepreneur){
    entrepreneurService.updateEntrepreneur(id,entrepreneur);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Integer id){entrepreneurService.delete(id);}

}





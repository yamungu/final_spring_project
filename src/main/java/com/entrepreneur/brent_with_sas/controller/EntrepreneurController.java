package com.entrepreneur.brent_with_sas.controller;

import com.entrepreneur.brent_with_sas.Exception.ResourceNotFoundException;
import com.entrepreneur.brent_with_sas.model.Entrepreneur;
import com.entrepreneur.brent_with_sas.model.Supplier;
import com.entrepreneur.brent_with_sas.repository.EntrepreneurRepo;
import com.entrepreneur.brent_with_sas.service.EntrepreneurService;
import com.entrepreneur.brent_with_sas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@ComponentScan
@RestController
@RequestMapping("/api/v1/entrepreneur")

public class EntrepreneurController {
  @Autowired
    private EntrepreneurService entrepreneurService;

  @Autowired
  private UserService userService;

  @Autowired
  private EntrepreneurRepo entrepreneurRepo;

  @GetMapping
  public List<Entrepreneur> getAll(){
    return entrepreneurService.getAll();}

  @GetMapping("/{id}")
  public Entrepreneur getEntrepreneurById(@PathVariable Long id){
    return entrepreneurService.getEntrepreneurById(id);
  }


  @PostMapping("/entrepreneur")
  public ResponseEntity<Entrepreneur> createNewEntrepreneur(@RequestBody Entrepreneur entrepreneur) {
    Entrepreneur savedEntrepreneur = userService.registerNewEntrepreneur(entrepreneur);
    return new ResponseEntity<>(savedEntrepreneur, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Entrepreneur> editEntrepreneurById(@PathVariable Long id, @RequestBody Entrepreneur entrepreneur) {
    Entrepreneur entrepreneur1 = (Entrepreneur) entrepreneurRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entrepreneur does not exist" + id));
    entrepreneur1.setUserPassword(entrepreneur.getUserPassword());
    entrepreneur1.setRole(entrepreneur.getRole());
    entrepreneur1.setEmail(entrepreneur.getEmail());
    entrepreneur1.setUserName(entrepreneur.getUserName());
    entrepreneur1.setPhoneNumber(entrepreneur.getPhoneNumber());
    entrepreneur1.setUserFirstName(entrepreneur.getUserFirstName());
    entrepreneur1.setUserLastName(entrepreneur.getUserLastName());
    Entrepreneur updatedEntrepreneur = entrepreneurRepo.save(entrepreneur);
    return ResponseEntity.ok(updatedEntrepreneur);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id){entrepreneurService.delete(id);}

}





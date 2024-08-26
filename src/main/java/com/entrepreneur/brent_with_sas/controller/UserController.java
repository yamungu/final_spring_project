package com.entrepreneur.brent_with_sas.controller;

import com.entrepreneur.brent_with_sas.model.User;
import com.entrepreneur.brent_with_sas.repository.UserRepo;
import com.entrepreneur.brent_with_sas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.Optional;

@RestController
@RequestMapping("/api/v3/")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepo userRepo;

    @PostConstruct
    private void initUserRoles(){
        userService.initUserRoles();
    }

    @PostMapping({"/registerNewUser"})
    public User registerNewUser(@RequestBody User user){
        return userService.registerNewUser(user);
    }


//    @PostMapping({"/registerNewEntrepreneur"})
//    public User registerNewEntrepreneur(@RequestBody User user){
//        return userService.registerNewEntrepreneur(user);
//    }

    @GetMapping({"/forAdmin"})
    @PreAuthorize("hasRole('Admin')")
    public String forAdmin(){
        return "This URL is only accessible by admin";
    }

    @GetMapping({"/forUser"})
    @PreAuthorize("hasRole('User')")
    public String forUser(){
        return "This URL is only accessible by user";
    }

    @GetMapping("/viewOwnDetails/{id}")
    public Optional<User> viewOwnDetails(@PathVariable Long id) {
        return userRepo.findById(id);
    }
}

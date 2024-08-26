package com.entrepreneur.brent_with_sas.controller;

import com.entrepreneur.brent_with_sas.model.Role;
import com.entrepreneur.brent_with_sas.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping({"/createRole"})
    public Role createNewRole(@RequestBody Role role){
        return roleService.createNewRole(role);
    }

}

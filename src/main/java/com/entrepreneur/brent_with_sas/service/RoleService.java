package com.entrepreneur.brent_with_sas.service;

import com.entrepreneur.brent_with_sas.model.Role;
import com.entrepreneur.brent_with_sas.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepo roleRepo;

    public Role createNewRole(Role role){
        return roleRepo.save(role);
    }
}

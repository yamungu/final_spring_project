package com.entrepreneur.brent_with_sas.service;

import com.entrepreneur.brent_with_sas.model.Entrepreneur;
import com.entrepreneur.brent_with_sas.model.Role;
import com.entrepreneur.brent_with_sas.model.Supplier;
import com.entrepreneur.brent_with_sas.model.User;
import com.entrepreneur.brent_with_sas.repository.EntrepreneurRepo;
import com.entrepreneur.brent_with_sas.repository.RoleRepo;
import com.entrepreneur.brent_with_sas.repository.SupplierRepo;
import com.entrepreneur.brent_with_sas.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;


    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private SupplierRepo supplierRepo;

    @Autowired
    private EntrepreneurRepo entrepreneurRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Role createNewRole(Role role){
        return roleRepo.save(role);
    }


    public void initUserRoles(){
        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Role for admin only");
        roleRepo.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Role for user only");
        roleRepo.save(userRole);


        Role supplierRole = new Role();
        supplierRole.setRoleName("Supplier");
        supplierRole.setRoleDescription("Role for supplier only");
        roleRepo.save(supplierRole);

        Role entrepreneurRole = new Role();
        entrepreneurRole.setRoleName("Entrepreneur");
        entrepreneurRole.setRoleDescription("Role for Entrepreneur only");
        roleRepo.save(entrepreneurRole);

        User adminUser = new User();
        adminUser.setId(1L);
        adminUser.setUserName("Yamungu123");
        adminUser.setUserPassword(getEncodedPassword("admin1234"));
        adminUser.setUserFirstName("Yamungu");
        adminUser.setUserLastName("Nyabenda");
        adminUser.setEmail("yamungujohn21@gmail.com");
        adminUser.setPhoneNumber("0710287645");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userRepo.save(adminUser);
    }

    public User registerNewUser (User user){
        Role role = roleRepo.findById("User").get();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        user.setRole(userRoles);
        user.setUserPassword(getEncodedPassword(user.getUserPassword()));

        return userRepo.save(user);
    }

    public Entrepreneur registerNewEntrepreneur (Entrepreneur entrepreneur){
        Role role = roleRepo.findById("Entrepreneur").get();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        entrepreneur.setRole(userRoles);
        entrepreneur.setUserPassword(getEncodedPassword(entrepreneur.getUserPassword()));

        return entrepreneurRepo.save(entrepreneur);
    }

    public Supplier registerNewSupplier (Supplier supplier){
        Role role = roleRepo.findById("Supplier").get();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        supplier.setRole(userRoles);
        supplier.setUserPassword(getEncodedPassword(supplier.getUserPassword()));

        return supplierRepo.save(supplier);
    }




    public String getEncodedPassword (String password){
        return passwordEncoder.encode(password);
    }
}

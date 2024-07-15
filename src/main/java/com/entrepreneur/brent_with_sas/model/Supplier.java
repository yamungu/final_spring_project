package com.entrepreneur.brent_with_sas.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@Getter
@Setter
public class Supplier {

    public Supplier() {
    }

    public Supplier(int supplier_id, String first_name, String last_name, String email, String phone, String company, String country, String password, String username, List<Product> product) {
        this.supplier_id = supplier_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.phone = phone;
        this.company = company;
        this.country = country;
        this.password = password;
        this.username = username;
        this.product = product;
    }

    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int supplier_id;
        private String first_name;
        private String last_name;
        private String email;
        private String phone;
        private String company;
        private String country;
        private String password;
        private String username;



    @ManyToMany
    @JoinTable(
            name = "supplier_product",
            joinColumns = @JoinColumn(name = "supplier_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> product;

    public Supplier( String first_name, String last_name, String email, String phone, String company, String country, String password, String username) {
            this.first_name = first_name;
            this.last_name = last_name;
            this.email = email;
            this.phone = phone;
            this.country = country;
            this.company = company;
            this.password = password;
            this.username = username;
        }
    }
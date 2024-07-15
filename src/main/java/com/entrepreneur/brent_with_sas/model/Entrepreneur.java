package com.entrepreneur.brent_with_sas.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
    @Entity
    @Getter
    @Setter
    @Data
    public class Entrepreneur {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String first_name;
        private String last_name;
        private String email;
        private String phone;
        private String password;
        private String username;

        @OneToMany(mappedBy = "entrepreneur", cascade = CascadeType.ALL)
        private List<Feedback> feedbacks;

        @OneToMany(mappedBy = "entrepreneur", cascade = CascadeType.ALL)
        private List<Customer_order> customer_orders;

        public Entrepreneur(String first_name, String last_name, String email, String phone, String password, String username) {
            this.first_name = first_name;
            this.last_name = last_name;
            this.email = email;
            this.phone = phone;
            this.password = password;
            this.username = username;
        }

        public Entrepreneur() {
        }


    }







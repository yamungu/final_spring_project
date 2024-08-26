package com.entrepreneur.brent_with_sas.model;



import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
    @Entity
    @Getter
    @Setter
    @Data
    public class Entrepreneur extends User{



        @OneToMany(mappedBy = "entrepreneur", cascade = CascadeType.ALL)
        private List<Feedback> feedbacks;

        @OneToMany(mappedBy = "entrepreneur", cascade = CascadeType.ALL)
        private List<Customer_order> customer_orders;



    }







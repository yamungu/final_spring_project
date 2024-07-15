package com.entrepreneur.brent_with_sas.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.util.List;



@Entity
@Data
@Getter
@Setter
public class Product {

    public  Product(){

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int product_id;
    private String product_name;
    private String price;


    @ManyToMany(mappedBy = "product")
            private List<Customer_order> customer_order;

    @ManyToMany(mappedBy = "product")
    private List<Supplier> supplier;


    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
            private List<Location> location;


   //  constructor

    public Product( String product_name, String price) {
        this.product_name = product_name;
        this.price = price;
    }
}


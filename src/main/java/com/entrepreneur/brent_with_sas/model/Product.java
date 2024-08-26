package com.entrepreneur.brent_with_sas.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


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
    private String product_location;
    private String latitude;
    private String longitude;



    @ManyToMany(mappedBy = "product")
            private List<Customer_order> customer_order;

    @ManyToMany(mappedBy = "product")
    private List<Supplier> supplier;


    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
            private List<Location> location;


   //  constructor

    public Product( String product_name, String price,String product_location,String latitude,String longitude) {
        this.product_name = product_name;
        this.price = price;
        this.product_location = product_location;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}


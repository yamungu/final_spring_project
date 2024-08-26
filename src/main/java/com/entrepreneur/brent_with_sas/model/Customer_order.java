package com.entrepreneur.brent_with_sas.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Getter
@Setter
public class Customer_order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customer_order_id;
    private String order_date;
    private String quantity;
    private String status;

    @ManyToOne
    @JoinColumn(name = "entrepreneur_id")
    private Entrepreneur entrepreneur;

    @ManyToMany
            @JoinTable(
                    name = "order_product",
                    joinColumns = @JoinColumn(name = "customer_order_id"),
                    inverseJoinColumns = @JoinColumn(name = "product_id"))
            private List<Product> product;



    public Customer_order(String order_date, String quantity, String status){
        this.order_date = order_date;
        this.quantity = quantity;
        this.status = status;
    }
}

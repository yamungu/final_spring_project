package com.entrepreneur.brent_with_sas.model;


import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

public class Order_product {

    @EmbeddedId
            private Order_product  id;

            @ManyToOne
            @MapsId("order_product _id")
            @JoinColumn(name = "order_product _id")
            private Customer_order customer_order;

            @ManyToOne
            @MapsId("order_product _id")
            @JoinColumn(name = "order_product _id")
            private Product product;

            private int quantity;
}

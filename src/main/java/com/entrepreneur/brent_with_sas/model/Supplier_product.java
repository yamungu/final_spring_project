package com.entrepreneur.brent_with_sas.model;


import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

public class Supplier_product {

    @EmbeddedId
            private Supplier_product id;

            @ManyToOne
            @MapsId("supplier_productId")
            @JoinColumn(name = "supplier_product_id")
            private Supplier supplier;

            @ManyToOne
            @MapsId("supplier_productId")
            @JoinColumn(name = "supplier_product_id")
            private Product product;

            private int quantity;
}


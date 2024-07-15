package com.entrepreneur.brent_with_sas.model;

import jakarta.persistence.*;

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


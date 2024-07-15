package com.entrepreneur.brent_with_sas.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Getter
@Setter
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int location_id;
    private String location_name;
    private int latitude;
    private int longitude;

@ManyToOne
@JoinColumn(name = "product_id")
private Product product;

    public Location(int location_id, String location_name, int latitude, int longitude) {
        this.location_id = location_id;
        this.location_name = location_name;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}

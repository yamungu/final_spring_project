package com.entrepreneur.brent_with_sas.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Data
@Setter
@Getter
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int feedback_id;
    private String message;

    public Feedback() {
    }

    private String date;

@ManyToOne
@JoinColumn(name = "entrepreneur_id")
private Entrepreneur entrepreneur;

    public Feedback(String message, String date){
        this.message = message;
        this.date = date;
    }




}

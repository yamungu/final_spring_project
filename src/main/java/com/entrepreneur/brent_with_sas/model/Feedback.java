package com.entrepreneur.brent_with_sas.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Setter
@Getter
public class Feedback {

    public Feedback() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int feedback_id;
    private String name;
    private String message;
    private String date;



//    private String date;

@ManyToOne
@JoinColumn(name = "entrepreneur_id")
private Entrepreneur entrepreneur;

    public Feedback( String name,String message, String date){
        this.name = name;
        this.message = message;
        this.date = date;
    }




}

package com.finalcase.oaks.OaksFinalCase.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "Actor")
public class Actor extends Profile {

    //Atributos
    @Id
    @GeneratedValue
    @Column(name = "Id")
    private Integer Id;

    @Column(name = "price")
    private Double price;

    @Column(name = "relevance")
    private int relevance;

    @Column(name = "genre")
    private String genre;

    @ElementCollection
    @Column(name = "AvailableDays")
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private List<Date> availableDays = new ArrayList<>();

    @ElementCollection
    @Column(name = "contractedDays")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private List<Date> contractedDays = new ArrayList<>();

    //construtor

    public Actor() {
    }

//    public Actor(String name, String doc, String email, String password, Double price, int relevance, String genre) {
//        super(name, doc, email, password);
//        this.price = price;
//        this.relevance = relevance;
//        this.genre = genre;
//    }

    //getters
    public Double getPrice() {
        return price;
    }
    public int getRelevance() {
        return relevance;
    }
    public String getGenre() {
        return genre;
    }
    public Integer getId() {
        return Id;
    }
    public List<Date> getAvailableDays() {
        return availableDays;
    }
    public List<Date> getContractedDays() {
        return contractedDays;
    }

    //setters
    public void setPrice(Double price) {
        this.price = price;
    }
    public void setRelevance(int relevance) {
        this.relevance = relevance;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public void setAvailableDays(List<Date> availableDays) {
        this.availableDays = availableDays;
    }
    public void setContractedDays(List<Date> contractedDays) {
        this.contractedDays = contractedDays;
    }

    //metodos

    public List<Date> addAvailableDay (Date date) {
        availableDays.add(date);
        return availableDays;
    }
    public List<Date> addContractedDays (Date date) {
        contractedDays.add(date);
        return contractedDays;
    }
    public List<Date> removeAvailableDay (Date date) {
        availableDays.remove(date);
        return availableDays;
    }
}

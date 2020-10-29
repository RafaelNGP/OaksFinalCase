package com.finalcase.oaks.OaksFinalCase.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "Actor")
public class Actor extends Profile implements Login {

    //atributos

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
    private List<Date> availableDays = new ArrayList<>();

    @ElementCollection
    @Column(name = "contractedDays")
    private List<Date> contractedDays = new ArrayList<>();

    //construtor
    public Actor(String name, String doc, String email, String password, Double price, int relevance, String genre) {
        super(name, doc, email, password);
        this.price = price;
        this.relevance = relevance;
        this.genre = genre;
    }


    public Actor(String name, String doc, String email, String password) {
        super(name, doc, email, password);
    }

    //getters e setters

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getRelevance() {
        return relevance;
    }

    public void setRelevance(int relevance) {
        this.relevance = relevance;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<Date> getAvailableDays() {
        return availableDays;
    }

    public void setAvailableDays(List<Date> availableDays) {
        this.availableDays = availableDays;
    }

    public List<Date> getContractedDays() {
        return contractedDays;
    }

    public void setContractedDays(List<Date> contractedDays) {
        this.contractedDays = contractedDays;
    }

    //metodos

    @Override
    public boolean checkLogin(String email, String password) {
        return this.getEmail() == email && this.getPassword() == password;
    }

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

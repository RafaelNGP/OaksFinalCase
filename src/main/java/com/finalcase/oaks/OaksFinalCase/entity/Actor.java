package com.finalcase.oaks.OaksFinalCase.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "Actor")
public class Actor implements Login {

    //atributos
    @Id
    @GeneratedValue
    @Column(name = "Id")
    private Integer Id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Doc")
    private String doc;

    @Column(name = "Email")
    private String email;

    @Column(name = "Password")
    private String password;

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

    //getters
    public String getName() {
        return name;
    }
    public String getDoc() {
        return doc;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
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
    public void setName(String name) {
        this.name = name;
    }
    public void setDoc(String doc) {
        this.doc = doc;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
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
    @Override
    public boolean checkLogin(String email, String password) {
        return this.getEmail().equals(email) && this.getPassword().equals(password);
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

package com.finalcase.oaks.OaksFinalCase.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Actor extends Profile {
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

    public Actor(String name, String doc) {
        super(name, doc);
    }

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
}

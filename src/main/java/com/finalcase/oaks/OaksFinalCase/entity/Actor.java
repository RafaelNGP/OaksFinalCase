package com.finalcase.oaks.OaksFinalCase.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@MappedSuperclass
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

    @Column(name = "availableDays")
    private Date[] availableDays;

    @Column(name = "contractedDays")
    private Date[] contractedDays;

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

    public Date[] getAvailableDays() {
        return availableDays;
    }

    public void setAvailableDays(Date[] availableDays) {
        this.availableDays = availableDays;
    }

    public Date[] getContractedDays() {
        return contractedDays;
    }

    public void setContractedDays(Date[] contractedDays) {
        this.contractedDays = contractedDays;
    }
}

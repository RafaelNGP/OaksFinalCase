package com.finalcase.oaks.OaksFinalCase.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
    private Set<Date> availableDays = new HashSet<>();

    @ElementCollection
    @Column(name = "contractedDays")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Set<Date> contractedDays = new HashSet<>();

    //construtor
    public Actor() {
    }

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

    public Set<Date> getAvailableDays() {
        return availableDays;
    }

    public Set<Date> getContractedDays() {
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

    public void setAvailableDays(Set<Date> availableDays) {
        this.availableDays = availableDays;
    }

    public void setContractedDays(Set<Date> contractedDays) {
        this.contractedDays = contractedDays;
    }

    //metodos
    public void addAvailableDay(Date date) {
        availableDays.add(date);
    }

    public void addContractedDays(Date date) {
        contractedDays.add(date);
    }

    public void removeAvailableDay(Date date) {
        availableDays.remove(date);
    }

    public void removeContractedDay(Date date) {
        contractedDays.remove(date);
    }
}

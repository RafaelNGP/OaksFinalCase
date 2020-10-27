package com.finalcase.oaks.OaksFinalCase.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Account {

    @Id
    @GeneratedValue
    @Column(name = "Id")
    private Integer Id;

    @Column(name = "activeCard")
    private boolean activeCard;

    @Column(name = "availableLimit")
    private int availableLimit;

    public boolean isActiveCard() {
        return activeCard;
    }

    public void setActiveCard(boolean activeCard) {
        this.activeCard = activeCard;
    }

    public int getAvailableLimit() {
        return availableLimit;
    }
    //testando

}

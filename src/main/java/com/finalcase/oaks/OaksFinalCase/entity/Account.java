package com.finalcase.oaks.OaksFinalCase.entity;

public class Account {

    private boolean activeCard;
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

}

package com.finalcase.oaks.OaksFinalCase.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Producer extends Profile {

    @Id
    @GeneratedValue
    @Column(name = "Id")
    private Integer Id;

    @Column(name = "reservedActors")
    private List<Actor> reservedActors;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public List<Actor> getReservedActors() {
        return reservedActors;
    }

    public void setReservedActors(List<Actor> reservedActors) {
        this.reservedActors = reservedActors;
    }
}

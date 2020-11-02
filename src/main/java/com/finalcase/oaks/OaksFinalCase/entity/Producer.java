package com.finalcase.oaks.OaksFinalCase.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name = "Producer")
public class Producer extends Profile {

    //atributos
    @Id
    @GeneratedValue
    @Column(name = "Id")
    private Integer Id;

    @ElementCollection
    @Column(name = "reservedActors")
    private Set<Actor> reservedActors = new HashSet<>();

    //construtor
    public Producer() {
    }

    public Producer(String name, String doc, String email, String password) {
        super(name, doc, email, password);
    }

    //Getters
    public Integer getId() {
        return Id;
    }

    public Set getReservedActors() {
        return reservedActors;
    }

    //Setters
    public void setId(Integer id) {
        Id = id;
    }

    public void setReservedActors(Set reservedActors) {
        this.reservedActors = reservedActors;
    }

    //metodos

    public void addReservedActor(Actor actor) {
        reservedActors.add(actor);
    }

    public void removeReservedActor(Actor actor) {
        reservedActors.remove(actor);
    }

}

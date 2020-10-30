package com.finalcase.oaks.OaksFinalCase.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Producer")
public class Producer extends Profile {

    //atributos
    @Id
    @GeneratedValue
    @Column(name = "Id")
    private Integer Id;

    @ElementCollection
    @Column(name = "reservedActors")
    private List<Actor> reservedActors = new ArrayList<>();

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

    public List<Actor> getReservedActors() {
        return reservedActors;
    }

    //Setters
    public void setId(Integer id) {
        Id = id;
    }

    public void setReservedActors(List<Actor> reservedActors) {
        this.reservedActors = reservedActors;
    }

    //metodos

    public List<Actor> addReservedActor(Actor actor) {
        reservedActors.add(actor);
        return reservedActors;
    }

}

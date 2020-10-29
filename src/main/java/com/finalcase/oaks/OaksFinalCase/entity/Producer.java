package com.finalcase.oaks.OaksFinalCase.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Producer")
public class Producer implements Login {

    //atributos
    @Id
    @GeneratedValue
    @Column(name = "Id")
    private Integer Id;

    @ElementCollection
    @Column(name = "reservedActors")
    private List<Actor> reservedActors = new ArrayList<>();

    @Column(name = "Name")
    private String name;

    @Column(name = "Doc")
    private String doc;

    @Column(name = "Email")
    private String email;

    @Column(name = "Password")
    private String password;

    //Getters
    public Integer getId() {
        return Id;
    }
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
    public List<Actor> getReservedActors() {
        return reservedActors;
    }

    //Setters
    public void setId(Integer id) {
        Id = id;
    }
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
    public void setReservedActors(List<Actor> reservedActors) {
        this.reservedActors = reservedActors;
    }

    //metodos
    @Override
    public boolean checkLogin(String email, String password) {
        return this.getEmail() == email && this.getPassword() == password;
    }
    public List<Actor> addReservedActor(Actor actor) {
        reservedActors.add(actor);
        return reservedActors;
    }
}

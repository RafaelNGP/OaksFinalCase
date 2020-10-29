package com.finalcase.oaks.OaksFinalCase.entity;

import javax.persistence.*;

@MappedSuperclass
public abstract class Profile {

    private static final long serialVersionUID = 1L;

    // Atributos

    private String name;

    private String doc;

    private String email;

    private String password;

    // Construtor

    public Profile() {
    };

    public Profile(String name, String doc, String email, String password) {
        this.name = name;
        this.doc = doc;
        this.email = email;
        this.password = password;
    }

    // Getters

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

    // Setters

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

package com.finalcase.oaks.OaksFinalCase.entity;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Profile {

    private static final long serialVersionUID = 1L;

    private String name;
    private String doc;
    private String email;
    private String password;

    public Profile(String name, String doc, String email, String password) {
        this.name = name;
        this.doc = doc;
        this.email = email;
        this.password = password;
    }
}

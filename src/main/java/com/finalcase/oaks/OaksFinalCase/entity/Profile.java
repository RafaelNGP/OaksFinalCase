package com.finalcase.oaks.OaksFinalCase.entity;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Profile_Type")
public abstract class Profile {

//    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    protected Integer id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Doc")
    private String doc;

    @Column(name = "Email")
    private String email;

    @Column(name = "Password")
    private String password;

    public Profile(String name, String doc, String email, String password) {
        this.name = name;
        this.doc = doc;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }
}

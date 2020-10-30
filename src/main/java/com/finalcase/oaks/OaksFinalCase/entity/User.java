package com.finalcase.oaks.OaksFinalCase.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class User implements UserDetails {

    @Id
    private String login;

    private String password;

    @ManyToMany
    @JoinTable(name = "users_roles",joinColumns = @JoinColumn(
            name = "user_id", referencedColumnName = "login"),
            inverseJoinColumns = @JoinColumn(
            name = "role_id", referencedColumnName = "nameRole"))
    private List<Role> roles;

    public List<Role> getRoles() {
        return roles;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return this.password;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}


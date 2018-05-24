package com.homebudget.userservice.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column
    private int userId;

    @Email
    @Column
    private String email;

    @Column
    private String password;

    public int getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

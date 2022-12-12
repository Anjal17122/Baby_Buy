package com.example.fullapplication.user.model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class User {

     @PrimaryKey(autoGenerate = true)
     private int id;

     private String name;

     private String  email;

     private String phoneNo;

     private String username;

     private String password;

     @Ignore
    public User(int id, String name, String email, String phoneNo, String username, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.username = username;
        this.password = password;
    }

    public User(String name, String email, String phoneNo, String username, String password) {
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

package com.example.demodatabase.Entity;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long userId;

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    private String name;
    private String username;
    private String password;
    private String mail;
    private String phone;
    private int role;
    private boolean active;

    public User() {
    }

    public User(String name, String username, String password, String mail, String phone, int role, boolean active) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.mail = mail;
        this.phone = phone;
        this.role = role;
        this.active = active;
    }

    public User(String name, String username, String password, String phone, int role, boolean active) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.role = role;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}

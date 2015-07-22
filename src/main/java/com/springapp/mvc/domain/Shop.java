package com.springapp.mvc.domain;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

/**
 * Created by taras on 22.07.15.
 */

@Entity
@Table(name = "shop")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty
    private Long id;

    @JsonProperty
    @Column
    private String name;

    @JsonProperty
    @Column
    private String address;

    @JsonProperty
    @Column
    private String email;

    @JsonProperty
    @Column
    private String phoneNumber;

    @JsonProperty
    @Column
    private String password;


    public Shop() {

    }

    public Shop(Long id, String name, String address, String email, String phoneNumber, String password) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getAddress() {
        return address;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
}

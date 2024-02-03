package com.crud.sunbase.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.persistence.*;

@Entity
public class Customer {
    @Id
    @Column(name = "custId", unique = true, nullable = false)
    @JsonProperty( value = "custId", access = JsonProperty.Access.READ_ONLY)
    public String custId;

    @Column(name = "first_name", unique = true, nullable = false)
    public String firstName;
    @Column(name = "last_name", unique = true, nullable = false)
    public String lastName;
    @Getter
    public String street;
    public String address;
    public String city;
    public String state;
    public String email;
    public String phone;

    public Customer(String custId, String first_name, String last_name, String street, String address, String city, String state, String email, String phone) {
        this.custId = custId;
        this.firstName = first_name;
        this.lastName = last_name;
        this.street = street;
        this.address = address;
        this.city = city;
        this.state = state;
        this.email = email;
        this.phone = phone;
    }


    public Customer() {
    }

    public String getFirst_name() {
        return firstName;
    }

    public void setFirst_name(String firstName) {
        this.firstName = firstName;
    }

    public String getLast_name() {
        return lastName;
    }

    public void setLast_name(String lastName) {
        this.lastName = lastName;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", first_name='" + firstName + '\'' +
                ", last_name='" + lastName + '\'' +
                ", street='" + street + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

package com.paypal.bfs.test.employeeserv.api.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long addressId;
    @NotBlank(message = "Line1 is required")
    @Column(name = "line1")
    private String line1;
    @Column(name = "line2")
    private String line2;
    @NotBlank(message = "City is required")
    @Column(name = "city")
    private String city;
    @NotBlank(message = "State is required")
    @Column(name = "state")
    private String state;
    @NotBlank(message = "Country is required")
    @Column(name = "country")
    private String country;
    @NotNull(message = "Zip code is required")
    @Column(name = "zip_code")
    private int zipCode;

    public Address()
    {
    }

    public Address(Long addressId, String line1, String line2, String city, String state, String country, int zipCode) {
        this.addressId = addressId;
        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
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

    public String getCountry(String country) {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }
}

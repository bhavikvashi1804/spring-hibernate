package com.bhavik.model.person;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {

    // properties
    private String line1;
    private String line2;
    private String city;
    private String district;
    private String state;
    private String country;
    private Long pinCode;


    // getters and setters
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

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getPinCode() {
        return pinCode;
    }

    public void setPinCode(Long pinCode) {
        this.pinCode = pinCode;
    }


    // constructor
    public Address(){

    }
    public Address(String line1, String line2, String city, String district, String state, String country, Long pinCode) {
        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
        this.district = district;
        this.state = state;
        this.country = country;
        this.pinCode = pinCode;
    }


    //methods
    @Override
    public String toString() {
        return "Address{" +
                "line1='" + line1 + '\'' +
                ", line2='" + line2 + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", pinCode=" + pinCode +
                '}';
    }
}

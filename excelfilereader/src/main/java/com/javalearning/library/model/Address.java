package com.javalearning.library.model;

/*
 * for testing com.javalearning.library.ExcelFileReaderSimple class in com.javaclass.csvfilereader.com.javalearning.library.main package
 * */
public class Address {
    private Long id;
    private String street;
    private String city;
    private String zipCode;
    private String country;
    private Phone phone;

    public Address(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }
}

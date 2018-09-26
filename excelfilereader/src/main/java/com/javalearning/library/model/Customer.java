package com.javalearning.library.model;

import java.util.List;

/*
* for testing com.javalearning.library.ExcelFileReaderSimple class in com.javaclass.csvfilereader.com.javalearning.library.main package
* */
public class Customer {
    private Long id;
    private String name;
    private int age;
    private List<Address> address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }
}

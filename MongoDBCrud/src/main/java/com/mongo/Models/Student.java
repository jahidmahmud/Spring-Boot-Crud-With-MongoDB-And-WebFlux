package com.mongo.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


//Mongodb atlas
//mongodb+srv://Admin:<password>@cluster0.r5pjrhf.mongodb.net/?retryWrites=true&w=majority

//Mongodb compass
//spring.data.mongodb.host=localhost
//spring.data.mongodb.port=27017
//spring.data.mongodb.database=MyDB

@Document(collection = "students")
public class Student {
    @Id
    private int id;
    private String name;
    private String email;
    private String city;

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}

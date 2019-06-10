package com.hotels.mongodb;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "HotelsList")
public class Hotels {

    @Id
    private String id;
    private String name;
    @Indexed(direction = IndexDirection.ASCENDING)
    private double rate;
    private Address address;
    private List<Reviews> reviews;

    protected Hotels(){
        this.reviews=new ArrayList<>();
    }

    public Hotels(String name,double rate,Address address, List<Reviews> reviews){
        this.name=name;
        this.rate=rate;
        this.address=address;
        this.reviews=reviews;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Reviews> getReviews() {
        return reviews;
    }

    public void setReviews(List<Reviews> reviews) {
        this.reviews = reviews;
    }
}

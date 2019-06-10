package com.hotels.mongodb;

public class Reviews {

    private  String name;
    private String Description;
    private int rating;
    private boolean approved;

    protected Reviews(){}

    public Reviews(String name, String description, int rating, boolean approved) {
        this.name = name;
        Description = description;
        this.rating = rating;
        this.approved = approved;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }
}

package com.example.michael.lunchfinder.model;

import android.location.Location;

/**
 * Model restaurant object.
 */
public class Restaurant {

    private String name;
    private Location location;
    private float minPrice;
    private float maxPrice;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    private String imageUrl;

    public Restaurant(String name, Location location, float minPrice, float maxPrice, String imageUrl) {
        this.name=name;
        this.location=location;
        this.minPrice=minPrice;
        this.maxPrice=maxPrice;
        this.imageUrl=imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public float getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(float minPrice) {
        this.minPrice = minPrice;
    }

    public float getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(float maxPrice) {
        this.maxPrice = maxPrice;
    }
}

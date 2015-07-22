package com.example.michael.lunchfinder.loader;

import android.content.Context;
import android.location.Location;

import com.example.michael.lunchfinder.model.Restaurant;

import java.util.ArrayList;
import java.util.List;

/**
 * Loader to load new restaurants. Currently mocked out.
 */
public class RestaurantLoader extends BaseLoader<List<Restaurant>> {

    public RestaurantLoader(Context context) {
        super(context);
    }

    @Override
    public List<Restaurant> loadInBackground() {
        // TODO for now, we just create mock data...
        List<Restaurant> restaurants = new ArrayList<>(3);

        Location location = new Location("fake");
        location.setLatitude(11.574189);
        location.setLongitude(104.927658);
        Restaurant restaurant = new Restaurant("Hummus House", location, 5f, 10f, "http://dubaifurniture.co/wp-content/uploads/2014/06/restaurant-furniture.jpg");
        restaurants.add(restaurant);

        location.setLatitude(11.581067);
        location.setLongitude(104.919521);
        restaurant = new Restaurant("The Doors", location, 10f, 20f, "http://dubaifurniture.co/wp-content/uploads/2014/06/restaurant-furniture.jpg");
        restaurants.add(restaurant);

        location.setLatitude(11.557991);
        location.setLongitude(104.925653);
        restaurant = new Restaurant("Taqueria Corona", location, 10f, 20f, "http://dubaifurniture.co/wp-content/uploads/2014/06/restaurant-furniture.jpg");
        restaurants.add(restaurant);


        return restaurants;
    }

}

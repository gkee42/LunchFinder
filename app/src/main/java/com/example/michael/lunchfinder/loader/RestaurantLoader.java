package com.example.michael.lunchfinder.loader;

import android.content.Context;
import android.location.Location;

import com.example.michael.lunchfinder.model.Restaurant;

/**
 * Loader to load new restaurants. Currently mocked out.
 */
public class RestaurantLoader extends BaseLoader<Restaurant> {

//    private Restaurant restaurant;

    public RestaurantLoader(Context context) {
        super(context);
    }

    @Override
    public Restaurant loadInBackground() {
        Location location = new Location("fake");
        location.setLatitude(11.574189);
        location.setLongitude(104.927658);
        return new Restaurant("TestRest", location, 5f, 10f, "http://dubaifurniture.co/wp-content/uploads/2014/06/restaurant-furniture.jpg");
    }

//    @Override
//    protected void onStartLoading() {
//            if (restaurant != null) {
//                deliverResult(restaurant);
//            }
//            if (takeContentChanged() || restaurant == null) {
//                forceLoad();
//            }
//        }
}

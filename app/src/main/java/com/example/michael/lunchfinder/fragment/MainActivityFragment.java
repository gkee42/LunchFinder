package com.example.michael.lunchfinder.fragment;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.michael.lunchfinder.R;
import com.example.michael.lunchfinder.loader.RestaurantLoader;
import com.example.michael.lunchfinder.model.Restaurant;

import java.text.NumberFormat;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;


/**
 * The "home" fragment containing first suggested restaurants based on heuristics.
 */
public class MainActivityFragment extends Fragment {

    @InjectView(R.id.restaurant_container)
    LinearLayout mRestaurantContainer;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_main, container, false);

        ButterKnife.inject(this, v);

        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final Activity activity = getActivity();

        // Populate restaurant suggestions in background thread.
        getLoaderManager().initLoader(R.id.loader_restaurant, null, new LoaderManager.LoaderCallbacks<List<Restaurant>>() {
            @Override
            public Loader<List<Restaurant>> onCreateLoader(int id, Bundle args) {
                // TODO show loading
                return new RestaurantLoader(activity);
            }

            @Override
            public void onLoadFinished(Loader<List<Restaurant>> loader, List<Restaurant> data) {
                // TODO end loading indicator
                if(data != null && data.size() > 0) {
                    for(Restaurant r1: data) {
                        // inflate restaurant views and add them dynamically
                        View restaurantView = LayoutInflater.from(activity).inflate(R.layout.restaurant, mRestaurantContainer, false);
                        TextView restaurantName = (TextView) restaurantView.findViewById(R.id.title_text);
                        TextView restaurantPriceRange = (TextView) restaurantView.findViewById(R.id.price_range);

                        restaurantName.setText(r1.getName());
                        // TODO move to strings file
                        NumberFormat currencyFormat = NumberFormat
                                .getCurrencyInstance();

                        restaurantPriceRange.setText(currencyFormat.format(r1.getMinPrice()) + " - " + currencyFormat.format(r1.getMaxPrice()));

                        mRestaurantContainer.addView(restaurantView);
                    }
                } else if(data == null) {
                    // TODO Embed error message text in screen. Refresh button?
                    Toast.makeText(activity, R.string.error_load_failed, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(activity, R.string.error_no_restaurants_found, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onLoaderReset(Loader<List<Restaurant>> loader) {
                // nothing needed
            }
        });
    }
}

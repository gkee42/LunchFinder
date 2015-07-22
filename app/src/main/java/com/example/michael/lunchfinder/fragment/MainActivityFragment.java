package com.example.michael.lunchfinder.fragment;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.michael.lunchfinder.R;
import com.example.michael.lunchfinder.loader.RestaurantLoader;
import com.example.michael.lunchfinder.model.Restaurant;

import butterknife.ButterKnife;
import butterknife.InjectView;


/**
 * The "home" fragment containing first suggested restaurants based on heuristics.
 */
public class MainActivityFragment extends Fragment {

//    @InjectView(R.id.title_text)
    TextView mRestaurantName;

//    @InjectView(R.id.price_range)
    TextView mRestaurantPriceRange;


    TextView mRestaurantName2;
    TextView mRestaurantPriceRange2;

    TextView mRestaurantName3;
    TextView mRestaurantPriceRange3;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_main, container, false);

//        ButterKnife.inject(this, v);

        mRestaurantName = (TextView) v.findViewById(R.id.suggestion_1).findViewById(R.id.title_text);
        mRestaurantPriceRange = (TextView) v.findViewById(R.id.suggestion_1).findViewById(R.id.price_range);
        mRestaurantName2 = (TextView) v.findViewById(R.id.suggestion_2).findViewById(R.id.title_text);
        mRestaurantPriceRange2 = (TextView) v.findViewById(R.id.suggestion_2).findViewById(R.id.price_range);
        mRestaurantName3 = (TextView) v.findViewById(R.id.suggestion_3).findViewById(R.id.title_text);
        mRestaurantPriceRange3 = (TextView) v.findViewById(R.id.suggestion_3).findViewById(R.id.price_range);

        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final Activity activity = getActivity();

        getLoaderManager().initLoader(R.id.loader_restaurant, null, new LoaderManager.LoaderCallbacks<Restaurant>() {
            @Override
            public Loader<Restaurant> onCreateLoader(int id, Bundle args) {
                return new RestaurantLoader(activity);
            }

            @Override
            public void onLoadFinished(Loader<Restaurant> loader, Restaurant data) {
                if(data != null) {
                    mRestaurantName.setText(data.getName());
                    // TODO better string
                    mRestaurantPriceRange.setText(String.format("%.2f - %.2f", data.getMinPrice(), data.getMaxPrice()));

                    // TODO load list of restaurants instead...
                    mRestaurantName3.setText(data.getName());
                    mRestaurantPriceRange3.setText(String.format("%.2f - %.2f", data.getMinPrice(), data.getMaxPrice()));
                } else {
                    // TODO string file
                    mRestaurantName.setText("Unable to load restaurant");
                }
            }

            @Override
            public void onLoaderReset(Loader<Restaurant> loader) {
                // nothing needed
            }
        });
    }
}

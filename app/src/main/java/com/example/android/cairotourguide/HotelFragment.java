package com.example.android.cairotourguide;


import android.graphics.Color;
import android.os.Bundle;
import com.google.android.material.navigation.NavigationView;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotelFragment extends Fragment {


    public HotelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // setting up the root view for this fragment
        View rootView = inflater.inflate(R.layout.location_list, container, false);
        // setting up custom action bar
        // find toolbar view
        androidx.appcompat.widget.Toolbar toolbar = rootView.findViewById(R.id.toolbar);
        // set toolbar view as action bar
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        // change toolbar title color to white
        toolbar.setTitleTextColor(Color.WHITE);
        // creating Nav Drawer button
        // first find our action bar
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        // then enable up button
        actionBar.setDisplayHomeAsUpEnabled(true);
        // finally change up button icon to Nav Drawer's 3 horizontal lines icon
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        //Create Location ArrayList to store location objects
        ArrayList<LocationCustomClass> locationObjects = new ArrayList<>();
        locationObjects.add(new LocationCustomClass(getString(R.string.hotel_golden_title),
                R.drawable.hotel_golden,
                getString(R.string.hotel_golden_description),
                getString(R.string.hotel_golden_address)));

        locationObjects.add(new LocationCustomClass(getString(R.string.hotel_steigenberger_title),
                R.drawable.hotel_steigenberger,
                getString(R.string.hotel_steigenberger_description),
                getString(R.string.hotel_steigenberger_address)));

        locationObjects.add(new LocationCustomClass(getString(R.string.hotel_cairo_city_center_title),
                R.drawable.hotel_cairo_city_center,
                getString(R.string.hotel_city_center_description),
                getString(R.string.hotel_city_center_address)));
        // setting up nav Drawer Header
        // first find nav Drawer view
        NavigationView navigationView = (NavigationView) getActivity().findViewById(R.id.nav_view);
        // then find header view inside Nav Drawer view
        View navDrawerHeaderView = navigationView.getHeaderView(0);
        // then find location title textView inside header view and set it
        // to the title of the first location in locationObjects ArrayList
        TextView locationTitle = (TextView) navDrawerHeaderView.findViewById(R.id.nav_header_location_title_textView);
        locationTitle.setText(locationObjects.get(0).getLocationTitle().toString());
        // same as the title textView
        ImageView locationImage = (ImageView) navDrawerHeaderView.findViewById(R.id.nav_header_location_imageView);
        locationImage.setImageResource(locationObjects.get(0).getImageResourceId());
        // find Locations listView
        ListView locationListView = (ListView) rootView.findViewById(R.id.locationListView);
        // create custom location adapter to handle location Objects
        LocationCustomAdapter locationAdapter = new LocationCustomAdapter(getActivity(), locationObjects);
        // connect adapter to location ListView
        locationListView.setAdapter(locationAdapter);
        return rootView;
    }

}

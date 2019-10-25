package com.example.android.cairotourguide;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Affandy on 11/06/2018.
 */

public class LocationCustomAdapter extends ArrayAdapter<LocationCustomClass> {
    private Activity mContext;

    public LocationCustomAdapter(Activity context, ArrayList<LocationCustomClass> locations) {
        super(context, 0, locations);
        mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false);
        }
        LocationCustomClass currentLocation = getItem(position);
        //find location data views such as title, description and address TextView and location
        // image ImageView then set appropriate value from currentLocation object
        TextView locationTitle = (TextView) listItemView.findViewById(R.id.location_title_textView);
        locationTitle.setText(currentLocation.getLocationTitle());

        TextView locationDescription = (TextView) listItemView.findViewById(R.id.location_description_textView);
        locationDescription.setText(currentLocation.getLocationDescription());

        TextView locationAddress = (TextView) listItemView.findViewById(R.id.location_address_textView);
        locationAddress.setText(currentLocation.getLocationAddress());

        ImageView locationImage = (ImageView) listItemView.findViewById(R.id.location_imagView);
        locationImage.setImageResource(currentLocation.getImageResourceId());
        return listItemView;
    }
}

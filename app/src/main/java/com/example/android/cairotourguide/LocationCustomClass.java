package com.example.android.cairotourguide;

/**
 * Created by Affandy on 11/06/2018.
 */

public class LocationCustomClass {
    private String mLocationTitle;
    private String mLocationDescription;
    private String mLocationAddress;
    private int mImageResourceId;

    public LocationCustomClass(String locationTitle, int imageResourceId,
                               String locationDescription, String locationAddress) {
        // member variables to hold location data such as title, description, address and image
        mLocationTitle = locationTitle;
        mImageResourceId = imageResourceId;
        mLocationDescription = locationDescription;
        mLocationAddress = locationAddress;
    }

    // getters methods to return member variables
    public String getLocationTitle() {
        return mLocationTitle;
    }

    public String getLocationDescription() {
        return mLocationDescription;
    }

    public String getLocationAddress() {
        return mLocationAddress;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }
}

package com.example.android.cairotourguide;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.material.navigation.NavigationView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    // Variable to hold Navigation Drawer Layout
    private DrawerLayout mDrawerLayout = null;
    // when user select an item from nav drawer this counter increases by 1
    private int mNavDrawerSelectedItemCounter = 0;
    // store last selected item from nav drawer
    private MenuItem mLastSelectedNavDrawerItem = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // find DrawerLayout view
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        //find Navigation View which is in DrawerLayout
        NavigationView navigationView = findViewById(R.id.nav_view);
        // setting up default screen for main activity which is Hotel list
        final FragmentManager fragmentManager = getSupportFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        // create hotel fragment and replace it with frame layout in main activity
        HotelFragment hotelFragment = new HotelFragment();
        fragmentTransaction.add(R.id.mainContentFrame, hotelFragment);
        fragmentTransaction.commit();
        // because default screen is hotel list then get hotel item from nav Drawer and set it
        // as checked
        final MenuItem defaultItem = (MenuItem) navigationView.getMenu().findItem(R.id.nav_hotels);
        defaultItem.setChecked(true);
        //Set listener to respond when the user select an item from Nav Drawer
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // user selected an item from nav drawer then increase the counter
                mNavDrawerSelectedItemCounter++;
                // if mNavDrawerSelectedCounter > 1 this means that there exist a previous selected
                // item which needs to be unchecked
                // else this is the first selected item and previous selected item was default item
                // which is hotel item
                if (mNavDrawerSelectedItemCounter > 1) {
                    // uncheck previous item
                    mLastSelectedNavDrawerItem.setChecked(false);
                    // hold current selected item because next time it will be the previous
                    // selected item
                    mLastSelectedNavDrawerItem = item;
                } else {
                    // uncheck default item which is hotels
                    defaultItem.setChecked(false);
                    // hold current selected item because next time it will be the previous
                    // selected item
                    mLastSelectedNavDrawerItem = item;
                }
                // start new fragment transaction rather than default fragment transaction
                FragmentTransaction newFragmentTransaction = fragmentManager.beginTransaction();
                // set current selected item as checked
                item.setChecked(true);
                // check selected item id then create an appropriate fragment and replace it with
                // frame layout in  main activity
                switch (item.getItemId()) {
                    case R.id.nav_hotels:
                        HotelFragment hotelFragment = new HotelFragment();
                        newFragmentTransaction.replace(R.id.mainContentFrame, hotelFragment);
                        break;
                    case R.id.nav_restaurants:
                        RestaurantFragment restaurantFragment = new RestaurantFragment();
                        newFragmentTransaction.replace(R.id.mainContentFrame, restaurantFragment);
                        break;
                    case R.id.nav_shopping:
                        ShoppingFragment shoppingFragment = new ShoppingFragment();
                        newFragmentTransaction.replace(R.id.mainContentFrame, shoppingFragment);
                        break;
                    case R.id.nav_monuments:
                        MonumentFragment monumentFragment = new MonumentFragment();
                        newFragmentTransaction.replace(R.id.mainContentFrame, monumentFragment);
                        break;
                }
                // apply replacing the appropriate fragment with frame layout in main activity
                newFragmentTransaction.commit();
                // change title in toolbar to the selected item title
                setTitle(item.getTitle());
                // close nav drawer when item is tapped
                mDrawerLayout.closeDrawers();
                return true;
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //when nav drawer icon clicked, open nav drawer menu
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

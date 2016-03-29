package com.example.arunima.myapplication;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by Arunima on 15-03-2016.
 */
public class LocationSpinner extends AppCompatActivity  {
    private SeekBar seekBar;
    private TextView textView1;
    Button btnShowLocation;
    TextView current_Addr;
    MyCurrentLocationListener currloc;
    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    android.support.v4.app.FragmentTransaction fragmentTransaction;
    //private Toolbar toolbar;
    NavigationView navigationView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comparison);

        //Spinner location = (Spinner) findViewById(R.id.locations_spinner);
        //String[] locArray;

        //locArray = getResources().getStringArray(R.array.locations_array);
        seekBar = (SeekBar) findViewById(R.id.seekBar1);
        textView1 = (TextView) findViewById(R.id.textView1);
        btnShowLocation = (Button) findViewById(R.id.current_loc);
        current_Addr = (TextView) findViewById(R.id.curr_addr);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.flContent, new ComparisonFragment());
        fragmentTransaction.commit();
        getSupportActionBar().setTitle("Location");
        navigationView = (NavigationView) findViewById(R.id.nvView);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_first_fragment:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.flContent, new ProfileFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("First");
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.nav_second_fragment:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.flContent, new NotificationFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Second");
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.nav_third_fragment:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.flContent, new SettingsFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Third");
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;

                }
                return false;
            }
        });

    }
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }


}

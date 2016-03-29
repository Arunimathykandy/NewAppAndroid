package com.example.arunima.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Arunima on 24-03-2016.
 */
public class Ambulance extends AppCompatActivity {
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    android.support.v4.app.FragmentTransaction fragmentTransaction;
    NavigationView navigationView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.locattion_drawer);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.loc_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.infinityf);

        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.flContent, new AmbulanceFragment());
        fragmentTransaction.commit();

        navigationView = (NavigationView) findViewById(R.id.nvView);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_first_fragment:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.flContent, new ProfileFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Profile");
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.nav_second_fragment:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.flContent, new NotificationFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Notification");
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.nav_third_fragment:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.flContent, new SettingsFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Settings");
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.nav_fourth_fragment:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.flContent, new SymptomFragment());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Symptoms");
                        item.setChecked(true);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.nav_fifth_fragment:
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.flContent, new HealthTip());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Health Tips");
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

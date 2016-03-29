package com.example.arunima.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Arunima on 24-03-2016.
 */
public class AreaActivity extends AppCompatActivity {
    Button nextButton;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    android.support.v4.app.FragmentTransaction fragmentTransaction;
    NavigationView navigationView;
    Spinner area_care;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.area_activity);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.loc_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        area_care=(Spinner)findViewById(R.id.area_spinner);
        nextButton = (Button) findViewById(R.id.done_area);
        String[] area_array;
        area_array = getResources().getStringArray(R.array.care_area_array);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.infinityf);

        /*fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.flContent, new LocationFragment());
        fragmentTransaction.commit();*/
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, area_array) {

            public boolean isEnabled(int position) {
                if (position == 0) {
                    // Disable the first item from Spinner
                    // First item will be use for hint
                    return false;
                } else {
                    return true;
                }
            }

            public View getDropDownView(int position, View convertView,
                                        ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);
                TextView tv = (TextView) view;
                if (position == 0) {
                    // Set the hint text color gray
                    tv.setTextColor(Color.GRAY);
                } else {
                    tv.setTextColor(Color.BLACK);
                }
                return view;
            }

        };
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        area_care.setAdapter(adapter);
        area_care.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemText = (String) parent.getItemAtPosition(position);
                // If user change the default selection
                // First item is disable and it is used for hint
                if (position > 0) {
                    // Notify the selected item text
                    Toast.makeText(getApplicationContext(), "Selected : " + selectedItemText, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


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

        /*nextButton = (Button) findViewById(R.id.next);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LocationActivity.this, RadiusActivity.class);
                startActivity(i);

            }
        });*/
        //toolbar.setLogo(R.mipmap.infinity);



    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // action with ID action_refresh was selected
            case R.id.action_ambulance:
                Intent intent = new Intent(AreaActivity.this, Ambulance.class);
                startActivity(intent);
                break;
            // action with ID action_settings was selected
            default:
                break;
        }
        return true;
    }
    public void AreaDone(View view) {

        Intent intent = new Intent(AreaActivity.this,HospitalList.class);
        startActivity(intent);
    }

}


package com.example.arunima.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Arunima on 23-03-2016.
 */
public class HospitalList extends AppCompatActivity {
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    android.support.v4.app.FragmentTransaction fragmentTransaction;
    NavigationView navigationView;
    String[] listviewTitle = new String[]{
            "ListView Title 1", "ListView Title 2", "ListView Title 3", "ListView Title 4",
            "ListView Title 5", "ListView Title 6", "ListView Title 7", "ListView Title 8",
    };


    int[] listviewImage = new int[]{
            R.drawable.ic_hospital_resized, R.drawable.ic_hospital_resized, R.drawable.ic_hospital_resized, R.drawable.ic_hospital_resized,
            R.drawable.ic_hospital_resized, R.drawable.ic_hospital_resized, R.drawable.ic_hospital_resized, R.drawable.ic_hospital_resized,
    };

    String[] listviewShortDescription = new String[]{
            "Android ListView Short Description", "Android ListView Short Description", "Android ListView Short Description", "Android ListView Short Description",
            "Android ListView Short Description", "Android ListView Short Description", "Android ListView Short Description", "Android ListView Short Description",
    };


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
        fragmentTransaction.add(R.id.flContent, new HospitalFragment());
        fragmentTransaction.commit();

        /*List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < 8; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("listview_title", listviewTitle[i]);
            hm.put("listview_discription", listviewShortDescription[i]);
            hm.put("listview_image", Integer.toString(listviewImage[i]));
            aList.add(hm);
        }

        String[] from = {"listview_image", "listview_title", "listview_discription"};
        int[] to = {R.id.listview_image, R.id.listview_item_title, R.id.listview_item_short_description};

        SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), aList, R.layout.hospital_list_item, from, to);
        ListView androidListView = (ListView) findViewById(R.id.hosp_list_view);
        androidListView.setAdapter(simpleAdapter);*/

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
                Intent intent = new Intent(HospitalList.this, Ambulance.class);
                startActivity(intent);
                break;
            // action with ID action_settings was selected
            default:
                break;
        }
        return true;
    }
}

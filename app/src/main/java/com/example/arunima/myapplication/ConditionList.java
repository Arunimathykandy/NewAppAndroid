package com.example.arunima.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Arunima on 17-03-2016.
 */

public class ConditionList extends Activity {
    ListView condListview;
    ArrayAdapter<String> list_adapter;
    String[] condArray;
    ArrayList<String> list = new ArrayList<String>();
    ArrayList<String> list_item = new ArrayList<String>();
    int count = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.condition_list);
        condListview = (ListView) findViewById(R.id.cond_list);
        condArray = getResources().getStringArray(R.array.condition_array);
        list_adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.rowTextView, condArray);
        condListview.setAdapter(list_adapter);
        Collections.addAll(list, condArray);
        //final Button buttonNote = (Button) findViewById(R.id.fab1);
        //final Button buttonNote = (Button) findViewById(R.id.note);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab1);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ConditionList.this,
                        ComparisonList.class);
                startActivity(myIntent);
            }
        });



    }
   // final Button buttonNote = (Button) findViewById(R.id.note);
  /* public void FabClicked(View view) {

       Intent intent = new Intent(ConditionList.this,ComparisonList.class);
       startActivity(intent);
   }*/
}

package com.example.arunima.myapplication;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

/**
 * Created by Arunima on 16-03-2016.
 */
public class CustomItemSelected implements AdapterView.OnItemSelectedListener {

    public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {
        Toast.makeText(parent.getContext(),
                "OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString(),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

}


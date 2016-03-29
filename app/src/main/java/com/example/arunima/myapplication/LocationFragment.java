package com.example.arunima.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

/**
 * Created by Arunima on 23-03-2016.
 */
public class LocationFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater,ViewGroup container,
                               Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.location_layout,container,false);
        AutoCompleteTextView autocompleteView = (AutoCompleteTextView)view.findViewById(R.id.autocomplete);
        autocompleteView.setAdapter(new PlacesAutoCompleteAdapter(getActivity().getApplicationContext(), R.layout.autocomplete_list_item));
        autocompleteView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get data associated with the specified position
                // in the list (AdapterView)
                String description = (String) parent.getItemAtPosition(position);
                Toast.makeText(getActivity().getApplicationContext(), description, Toast.LENGTH_SHORT).show();
            }
        });
       return view;
    }
}

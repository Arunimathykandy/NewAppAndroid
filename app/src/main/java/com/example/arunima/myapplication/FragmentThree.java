package com.example.arunima.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Arunima on 21-03-2016.
 */
public class FragmentThree extends Fragment {
    public View onCreateView(LayoutInflater inflater,ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_three, container, false);
        Button b = (Button) view.findViewById(R.id.ok_btn);
        b.setOnClickListener(listener);
        return view;
    }
        //Button btn =(Button) findViewById(R.id.ok_btn);
        //btn.setOnClickListener(listnr);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),Location.class);
                startActivity(intent);
            }
        };

}



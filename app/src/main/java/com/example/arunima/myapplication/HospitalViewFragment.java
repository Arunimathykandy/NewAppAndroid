package com.example.arunima.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Arunima on 25-03-2016.
 */
public class HospitalViewFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.hospital_layout, container, false);
        Button compHosp = (Button) view.findViewById(R.id.comp_hospital);
        compHosp.setOnClickListener(listener);
        return view;
    }
    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getActivity(),HospitalList.class);
            startActivity(intent);
        }
    };
}

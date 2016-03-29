package com.example.arunima.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

/**
 * Created by Arunima on 24-03-2016.
 */
public class SymptomFragment extends Fragment {
    Button sympDone;
    Spinner gender;
    Spinner body;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.symptom_fragment, container, false);
        gender = (Spinner) view.findViewById(R.id.gender_spinner);
        body = (Spinner) view.findViewById(R.id.body_part_spinner);
        String[] gender_array;
        gender_array = getActivity().getResources().getStringArray(R.array.gender_array);
        String[] body_array;
        body_array = getActivity().getResources().getStringArray(R.array.body_part_array);

        final ArrayAdapter<String> gender_adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(),R.layout.spinner_item, gender_array);
        gender_adapter.setDropDownViewResource(R.layout.spinner_item);


        gender.setAdapter(
                new NothingSelectedSpinnerAdapter(
                        gender_adapter,
                        R.layout.contact_spinner_row_nothing_selected_gender,
                        // R.layout.contact_spinner_nothing_selected_dropdown, // Optional
                        getActivity().getApplicationContext()));

        final ArrayAdapter<String> body_adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(),R.layout.spinner_item, body_array);
        body_adapter.setDropDownViewResource(R.layout.spinner_item);

        body.setAdapter(
                new NothingSelectedSpinnerAdapter(
                        body_adapter,
                        R.layout.contact_spinner_row_nothing_selected_body,
                        // R.layout.contact_spinner_nothing_selected_dropdown, // Optional
                        getActivity().getApplicationContext()));
        Button nextRad = (Button) view.findViewById(R.id.done_symp);
        nextRad.setOnClickListener(listener);


        return view;
    }
    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getActivity(),SymptomList.class);
            startActivity(intent);
        }
    };
}



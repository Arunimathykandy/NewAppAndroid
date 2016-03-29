package com.example.arunima.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by Arunima on 23-03-2016.
 */
public class RadiusFragment extends Fragment {
    private SeekBar seekBar;
    private TextView textView1;

    public View onCreateView(LayoutInflater inflater,ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.radius_layout, container, false);
        seekBar=(SeekBar)view.findViewById(R.id.seekBar1);
        textView1 = (TextView)view.findViewById(R.id.textView1);
        Button nextRad = (Button) view.findViewById(R.id.next_rad);
        nextRad.setOnClickListener(listener);

        textView1.setText(String.valueOf(" Search within " + seekBar.getProgress() + " km"));
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                progress = progresValue;
                //Toast.makeText(getApplicationContext(), "Changing seekbar's progress", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //Toast.makeText(getApplicationContext(), "Started tracking seekbar", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textView1.setText(String.valueOf("Search within " + progress + " km"));
                //Toast.makeText(getApplicationContext(), "Stopped tracking seekbar", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getActivity(),AreaActivity.class);
            startActivity(intent);
        }
    };
}

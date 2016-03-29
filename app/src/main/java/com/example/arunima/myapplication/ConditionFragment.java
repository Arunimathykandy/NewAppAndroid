package com.example.arunima.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Arunima on 27-03-2016.
 */
public class ConditionFragment extends Fragment {
    ListView condListview;
    List<HashMap<String, String>> list_item = new ArrayList<HashMap<String, String>>();
    int count = 0;
    String[] listviewTitle = new String[]{
            "Condition 1", "Condition 2", "Condition 3", "Condition 4",
            "Condition 5", "Condition 6", "Condition 7", "Condition 8",
    };

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.condition_activity, container, false);
        final List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < 8; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("listview_title", listviewTitle[i]);
            aList.add(hm);
        }
        String[] from = {"listview_title"};
        int[] to = {R.id.listview_item_title};


        SimpleAdapter simpleAdapter = new SimpleAdapter(getActivity().getBaseContext(), aList, R.layout.condition_list_item, from, to);
        condListview = (ListView) view.findViewById(R.id.cond_list_view);
        condListview.setAdapter(simpleAdapter);
        return view;
    }
}

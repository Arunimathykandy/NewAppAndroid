package com.example.arunima.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Arunima on 24-03-2016.
 */
public class HospitalFragment extends Fragment {
    ListView hospListview;
    List<HashMap<String, String>> list_item = new ArrayList<HashMap<String, String>>();
    int count =0;
    String[] listviewTitle = new String[]{
            "Fortis Hospital", "Columbia Asia Hospital", "M S Ramaiah Hospital", "Vasan Eye Care",
            "Apollo Hospital", "Naryana Hrudyalaya", "Bangalore Baptist Hospital", "Narayana Nethralaya",
    };


    int[] listviewImage = new int[]{
            R.drawable.ic_hospital_resized, R.drawable.ic_hospital_resized, R.drawable.ic_hospital_resized, R.drawable.ic_hospital_resized,
            R.drawable.ic_hospital_resized, R.drawable.ic_hospital_resized, R.drawable.ic_hospital_resized, R.drawable.ic_hospital_resized,
    };

    String[] listviewShortDescription = new String[]{
            "Sheshadripuram", "Malleswaram", "Msr Nagar", "Rajaji Nagar",
            "J P Ngar", "Hosur Road", "Hebbal", "RajajiNagar",
    };
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.hospital_list_layout, container, false);

        final List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < 8; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("listview_title", listviewTitle[i]);
            hm.put("listview_discription", listviewShortDescription[i]);
            hm.put("listview_image", Integer.toString(listviewImage[i]));
            aList.add(hm);
        }

        String[] from = {"listview_image", "listview_title", "listview_discription"};
        int[] to = {R.id.listview_image, R.id.listview_item_title, R.id.listview_item_short_description};

        SimpleAdapter simpleAdapter = new SimpleAdapter(getActivity().getBaseContext(), aList, R.layout.hospital_list_item, from, to);
        hospListview = (ListView) view.findViewById(R.id.hosp_list_view);
        hospListview.setAdapter(simpleAdapter);
        hospListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {
                Intent appInfo = new Intent(getActivity().getApplicationContext(), Hospital.class);
                startActivity(appInfo);
            }
        });

        hospListview.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        hospListview.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
                count = count+1;
                mode.setTitle(count+" selected");
                list_item.add(aList.get(position));
                if(count > 2) {
                    Toast.makeText(getActivity().getApplicationContext(), R.string.pop_up, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                MenuInflater inflater = mode.getMenuInflater();
                inflater.inflate(R.menu.contextmenu, menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {

                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                switch(item.getItemId()) {
                    case R.id.compare:
                       /*for(String msg : list_item)
                       {
                           list_adapter.remove(msg);
                       }
                           Toast.makeText(getBaseContext(),count+ "items removed", Toast.LENGTH_SHORT).show();*/
                        Intent i = new Intent(getActivity().getApplicationContext(), Comparison.class);
                        startActivity(i);

                        count=0;
                        mode.finish();
                        return true;
                    default:
                        return false;

                }

                //return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }
        });
        return view;
    }
}

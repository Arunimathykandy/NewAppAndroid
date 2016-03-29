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
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.locks.Condition;

/**
 * Created by Arunima on 26-03-2016.
 */
public class SymptomListFragment extends Fragment {
    ListView sympListview;
    List<HashMap<String, String>> list_item = new ArrayList<HashMap<String, String>>();
    int count =0;
    String[] listviewTitle = new String[]{
            "Symptom 1", "Symptom 2", "Symptom 3", "Symptom 4",
            "Symptom 5", "Symptom 6", "Symptom 7", "Symptom 8",
    };
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.symptom_list_layout, container, false);
        final List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < 8; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("listview_title", listviewTitle[i]);
            aList.add(hm);
        }
            String[] from = {"listview_title"};
            int[] to = {R.id.listview_item_title};


            SimpleAdapter simpleAdapter = new SimpleAdapter(getActivity().getBaseContext(), aList, R.layout.symptom_list_item, from, to);
            sympListview = (ListView) view.findViewById(R.id.symptom_list_view);
            sympListview.setAdapter(simpleAdapter);
        sympListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {
                Intent appInfo = new Intent(getActivity().getApplicationContext(), com.example.arunima.myapplication.Condition.class);
                startActivity(appInfo);
            }
        });


        sympListview.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
            sympListview.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
                @Override
                public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
                    count = count + 1;
                    mode.setTitle(count + " selected");
                    list_item.add(aList.get(position));
                    if (count > 2) {
                        Toast.makeText(getActivity().getApplicationContext(), R.string.pop_up, Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                    MenuInflater inflater = mode.getMenuInflater();
                    inflater.inflate(R.menu.context_menu_two, menu);
                    return true;
                }

                @Override
                public boolean onPrepareActionMode(ActionMode mode, Menu menu) {

                    return false;
                }

                @Override
                public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.Next:
                       /*for(String msg : list_item)
                       {
                           list_adapter.remove(msg);
                       }
                           Toast.makeText(getBaseContext(),count+ "items removed", Toast.LENGTH_SHORT).show();*/
                            Intent i = new Intent(getActivity().getApplicationContext(), com.example.arunima.myapplication.Condition.class);
                            startActivity(i);

                            count = 0;
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

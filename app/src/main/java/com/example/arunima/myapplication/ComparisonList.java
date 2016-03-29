package com.example.arunima.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Arunima on 20-03-2016.
 */

public class ComparisonList extends Activity {
    ListView hospListview;
    ArrayAdapter<String> list_adapter;
    String[] hospArray;
    ArrayList<String> list = new ArrayList<String>();
    ArrayList<String> list_item = new ArrayList<String>();
    int count =0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comparison_list);
        hospListview = (ListView) findViewById(R.id.comp_list);
        hospArray = getResources().getStringArray(R.array.hospital_array);
        list_adapter = new ArrayAdapter<String>(this,R.layout.list_item,R.id.rowTextView,hospArray);
        hospListview.setAdapter(list_adapter);
        //list = Arrays.asList(condArray);
        Collections.addAll(list,hospArray);

        hospListview.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        hospListview.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
                count = count+1;
                mode.setTitle(count + " items selected");
                list_item.add(list.get(position));
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
                        Intent i = new Intent(ComparisonList.this, Comparison.class);
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

    }
}

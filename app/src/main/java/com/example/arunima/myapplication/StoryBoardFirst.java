package com.example.arunima.myapplication;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

/**
 * Created by Arunima on 20-03-2016.
 */
public class StoryBoardFirst extends FragmentActivity {
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.storyboard_first);
        viewPager = (ViewPager)findViewById(R.id.pager);
        PageAdapter pgadapter = new PageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pgadapter);
    }
}

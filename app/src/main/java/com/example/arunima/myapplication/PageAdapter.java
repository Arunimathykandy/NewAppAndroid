package com.example.arunima.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Arunima on 20-03-2016.
 */
public class PageAdapter extends FragmentPagerAdapter {

    public PageAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int arg0) {
        switch (arg0) {
            case 0:
                return new FragmentOne();
            case 1:
                return new FragmentTwo();
            case 2:
                return new FragmentThree();
            default:
                break;
        }
                return null;
    }
    public int getCount() {
        return 3;
    }

}

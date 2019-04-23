package com.example.lab_2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentManager;

import com.example.lab_2.Calculator;
import com.example.lab_2.Info;

public class PagerAdapter extends FragmentStatePagerAdapter {

    int mNumTabs;

    public PagerAdapter(FragmentManager fm, int numTabs) {
        super(fm);
        this.mNumTabs = numTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                Info info =  new Info();
                return info;
            case 1:
                Calculator calculator = new Calculator();
                return calculator;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumTabs;
    }
}

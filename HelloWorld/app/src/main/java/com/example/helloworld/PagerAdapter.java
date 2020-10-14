package com.example.helloworld;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {
private int numOfTabs;


    public PagerAdapter(FragmentManager fragman, int numOfTabs){
     super(fragman);
     this.numOfTabs = numOfTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0 : return new Fragmentsatu();
            case 1 : return new Fragmentdua();
            default: return null;
        }

    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}

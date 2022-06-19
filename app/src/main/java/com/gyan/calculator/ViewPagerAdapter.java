package com.gyan.calculator;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.gyan.calculator.fragment.EqualtoFragment;
import com.gyan.calculator.fragment.HomeFragment;
import com.gyan.calculator.fragment.MoreFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new EqualtoFragment();
            case 1:
                return new MoreFragment();
            case 2:
                return new HomeFragment();
            default:
                return new EqualtoFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}

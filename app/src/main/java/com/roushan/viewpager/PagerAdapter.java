package com.roushan.viewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter{

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int fragment) {
        switch (fragment) {
            case 0:
                return new Frag1();
            case 1:
                return new Frag2();
            case 2:
                return new Frag3();
            case 3:
                return new Frag4();
            default:
                break;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }
}

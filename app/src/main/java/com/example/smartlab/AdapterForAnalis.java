package com.example.smartlab;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class AdapterForAnalis extends FragmentPagerAdapter {
    public AdapterForAnalis(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new FragmentPopular();
            case 1:
                return new FragmentCovid();
            case 2:
                return new FragmentComplex();
            case 3:
                return new FragmentOncolog();

        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }

}

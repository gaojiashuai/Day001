package com.example.wandemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by 你瞅啥 on 2017/9/22.
 */
public class FragmentAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> list;
    private ArrayList<String> Stringlist;
    public FragmentAdapter(FragmentManager fm,ArrayList<Fragment> list,ArrayList<String> Stringlist) {
        super(fm);
        this.list=list;
        this.Stringlist=Stringlist;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return Stringlist.get(position);
    }
}

package com.example.wandemo;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager pager;
    private TabLayout tablayout;
    private ArrayList<Fragment> list;
    private ArrayList<String> Stringlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initAdapter();
    }

    private void initAdapter() {
        FragmentAdapter adapter=new FragmentAdapter(getSupportFragmentManager(),list,Stringlist);
        pager.setAdapter(adapter);
        tablayout.setupWithViewPager(pager);
    }

    private void initData() {
         list=new ArrayList<Fragment>();
        list.add(new AFragment());
        list.add(new BFragment());
    }

    private void initView() {
        pager = (ViewPager) findViewById(R.id.pager);
        tablayout = (TabLayout) findViewById(R.id.tablayout);
        Stringlist=new ArrayList<String>();
        Stringlist.add("列表");
        Stringlist.add("信息");
        /*tablayout.addTab(tablayout.newTab().setText("列表"));
        tablayout.addTab(tablayout.newTab().setText("信息"));*/
    }
}

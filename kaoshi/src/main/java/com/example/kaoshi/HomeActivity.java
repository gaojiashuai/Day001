package com.example.kaoshi;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private TextView txt1;
    private ViewPager pager;
    private RadioButton shou;
    private RadioButton ge;
    private RadioGroup group;
    private ArrayList<Fragment> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
        initData();
        initAdapter();
        pager.setCurrentItem(0);
    }

    private void initAdapter() {
MyAdapter adapter=new MyAdapter(getSupportFragmentManager(),list);
        pager.setAdapter(adapter);

    }

    private void initData() {
         list=new ArrayList<Fragment>();
        list.add(new AFragment());
        list.add(new BFragment());
    }

    private void initView() {
        txt1 = (TextView) findViewById(R.id.txt1);
        pager = (ViewPager) findViewById(R.id.pager);
        shou = (RadioButton) findViewById(R.id.shou);
        ge = (RadioButton) findViewById(R.id.ge);
        group = (RadioGroup) findViewById(R.id.group);

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==R.id.shou){
                    pager.setCurrentItem(0);
                }
                if(i==R.id.ge){
                    pager.setCurrentItem(1);
                }
            }
        });

    }
}

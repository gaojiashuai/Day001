package com.example.kaoshi;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class AFragment extends Fragment {


    private ListView lv;
    private ArrayList<String> list;

    public AFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        initView(view);
        initData();
        initAdapter();
        return view;
    }

    private void initData() {

        list=new ArrayList<String>();
        for (int i = 0; i <10 ; i++) {
            list.add("hello"+i);
        }
    }

    private void initAdapter() {
        MyListViewAdapter adapter=new MyListViewAdapter(list,getActivity());
        lv.setAdapter(adapter);
    }

    private void initView(View view) {
        lv = (ListView) view.findViewById(R.id.lv);
    }
}

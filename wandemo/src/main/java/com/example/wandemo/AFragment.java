package com.example.wandemo;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AFragment extends Fragment {


    private ImageView bitmap;
    private TextView name;
    private TextView sex;
    private TextView age;
    private RelativeLayout relative1;
    private ImageView bitmap1;
    private ImageView bitmap2;
    private ImageView bitmap3;
    private TextView name1;
    private TextView sex1;
    private TextView age1;
    private RelativeLayout relative2;

    public AFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);

        initView(view);
        initData();
        return view;
    }

    private void initData() {
        relative1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(getActivity(),BFragment.class);
                getActivity().startActivity(in);
            }
        });
    }

    private void initView(View view) {
        bitmap = (ImageView) view.findViewById(R.id.bitmap);
        name = (TextView) view.findViewById(R.id.name);
        sex = (TextView) view.findViewById(R.id.sex);
        age = (TextView) view.findViewById(R.id.age);
        relative1 = (RelativeLayout) view.findViewById(R.id.relative1);
        bitmap1 = (ImageView) view.findViewById(R.id.bitmap1);
        bitmap2 = (ImageView) view.findViewById(R.id.bitmap2);
        bitmap3 = (ImageView) view.findViewById(R.id.bitmap3);
        name1 = (TextView) view.findViewById(R.id.name1);
        sex1 = (TextView) view.findViewById(R.id.sex1);
        age1 = (TextView) view.findViewById(R.id.age1);
        relative2 = (RelativeLayout) view.findViewById(R.id.relative2);
    }
}

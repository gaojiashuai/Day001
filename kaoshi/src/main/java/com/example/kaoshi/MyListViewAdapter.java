package com.example.kaoshi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 你瞅啥 on 2017/9/21.
 */
public class MyListViewAdapter extends BaseAdapter {
    private ArrayList<String> list;
    private Context context;

    public MyListViewAdapter(ArrayList<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override

    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder h;
        if(view==null) {
            h=new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.item, null);
            h.txt= (TextView) view.findViewById(R.id.txt);
            view.setTag(h);
        }else{
            h= (ViewHolder) view.getTag();
        }
        h.txt.setText(list.get(i));
        return view;
    }
    class ViewHolder{
        private TextView txt;
    }
}

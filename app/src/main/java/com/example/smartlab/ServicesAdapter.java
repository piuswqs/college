package com.example.smartlab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ServicesAdapter extends BaseAdapter {
    Context ctx;
    LayoutInflater inflater;
    ArrayList<Services> objects;

    ServicesAdapter(Context context, ArrayList<Services> services){
        ctx = context;
        objects = services;
        inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = inflater.inflate(R.layout.custom, parent, false);
        }

        Services s = getServices(position);
        TextView textServ = view.findViewById(R.id.itemLVtext);
        TextView textData = view.findViewById(R.id.itemLVdata);
        TextView textPrice = view.findViewById(R.id.itemLVcost);

        Services services = objects.get(position);
        textServ.setText(services.getNameService());
        textData.setText(services.getData());
        textPrice.setText(services.getPrice());

        return view;
    }

    Services getServices(int position){
        return ((Services) getItem(position));
    }
}

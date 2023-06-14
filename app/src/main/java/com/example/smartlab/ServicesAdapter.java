package com.example.smartlab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ServicesAdapter extends RecyclerView.Adapter<ServicesAdapter.ViewHolder> {
    LayoutInflater inflater;
    ArrayList<Services> services;

    ServicesAdapter(Context context, ArrayList<Services> services){
        this.services = services;
        this.inflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public ServicesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ServicesAdapter.ViewHolder holder, int position) {
        Services service = services.get(position);
        holder.dataView.setText(service.getData());
        holder.textView.setText(service.getNameService());
        holder.costView.setText(service.getPrice());
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return services.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView textView, costView, dataView;
        ViewHolder(View view){
            super(view);
            textView = view.findViewById(R.id.itemLVtext);
            costView = view.findViewById(R.id.itemLVcost);
            dataView = view.findViewById(R.id.itemLVdata);
        }
    }
}

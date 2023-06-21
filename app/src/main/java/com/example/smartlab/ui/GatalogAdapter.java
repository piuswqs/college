package com.example.smartlab.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartlab.R;

import java.util.ArrayList;

public class GatalogAdapter extends RecyclerView.Adapter<GatalogAdapter.ViewHolder> {
    Context context;

    ArrayList<String> catalog_Name ;
    ArrayList<String> catalog_Price ;
    ArrayList<String> catalog_Time_result ;

    ArrayList<String> catalog_ID ;
    ArrayList<String> catalog_Preparation ;
    ArrayList<String> catalog_BIO ;
    ArrayList<String> catalog_Description ;
    ArrayList<String> catalog_Category ;

    public GatalogAdapter(Context context, ArrayList<String> catalog_Name, ArrayList<String> catalog_Price,
                          ArrayList<String> catalog_Time_result){
        this.context = context;
        this.catalog_Name = catalog_Name;
        this.catalog_Price = catalog_Price;
        this.catalog_Time_result = catalog_Time_result;
    }

    @NonNull
    @Override
    public GatalogAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.textView.setText(catalog_Name.get(position));
        holder.costView.setText(catalog_Price.get(position));
        holder.dataView.setText(catalog_Time_result.get(position));
        holder.btnAddBasket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.btnAddBasket.setText("edfgd");
            }
        });

    }

    @Override
    public int getItemCount() {
        return catalog_Name.size();
    }

    public static class  ViewHolder extends RecyclerView.ViewHolder{
        final TextView textView, costView, dataView;
        Button btnAddBasket;
        ViewHolder(View view){
            super(view);
            textView = view.findViewById(R.id.itemLVtext);
            costView = view.findViewById(R.id.itemLVcost);
            dataView = view.findViewById(R.id.itemLVdata);
            btnAddBasket = view.findViewById(R.id.itemAddBtn);
        }
    }
}

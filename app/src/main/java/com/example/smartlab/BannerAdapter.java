package com.example.smartlab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class BannerAdapter extends RecyclerView.Adapter<BannerAdapter.ViewHolder> {

    List<Banner> bannerList;
    Context context;

    public BannerAdapter(Context context, List<Banner> bannerList){
        this.context = context;
        this.bannerList = bannerList;
    }

    @NonNull
    @Override
    public BannerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_banner, parent, false);
        return new BannerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Banner banner = bannerList.get(position);

        holder.textTitle.setText(banner.getName());
        holder.textDescription.setText(banner.getDescription());
        holder.textPrice.setText(banner.getPriceFormat());
    }

    @Override
    public int getItemCount() {
        return bannerList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textTitle, textDescription, textPrice;
        ViewHolder(View view){
            super(view);
            textTitle = view.findViewById(R.id.tvTitle);
            textDescription = view.findViewById(R.id.tvDescr);
            textPrice = view.findViewById(R.id.tvPrice);
        }
    }
}

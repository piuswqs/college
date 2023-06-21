package com.example.smartlab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AnalysisAdapter extends RecyclerView.Adapter<AnalysisAdapter.ViewHolder> {
    LayoutInflater inflater;
    List<Analysis> analyses;
    Context context;

    public interface OnItemClickLisneter {
        void onItemClick(Analysis analysis, int position);
    }
    private OnItemClickLisneter onItemClickAdapter;

    public AnalysisAdapter(List<Analysis> analyses, Context context){
        this.analyses = analyses;
        this.context = context;
    }

    @NonNull
    @Override
    public AnalysisAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom, parent, false);
        return new AnalysisAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnalysisAdapter.ViewHolder holder, int position) {
        Analysis analysis = analyses.get(position);
        holder.dataView.setText(analysis.getTime_result());
        holder.textView.setText(analysis.getName());
        holder.costView.setText(analysis.getPriceFormat());
        holder.btnAddBasket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strBtnText = holder.btnAddBasket.getHint().toString();
                if (strBtnText == "Добавить"){
                    holder.btnAddBasket.setHint("Убрать");
                }
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return analyses.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
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

package com.example.smartlab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import org.w3c.dom.Text;

import java.util.List;

public class AnalysisAdapter extends RecyclerView.Adapter<AnalysisAdapter.ViewHolder> {
    List<Analysis> analyses;
    Context context;

    public interface OnItemClickLisneter {
        void onItemClick(int position, int cost, String text, String name);
    }
    private AnalysisAdapter.OnItemClickLisneter onItemClickNew;

    public AnalysisAdapter(List<Analysis> analyses, Context context, OnItemClickLisneter onItemClickNew){
        this.analyses = analyses;
        this.context = context;
        this.onItemClickNew = onItemClickNew;
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
                Button bt=(Button) v;
                DbHelperK dbHelperK=new DbHelperK(v.getContext());
                if (bt.getHint().equals("Добавить")){
                    if (onItemClickNew!=null){
                        bt.setHint("Убрать");
                        bt.setBackgroundResource(R.drawable.button_white_with_stroke);
                        bt.setHintTextColor(R.color.sm_blue);
                        dbHelperK.addNewObject(analysis.getName(), analysis.getPriceFormatInteger());
                        onItemClickNew.onItemClick(position, analysis.getPriceFormatInteger(),String.valueOf(bt.getText()), analysis.getName());}
                    }
                else{
                    if (onItemClickNew!=null){
                        bt.setHint("Добавить");
                        bt.setBackgroundResource(R.drawable.button_blue_roundedcorn);
                        bt.setHintTextColor(R.color.white);
                        dbHelperK.deleteRow(analysis.getName());
                        onItemClickNew.onItemClick(position, analysis.getPriceFormatInteger(),String.valueOf(bt.getText()), analysis.getName());}
                    }
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context, R.style.BottomSheetDialogTheme);

                DbHelperK dbHelperK=new DbHelperK(v.getContext());

                View bottomSheetView = LayoutInflater.from(context)
                        .inflate(R.layout.description_item,
                                (LinearLayout)v.findViewById(R.id.bottomSheetDialogDescription));

                TextView titleDescr = bottomSheetView.findViewById(R.id.textTitleDescription);
                TextView textDescription = bottomSheetView.findViewById(R.id.textDescription);
                TextView textDopInfo = bottomSheetView.findViewById(R.id.textDopInfo);
                TextView textResult = bottomSheetView.findViewById(R.id.textResult);
                TextView textBio = bottomSheetView.findViewById(R.id.textBio);

                titleDescr.setText(analysis.getName());
                textDescription.setText(analysis.getDescription());
                textDopInfo.setText(analysis.getPreparation());
                textResult.setText(analysis.getTime_result());
                textBio.setText(analysis.getBio());

                bottomSheetView.findViewById(R.id.btnAddToBasket).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dbHelperK.addNewObject(analysis.getName(), analysis.getPriceFormatInteger());
                        onItemClickNew.onItemClick(position,  analysis.getPriceFormatInteger(),"Добавить", analysis.getName());
                    }
                });
                bottomSheetView.findViewById(R.id.btnCloseBottomSheet).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bottomSheetDialog.dismiss();
                    }
                });
                bottomSheetDialog.setContentView(bottomSheetView);
                bottomSheetDialog.show();
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

package com.example.smartlab.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartlab.APIInterface;
import com.example.smartlab.Analysis;
import com.example.smartlab.AnalysisAdapter;
import com.example.smartlab.AnalysisResult;
import com.example.smartlab.R;
import com.example.smartlab.RetrofitClient;
import com.example.smartlab.databinding.FragmentAnalyzBinding;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnalyzFragment extends Fragment {


    List<Analysis> analyses;
    AnalysisAdapter analysisAdapter;
    View v;
    APIInterface apiInterface;
    List<Analysis> analisResponseList;

    public AnalyzFragment(){

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

       v = inflater.inflate(R.layout.fragment_analyz, container, false);

        RecyclerView listView = v.findViewById(R.id.lv);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(v.getContext());
        listView.setLayoutManager(linearLayoutManager);
        analysisAdapter = new AnalysisAdapter(analyses, v.getContext());

        analyses = new ArrayList<>();

        apiInterface = RetrofitClient.getClient().create(APIInterface.class);
        Call<List<Analysis>> call = apiInterface.getAnalyses();
        call.enqueue(new Callback<List<Analysis>>() {
            @Override
            public void onResponse(Call<List<Analysis>> call, Response<List<Analysis>> response) {
                if (response.isSuccessful()){
                    analisResponseList =  response.body();
                    for (Analysis analis: analisResponseList){
                        if (analis.getCategory().contains("Популярные")){
                            analyses.add(analis);
                        }
                    }
                    analysisAdapter = new AnalysisAdapter(analyses, v.getContext());
                    listView.setLayoutManager(new LinearLayoutManager(v.getContext(), LinearLayoutManager.VERTICAL, false));
                    listView.setAdapter(analysisAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<Analysis>> call, Throwable t) {
                Toast.makeText(getActivity(), "Ошибка загрузки данных "+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
       return v;
    }
}
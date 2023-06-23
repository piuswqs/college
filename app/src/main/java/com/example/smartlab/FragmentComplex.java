package com.example.smartlab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentComplex extends Fragment {
    View v;
    APIInterface apiInterface;
    List<Analysis> analyses;
    List<Analysis> analisResponseList;
    AnalysisAdapter analysisAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_complex, container, false);

        analyses = new ArrayList<Analysis>();
        RecyclerView listView = v.findViewById(R.id.recyclerViewComplex);

        apiInterface = RetrofitClient.getClient().create(APIInterface.class);

        Call<AnalysisResult> callAnalysis = apiInterface.getAnalyses();
        callAnalysis.enqueue(new Callback<AnalysisResult>() {
            @Override
            public void onResponse(Call<AnalysisResult> call, Response<AnalysisResult> response) {
                if (response.isSuccessful()){
                    analisResponseList =  response.body().getAnalyses();
                    analyses = new ArrayList<Analysis>();
                    for (Analysis analysis: analisResponseList){
                        if (analysis.getCategoryString().contains("3")){
                            analyses.add(analysis);
                        }
                        analysisAdapter = new AnalysisAdapter(analyses, v.getContext(), (AnalysisAdapter.OnItemClickLisneter)  v.getContext());
                        listView.setLayoutManager(new LinearLayoutManager(v.getContext(),
                                LinearLayoutManager.VERTICAL, false));
                        listView.setAdapter(analysisAdapter);
                    }
                }
            }
            @Override
            public void onFailure(Call<AnalysisResult> call, Throwable t) {
                Toast.makeText(getActivity(), "Ошибка загрузки данных "+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }
}
package com.example.smartlab.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.smartlab.R;
import com.example.smartlab.Services;
import com.example.smartlab.ServicesAdapter;
import com.example.smartlab.databinding.FragmentAnalyzBinding;

import java.util.ArrayList;

public class AnalyzFragment extends Fragment {
    ArrayList<Services> services = new ArrayList<Services>();
    private FragmentAnalyzBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        AnalyzViewModel analyzViewModel = new ViewModelProvider(this).get(AnalyzViewModel.class);

        binding = FragmentAnalyzBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        setData();
        RecyclerView listView = root.findViewById(R.id.lv);
        ServicesAdapter servicesAdapter = new ServicesAdapter(getContext(), services);
        listView.setAdapter(servicesAdapter);

        return root;

    }
    void setData(){
        services.add(new Services("ПЦР-тест на определение РНК коронавируса стандратный", "2 дня","1800 ₽"));
        services.add(new Services("Клинический анализ крови с лейкоцитарной формулировкой","1 день","690 ₽"));
        services.add(new Services("Биохимический анализ крови, базовый", "1 день", "2440 ₽"));
        services.add(new Services("СОЭ (венозная кровь)","1 день","290 ₽"));
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
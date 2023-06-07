package com.example.smartlab.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.smartlab.databinding.FragmentAnalyzBinding;
public class AnalyzFragment extends Fragment {

    private FragmentAnalyzBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        AnalyzViewModel analyzViewModel =
                new ViewModelProvider(this).get(AnalyzViewModel.class);

        binding = FragmentAnalyzBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.action;
        analyzViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;



    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
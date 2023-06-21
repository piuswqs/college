package com.example.smartlab.ui.profile;

import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.smartlab.R;
import com.example.smartlab.databinding.FragmentProfileBinding;

public class ProfileFragment extends Fragment {
    private FragmentProfileBinding binding;
    View v;

    public ProfileFragment(){

    }

    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    public static final String APP_PREFERENCES = "mysettings";
    public static final String APP_PREFERENCES_Name = "NAME";
    public static final String APP_PREFERENCES_Surname = "SURNAME";
    public static final String APP_PREFERENCES_Patronymic = "PATRONYMIC";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_profile, container, false);

        preferences = v.getContext().getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        editor = preferences.edit();
        String strName = preferences.getString(APP_PREFERENCES_Name, "");
        if (strName.isEmpty())
        {
            v = inflater.inflate(R.layout.activity_registration_with_dopinfo, container, false);
        }
        else{
            v = inflater.inflate(R.layout.fragment_profile, container, false);
        }

        return v;
    }
}
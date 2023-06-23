package com.example.smartlab.ui.home;

import static com.google.android.material.color.MaterialColors.getColor;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.smartlab.APIInterface;
import com.example.smartlab.AdapterForAnalis;
import com.example.smartlab.Analysis;
import com.example.smartlab.AnalysisAdapter;
import com.example.smartlab.AnalysisResult;
import com.example.smartlab.Banner;
import com.example.smartlab.BannerAdapter;
import com.example.smartlab.BannerResult;
import com.example.smartlab.DbHelperK;
import com.example.smartlab.PreferencesManager;
import com.example.smartlab.R;
import com.example.smartlab.RetrofitClient;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AnalyzFragment extends Fragment implements View.OnClickListener{
    View v;
    APIInterface apiInterface;



    List<AnalysisResult> analysisResult;
    List<Analysis> analyses;
    List<Analysis> analisResponseList;
    AnalysisAdapter analysisAdapter;

    List<Banner> bannerList;
    List<Banner> resultBannerList;
    BannerAdapter bannerAdapter;

    Button btnPopular, btnComplex, btnCovid, btnOncolog, myButton;
    ViewPager viewPager;

    public AnalyzFragment(){

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

       v = inflater.inflate(R.layout.fragment_analyz, container, false);



        bannerList = new ArrayList<>();
        RecyclerView listViewBanner = v.findViewById(R.id.listBanner);

        apiInterface = RetrofitClient.getClient().create(APIInterface.class);

        viewPager = v.findViewById(R.id.viewPager);

        AdapterForAnalis adapter1 = new AdapterForAnalis(getChildFragmentManager());
        viewPager.setAdapter(adapter1);
        btnPopular = v.findViewById(R.id.btnPopular);
        btnComplex = v.findViewById(R.id.btnComplex);
        btnCovid = v.findViewById(R.id.btnCovid);
        btnOncolog = v.findViewById(R.id.btnOncolog);

        btnPopular.setEnabled(false);
        btnPopular.setOnClickListener(this::onClick);
        btnComplex.setOnClickListener(this::onClick);
        btnCovid.setOnClickListener(this::onClick);
        btnOncolog.setOnClickListener(this::onClick);

        Call<BannerResult> callBanner = apiInterface.getNews();
        callBanner.enqueue(new Callback<BannerResult>() {
            @Override
            public void onResponse(Call<BannerResult> call, Response<BannerResult> response) {
                if (response.isSuccessful()){
                    resultBannerList = response.body().getBanners();
                    bannerList = new ArrayList<>();
                    bannerList.addAll(resultBannerList);
                    bannerAdapter = new BannerAdapter(v.getContext(), resultBannerList);
                    listViewBanner.setLayoutManager(new LinearLayoutManager(v.getContext(), LinearLayoutManager.HORIZONTAL, false));
                    listViewBanner.setAdapter(bannerAdapter);
                }
            }
            @Override
            public void onFailure(Call<BannerResult> call, Throwable t) {
                Toast.makeText(getActivity(), "Ошибка загрузки данных "+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

       return v;
    }

    public void onClick(View view){
        switch (viewPager.getCurrentItem()){
            case 0:
                btnPopular.setEnabled(true);
                btnPopular.setHintTextColor(getResources().getColor(R.color.grey_text));
                btnPopular.setBackground(getResources().getDrawable(R.drawable.button_white_roundedcorn));
                btnPopular.setPadding(25,25,25,25);
                break;
            case 1:
                btnCovid.setEnabled(true);
                btnCovid.setHintTextColor(getResources().getColor(R.color.grey_text));
                btnCovid.setBackground(getResources().getDrawable(R.drawable.button_white_roundedcorn));
                btnCovid.setPadding(25,25,25,25);
                break;
            case 2:
                btnComplex.setEnabled(true);
                btnComplex.setHintTextColor(getResources().getColor(R.color.grey_text));
                btnComplex.setBackground(getResources().getDrawable(R.drawable.button_white_roundedcorn));
                btnComplex.setPadding(25,25,25,25);
                break;
            case 3:
                btnOncolog.setEnabled(true);
                btnOncolog.setHintTextColor(getResources().getColor(R.color.grey_text));
                btnOncolog.setBackground(getResources().getDrawable(R.drawable.button_white_roundedcorn));
                btnOncolog.setPadding(25,25,25,25);
                break;
        }
        Button bt=(Button) view;
        if(bt.getId()==R.id.btnPopular) {
            viewPager.setCurrentItem(0,true);
            bt.setEnabled(false);
            bt.setHintTextColor(getResources().getColor(R.color.white));
            bt.setBackground(getResources().getDrawable(R.drawable.button_blue_roundedcorn));
            bt.setPadding(25,25,25,25);
        }

        if(bt.getId()==R.id.btnCovid) {
            viewPager.setCurrentItem(1, true);
            bt.setEnabled(false);
            bt.setHintTextColor(getResources().getColor(R.color.white));
            bt.setBackground(getResources().getDrawable(R.drawable.button_blue_roundedcorn));
            bt.setPadding(25,25,25,25);
        }

        if(bt.getId()==R.id.btnComplex) {
            viewPager.setCurrentItem(2,true);
            bt.setEnabled(false);
            bt.setHintTextColor(getResources().getColor(R.color.white));
            bt.setBackground(getResources().getDrawable(R.drawable.button_blue_roundedcorn));
            bt.setPadding(25,25,25,25);
        }

        if(bt.getId()==R.id.btnOncolog) {
            viewPager.setCurrentItem(3,true);
            bt.setEnabled(false);
            bt.setHintTextColor(getResources().getColor(R.color.white));
            bt.setBackground(getResources().getDrawable(R.drawable.button_blue_roundedcorn));
            bt.setPadding(25,25,25,25);
        }
    }


}
